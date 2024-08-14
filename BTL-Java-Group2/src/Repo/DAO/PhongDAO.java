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
    public void update(int id, DiaChi diaChi, double gia, String moTa, double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {
    }


    @Override
    public void delete(Phong obj) {
        try {
            if (obj.getId() == null) {
                System.out.println("Khong the thuc hien");
                return;
            }
            Connection con = JDBCUtil.getConnection();
            String query = "UPDATE phong SET khachHang = NULL WHERE id = ? ";
            try(PreparedStatement ps = con.prepareStatement(query)){
                ps.setLong(1, obj.getId());
                ps.executeUpdate();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Phong findById(int id) {
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
                    int idChuPhong = rs.getInt("ChuTroID");
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
