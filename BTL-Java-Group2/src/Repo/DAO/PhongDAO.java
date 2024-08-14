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
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "UPDATE phong SET id = ?, diaChi = ?, gia = ?, moTa = ?, dienTich = ?, hinhAnh = ?, chu = ?, khach = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setLong(1, obj.getId());
                ps.setLong(2, obj.getDiaChi().getId());
                ps.setDouble(3, obj.getGia());
                ps.setString(4, obj.getMoTa());
                ps.setDouble(5, obj.getDienTich());
                ps.setString(6, String.valueOf(obj.getHinhAnh()));
                ps.setLong(7, obj.getChu().getId());
                ps.setLong(8, obj.getKhach().getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePhong(Long id, DiaChi diaChi, double gia, String moTa, double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" UPDATE phong SET 1=1 ");
            if(id != null) {
                stringBuilder.append(" id LIKE ? ");
            }
            if(diaChi != null) {
                stringBuilder.append(" diaChi LIKE? ");
            }
            if(gia != 0) {
                stringBuilder.append(" gia LIKE ? ");
            }
            if(moTa != null) {
                stringBuilder.append(" moTa LIKE? ");
            }
            if(dienTich != 0) {
                stringBuilder.append(" dienTich LIKE? ");
            }
            if(hinhAnh != null) {
                stringBuilder.append(" hinhAnh LIKE? ");
            }
            if(chu != null) {
                stringBuilder.append(" chu LIKE? ");
            }
            if(khach != null) {
                stringBuilder.append(" khach LIKE? ");
            }
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
    public void delete(Phong obj) {

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
