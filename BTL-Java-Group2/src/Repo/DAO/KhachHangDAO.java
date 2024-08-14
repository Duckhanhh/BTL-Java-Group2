package Repo.DAO;

import Model.KhachHang;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class KhachHangDAO implements DAOinterface<KhachHang>{
        public static KhachHangDAO getInstance(){
            return new KhachHangDAO();
    }

    @Override
    public void insert(KhachHang obj) {

    }

    @Override
    public void update(KhachHang khachHang) {
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "UPDATE khachHang SET hoTen = ?, namSinh = ?, gioiTInh = ?, cccd = ?, soDienThoai = ?, email = ?, matKhau = ? WHERE id = ?";
            try (PreparedStatement ps = con.prepareStatement(query)){
                ps.setString(1, khachHang.getHoTen());
                ps.setInt(2, khachHang.getNamSinh());
                ps.setString(3, khachHang.getGioiTinh());
                ps.setString(4, khachHang.getCccd());
                ps.setString(5, khachHang.getSoDienThoai());
                ps.setString(6, khachHang.getEmail());
                ps.setString(7, khachHang.getMatKhau());
                ps.setLong(8, khachHang.getId());
                ps.execute();

            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(KhachHang obj) {

    }

    @Override
    public KhachHang findById(int id) {
        return null;
    }

    @Override
    public List<KhachHang> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        return List.of();
    }
}
