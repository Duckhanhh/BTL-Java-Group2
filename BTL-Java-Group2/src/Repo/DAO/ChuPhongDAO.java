package Repo.DAO;

import Model.ChuPhong;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class ChuPhongDAO implements DAOinterface<ChuPhong>{
    public static ChuPhongDAO getInstance() {
        return new ChuPhongDAO();
    }

    @Override
    public void insert(ChuPhong obj) {

    }

    @Override
    public void update(ChuPhong chuPhong) {
        try{
            Connection conn = JDBCUtil.getConnection();
            StringBuilder query = new StringBuilder("UPDATE ChuPhong SET ");
            if (chuPhong.getHoTen() != null) {
                query.append("hoTen = ?, ");
            }
            if (chuPhong.getNgaySinh() != null) {
                query.append("ngaySinh = ?, ");
            }
            if (chuPhong.getGioiTinh() != null) {
                query.append("gioiTinh = ?, ");
            }
            if (chuPhong.getCCCD() != null) {
                query.append("CCCD = ?, ");
            }
            if (chuPhong.getSoDt() != null) {
                query.append("soDt = ?, ");
            }
            if (chuPhong.getTenTaiKhoan() != null) {
                query.append("tenTaiKhoan = ?, ");
            }
            if (chuPhong.getMatKhau() != null) {
                query.append("matKhau = ?, ");
            }
            query.append(" WHERE id = ?");
            try (PreparedStatement ps = conn.prepareStatement(query.toString())){
                int index = 1;
                if (chuPhong.getHoTen() != null) {
                    ps.setString(index++, chuPhong.getHoTen());
                }
                if (chuPhong.getNgaySinh() != null) {
                    ps.setDate(index++, new java.sql.Date(chuPhong.getNgaySinh().getTime()));
                }
                if (chuPhong.getGioiTinh() != null) {
                    ps.setString(index++, chuPhong.getGioiTinh());
                }
                if (chuPhong.getCCCD() != null) {
                    ps.setString(index++, chuPhong.getCCCD());
                }
                if (chuPhong.getSoDt() != null) {
                    ps.setString(index++, chuPhong.getSoDt());
                }
                if (chuPhong.getTenTaiKhoan() != null) {
                    ps.setString(index++, chuPhong.getTenTaiKhoan());
                }
                if (chuPhong.getMatKhau() != null) {
                    ps.setString(index++, chuPhong.getMatKhau());
                }
                ps.setLong(index, chuPhong.getId());
                ps.execute();
            }
            JDBCUtil.closeConnection(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ChuPhong chuPhong) {
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "DELETE FROM chuPhong WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)){
                ps.setLong(1, chuPhong.getId());
                ps.execute();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public ChuPhong findById(int id) {
        return null;
    }

    @Override
    public List<ChuPhong> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        return List.of();
    }
}
