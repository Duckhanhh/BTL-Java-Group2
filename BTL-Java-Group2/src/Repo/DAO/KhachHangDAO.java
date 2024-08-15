package Repo.DAO;

import Model.*;

import database.JDBCUtil;
import database.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhachHangDAO implements DAOinterface<KhachHang>{
    public static KhachHangDAO getInstance() {
        return new KhachHangDAO();
    }

    @Override
    public void insert(KhachHang obj) {
        try {
            Connection con = JDBCUtil.getConnection();
            String query = " INSERT INTO KhachHang(KhachHangID, HoTen, NgaySinh, GioiTinh, SoCanCuocCongDan, SoDienThoai, TaiKhoan, MatKhau) VALUES\n" +
                    "(NEXT VALUE FOR KhachHang_seq, ?, ?, ?, ?, ?, ?, ? ); ";
            try(PreparedStatement ps = con.prepareStatement(query)){
                ps.setString(1, obj.getHoTen());
                ps.setDate(2, new java.sql.Date(obj.getNamSinh().getTime()));
                ps.setString(3, obj.getGioiTinh());
                ps.setString(4, obj.getCccd());
                ps.setString(5, obj.getSoDienThoai());
                ps.setString(6, obj.getEmail());
                ps.setString(7, obj.getMatKhau());
                ps.executeUpdate();
            }
            System.out.println("Insert Successful !");
            JDBCUtil.closeConnection(con);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(KhachHang obj) {

    }

    @Override
    public void delete(KhachHang obj) {

    }

    @Override
    public KhachHang findById(Long id) {
        Connection co = JDBCUtil.getConnection();
        String query = " SELECT * FROM KhachHang WHERE KhachHangID=? ";
        KhachHang ketQua = null;
        try (PreparedStatement ps = co.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long KhachHangID = rs.getLong("KhachHangID");
                String hoTen = rs.getString("HoTen");
                Date namSinh = new java.util.Date(rs.getDate("NgaySinh").getTime());
                String gioiTinh = rs.getString("GioiTinh");
                String cccd = rs.getString("SoCanCuocCongDan");
                String soDienThoai = rs.getString("SoDienThoai");
                String email = rs.getString("TaiKhoan");
                String matKhau = rs.getString("MatKhau");
                ketQua = new KhachHang(KhachHangID, hoTen, namSinh, gioiTinh, cccd, soDienThoai, email, matKhau);
            }
            JDBCUtil.closeConnection(co);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    public List<Phong> findPhong(KhachHang khach){
        List<Phong> listPhong = new ArrayList<>();

        Connection con = JDBCUtil.getConnection();
        String query = " SELECT * FROM Tro WHERE KhachHangID = ? ";
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setLong(1, khach.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                p.setId(rs.getLong("TroID"));
                p.setDiaChi(DiaChiDAO.getInstance().findById(rs.getLong("DiaChiID")));
                p.setGia((rs.getDouble("GiaPhong")));
                p.setMoTa(rs.getString("MoTa"));
                p.setHinhAnh(rs.getString("HinhAnh"));
                p.setChu(ChuPhongDAO.getInstance().findById(rs.getLong("ChuPhongID")));
                p.setKhach(KhachHangDAO.getInstance().findById(khach.getId()));
                p.setDienTich(rs.getDouble("DienTich"));
                listPhong.add(p);
            }
            JDBCUtil.closeConnection(con);
        } catch(Exception e){
            e.printStackTrace();
        }
        return listPhong;
    }
}
