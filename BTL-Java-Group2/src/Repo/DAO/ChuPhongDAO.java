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
            String query = "UPDATE ChuPhong SET hoTen = ?, ngaySinh = ?, gioiTinh = ?, CCCD = ?, soDt = ?, tenTaiKhoan = ?, matKhau = ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)){
                ps.setString(1, chuPhong.getHoTen());
                ps.setDate(2, (Date) chuPhong.getNgaySinh());
                ps.setString(3, chuPhong.getGioiTinh());
                ps.setString(4, chuPhong.getCCCD());
                ps.setString(5, chuPhong.getSoDt());
                ps.setString(6, chuPhong.getTenTaiKhoan());
                ps.setString(7, chuPhong.getMatKhau());
                ps.setInt(8, chuPhong.getId());
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
                ps.setInt(1, chuPhong.getId());
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
