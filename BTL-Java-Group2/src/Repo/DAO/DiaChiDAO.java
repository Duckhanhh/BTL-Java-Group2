package Repo.DAO;

import database.JDBCUtil;
import Model.DiaChi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DiaChiDAO {
    public static DiaChiDAO getInstance() {
        return new DiaChiDAO();
    }


    public void insertDiaChi(String tinh, String huyen, String xa, String duong, String soNha) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "INSERT INTO DiaChi(DiaChiID, TinhThanhPho, HuyenQuan, PhuongXa, TenDuong, SoNha) VALUES(NEXT VALUE FOR DiaChi_seq,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, tinh);
            ps.setString(2, huyen);
            ps.setString(3, xa);
            ps.setString(4, duong);
            ps.setString(5, soNha);
            ps.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long timDiaChi(String tinh, String huyen, String xa, String duong, String soNha) {
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM DiaChi WHERE 1=1 ";
            if (tinh != null) {
                sql += " AND TinhThanhPho LIKE ? ";
            }
            if (huyen != null) {
                sql += " AND HuyenQuan LIKE ? ";
            }
            if (xa != null) {
                sql += " AND PhuongXa LIKE ? ";
            }
            if (duong != null) {
                sql += " AND TenDuong LIKE ? ";
            }
            if (soNha != null) {
                sql += " AND SoNha LIKE ? ";
            }
            PreparedStatement ps = con.prepareStatement(sql);
            if (tinh != null) {
                ps.setString(1, tinh);
            }
            if (huyen != null) {
                ps.setString(2, huyen);
            }
            if (xa != null) {
                ps.setString(3, xa);
            }
            if (duong != null) {
                ps.setString(4, duong);
            }
            if (soNha != null) {
                ps.setString(5, soNha);
            }
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(1);
            } else {
                return -1L;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }
    }

    public void update(DiaChi obj) {

    }


    public void delete(DiaChi obj) {

    }


    public DiaChi findById(Long id) {
        Connection co = JDBCUtil.getConnection();
        String query = " SELECT * FROM DiaChi WHERE DiaChiID=? ";
        DiaChi ketQua = null;
        try (PreparedStatement ps = co.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long DiaChiId = rs.getLong("DiaChiID");
                String soNha = rs.getString("SoNha");
                String tenDuong = rs.getString("TenDuong");
                String tenPhuongXa = rs.getString("PhuongXa");
                String tenQuanHuyen = rs.getString("HuyenQuan");
                String tenTinhThanhPho = rs.getString("TinhThanhPho");
                ketQua = new DiaChi(DiaChiId, soNha, tenDuong, tenPhuongXa, tenQuanHuyen, tenTinhThanhPho);
            }
            JDBCUtil.closeConnection(co);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
