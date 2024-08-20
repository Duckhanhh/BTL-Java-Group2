package Repo.DAO;

import Model.*;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChuPhongDAO {
    public static ChuPhongDAO getInstance() {
        return new ChuPhongDAO();
    }

    public boolean updateChuPhong(Long id, String hoTen, Date ngaySinh, String gioiTinh, String CCCD, String soDt) {
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" UPDATE ChuTro SET ");

            boolean firstField = true;

            if (hoTen != null) {
                stringBuilder.append(" HoTen = ?");
                firstField = false;
            }
            if (ngaySinh != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append(" NgaySinh = ?");
                firstField = false;
            }
            if (gioiTinh != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append(" GioiTinh = ?");
                firstField = false;
            }
            if (CCCD != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append(" SoCanCuocCongDan = ?");
                firstField = false;
            }
            if (soDt != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append(" SoDienThoai = ?");
            }

            stringBuilder.append(" WHERE ChuTroID = ?");

            PreparedStatement ps = con.prepareStatement(stringBuilder.toString());

            int paramIndex = 1;

            if (hoTen != null) {
                ps.setString(paramIndex++, hoTen);
            }
            if (ngaySinh != null) {
                ps.setDate(paramIndex++, (java.sql.Date) ngaySinh);
            }
            if (gioiTinh != null) {
                ps.setString(paramIndex++, gioiTinh);
            }
            if (CCCD != null) {
                ps.setString(paramIndex++, CCCD);
            }
            if (soDt != null) {
                ps.setString(paramIndex++, soDt);
            }

            ps.setLong(paramIndex, id);

            int isChange = ps.executeUpdate();
            JDBCUtil.closeConnection(con);
            return isChange > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteChuPhong(Long idChuPhong) {
        if (idChuPhong == null) {
            System.out.println("id is null");
            return false;
        }
        try {
            PhongDAO.getInstance().xoaPhongViXoaChu(idChuPhong);
            Connection con = JDBCUtil.getConnection();
            String query = "DELETE FROM ChuTro WHERE ChuTroID = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setLong(1, idChuPhong);
                int isChange = ps.executeUpdate();
                JDBCUtil.closeConnection(con);
                JDBCUtil.closeConnection(con);
                return isChange > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public ChuPhong findById(Long id) {
        Connection co = JDBCUtil.getConnection();
        String query = " SELECT * FROM ChuTro WHERE ChuTroID=? ";
        ChuPhong ketQua = null;
        try (PreparedStatement ps = co.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long chuTroId = rs.getLong("ChuTroId");
                String hoTen = rs.getString("HoTen");
                java.sql.Date ngaySinhSql = rs.getDate("NgaySinh");
                Date ngaySinh = (ngaySinhSql != null) ? new Date(ngaySinhSql.getTime()) : null;
                String gioiTinh = rs.getString("GioiTinh");
                String cccd = rs.getString("SoCanCuocCongDan");
                String soDienThoai = rs.getString("SoDienThoai");
                String taiKhoan = rs.getString(("TaiKhoan"));
                String matKhau = rs.getString(("MatKhau"));
                ketQua = new ChuPhong(chuTroId, hoTen, ngaySinh, gioiTinh, cccd, soDienThoai, taiKhoan, matKhau);
            }
            JDBCUtil.closeConnection(co);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

}
