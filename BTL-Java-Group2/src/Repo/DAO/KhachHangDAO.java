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
            StringBuilder query = new StringBuilder("UPDATE KhachHang SET ");
            if (khachHang.getHoTen() != null) {
                query.append("hoTen = ?, ");
            }
            if (khachHang.getNamSinh() != null) {
                query.append("ngaySinh = ?, ");
            }
            if (khachHang.getGioiTinh() != null) {
                query.append("gioiTinh = ?, ");
            }
            if (khachHang.getCccd() != null) {
                query.append("CCCD = ?, ");
            }
            if (khachHang.getSoDienThoai() != null) {
                query.append("soDt = ?, ");
            }
            if (khachHang.getEmail() != null) {
                query.append("tenTaiKhoan = ?, ");
            }
            if (khachHang.getMatKhau() != null) {
                query.append("matKhau = ?, ");
            }
            query.append(" WHERE id = ?");
            try (PreparedStatement ps = con.prepareStatement(query.toString())){
                int index = 1;
                if (khachHang.getHoTen() != null) {
                    ps.setString(index++, khachHang.getHoTen());
                }
                if (khachHang.getNamSinh() != null) {
                    ps.setInt(index++, khachHang.getNamSinh());
                }
                if (khachHang.getGioiTinh() != null) {
                    ps.setString(index++, khachHang.getGioiTinh());
                }
                if (khachHang.getCccd() != null) {
                    ps.setString(index++, khachHang.getCccd());
                }
                if (khachHang.getSoDienThoai() != null) {
                    ps.setString(index++, khachHang.getSoDienThoai());
                }
                if (khachHang.getEmail() != null) {
                    ps.setString(index++, khachHang.getEmail());
                }
                if (khachHang.getMatKhau() != null) {
                    ps.setString(index++, khachHang.getMatKhau());
                }
                ps.setLong(index, khachHang.getId());
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
