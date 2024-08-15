package Repo.DAO;

import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;
import Model.Phong;
import database.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongDAO implements DAOinterface<Phong> {
    public static PhongDAO getInstance() {
        return new PhongDAO();
    }

    @Override
    public void insert(Phong phong) {
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "INSERT INTO phong VALUES(?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setLong(1, phong.getId());
                ps.execute();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Phong obj) {

    }

    @Override
    public void delete(Phong obj) {
        try {
            if(obj.getId() == null) {
                System.out.println("Khong the thuc hien");
                return;
            }
            Connection con = JDBCUtil.getConnection();
            String query = "UPDATE Tro SET KhachHangID = NULL WHERE TroID = ?";
            try(PreparedStatement ps = con.prepareStatement(query)) {
                ps.setLong(1, obj.getId());
                ps.executeUpdate();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhong(Long id, DiaChi diaChi, Double gia, String moTa, Double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" UPDATE Tro SET");
            if(gia != null) {
                stringBuilder.append(" GiaPhong = ?, ");
            }
            if(moTa != null) {
                stringBuilder.append(" MoTa LIKE ?, ");
            }
            if(hinhAnh != null) {
                stringBuilder.append(" HinhAnh LIKE ?, ");
            }
            if(chu.getId() != null) {
                stringBuilder.append(" ChuTroID = ?, ");
            }
            if(khach.getId() != null) {
                stringBuilder.append(" KhachHangID = ?, ");
            }
            if(diaChi.getId() != null) {
                stringBuilder.append(" DiaChiID = ?, ");
            }
            if(dienTich != null) {
                stringBuilder.append(" DienTich = ?, ");
            }
            stringBuilder.append(" WHERE TroID = ? ");
            try {
                PreparedStatement ps = con.prepareStatement(stringBuilder.toString());
                ps.setLong(1, id);
                ps.setLong(2, diaChi.getId());
                ps.setDouble(3, gia);
                ps.setString(4, moTa);
                ps.setDouble(5, dienTich);
                ps.setString(6, hinhAnh);
                ps.setLong(7, chu.getId());
                ps.setLong(8, khach.getId());
                ResultSet rs = ps.executeQuery();

                JDBCUtil.closeConnection(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Phong findById(Long id) {
        return null;
    }


    public List<Phong> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        List<Phong> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" SELECT * FROM phong WHERE 1=1 ");
            if (Tinh != null) {
                stringBuilder.append(" Tinh LIKE ? ");
            }
            try (PreparedStatement ps = con.prepareStatement(stringBuilder.toString())){
                ps.setString(1, Tinh);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Phong p = new Phong();
                    p.setId(rs.getLong("id"));
                    Long idChuPhong = rs.getLong("ChuTroID");
                    p.setChu(ChuPhongDAO.getInstance().findById(idChuPhong));
                    list.add(p);
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
