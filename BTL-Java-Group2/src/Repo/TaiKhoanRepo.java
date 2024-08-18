package Repo;

import Model.ChuPhong;
import Model.KhachHang;
import data.DataDangNhap;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaiKhoanRepo {
    public static TaiKhoanRepo getInstance() {
        return new TaiKhoanRepo();
    }

    public boolean DangNhap(String username, String password, Long role) {
        boolean isAuthenticated = false;
        try {
            Connection connection = JDBCUtil.getConnection();
            String tableName;
            if (role == 0) {
                tableName = "ChuTro";
            } else {
                tableName = "KhachHang";
            }
            String sql = "SELECT * FROM " + tableName + " WHERE TaiKhoan=? AND MatKhau=?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    isAuthenticated = true;
                    if (role == 0) {
                        DataDangNhap.chu = new ChuPhong();
                        DataDangNhap.chu.setId(resultSet.getLong("ChuTroID"));
                        DataDangNhap.chu.setHoTen(resultSet.getString("HoTen"));
                        DataDangNhap.chu.setNgaySinh(resultSet.getDate("NgaySinh"));
                        DataDangNhap.chu.setGioiTinh(resultSet.getString("GioiTinh"));
                        DataDangNhap.chu.setCCCD(resultSet.getString("SoCanCuocCongDan"));
                        DataDangNhap.chu.setSoDt(resultSet.getString("SoDienThoai"));
                        System.out.println(DataDangNhap.chu);
                    } else {
                        DataDangNhap.khachHang = new KhachHang();
                        DataDangNhap.khachHang.setId(resultSet.getLong("KhachHangID"));
                        DataDangNhap.khachHang.setHoTen(resultSet.getString("HoTen"));
                        DataDangNhap.khachHang.setNamSinh(resultSet.getDate("NgaySinh"));
                        DataDangNhap.khachHang.setGioiTinh(resultSet.getString("GioiTinh"));
                        DataDangNhap.khachHang.setCccd(resultSet.getString("SoCanCuocCongDan"));
                        DataDangNhap.khachHang.setSoDienThoai(resultSet.getString("SoDienThoai"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }


    public boolean DangKy(String username, String password, Long role) {
        boolean isExist = DangNhap(username, password, role);
        if (isExist) {
            return false;
        }
        try {
            Connection connection = JDBCUtil.getConnection();
            String tableName;
            String seq;
            if (role == 0) {
                tableName = "ChuTro";
                seq = "ChuTro_seq";
            } else {
                tableName = "KhachHang";
                seq = "KhachHang_seq";
            }
            String sql = "INSERT INTO " + tableName + " (" + tableName + "ID, TaiKhoan, MatKhau) " +
                    "VALUES (NEXT VALUE FOR " + seq + ", ?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                int affectedRows = ps.executeUpdate();
                return affectedRows > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
