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
    public void insert(ChuPhong chuPhong) {
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "INSERT INTO chuPhong VALUES(?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)){
                ps.setInt(1, chuPhong.getId());
                ps.setString(2, chuPhong.getHoTen());
                ps.setDate(3, (Date) chuPhong.getNgaySinh());
                ps.setString(4, chuPhong.getGioiTinh());
                ps.setString(5, chuPhong.getCCCD());
                ps.setString(6, chuPhong.getSoDt());
                ps.setString(7, chuPhong.getTenTaiKhoan());
                ps.setString(8, chuPhong.getMatKhau());
                ps.execute();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(ChuPhong obj) {

    }

    @Override
    public void delete(ChuPhong chuPhong) {
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "DELETE FROM chuPhong WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)){
                ps.setInt(1, chuPhong.getId());
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
