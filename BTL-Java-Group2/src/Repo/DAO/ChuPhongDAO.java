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

    
    public void insert(ChuPhong obj) {
        try {
            Connection con = JDBCUtil.getConnection();
            String query = " INSERT INTO ChuTro(ChuTroID, HoTen, NgaySinh, GioiTinh, SoCanCuocCongDan, SoDienThoai, TaiKhoan, MatKhau) VALUES\n" +
                    "(NEXT VALUE FOR ChuTro_seq, ?, ?, ?, ?, ?, ?, ? ) ";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, obj.getHoTen());
                ps.setDate(2, new java.sql.Date(obj.getNgaySinh().getTime()));
                ps.setString(3, obj.getGioiTinh());
                ps.setString(4, obj.getCCCD());
                ps.setString(5, obj.getSoDt());
                ps.setString(6, obj.getTenTaiKhoan());
                ps.setString(7, obj.getMatKhau());
                ps.executeUpdate();
            }
            System.out.println("Insert Successful !");
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void update(Long id, String hoTen, Date ngaySinh, String gioiTinh, String CCCD, String soDt, String tenTaiKhoan, String matKhau) {
        try{
            Connection conn = JDBCUtil.getConnection();
            StringBuilder query = new StringBuilder();
            query.append(" UPDATE ChuPhong SET ");
            if (hoTen != null) {
                query.append(" hoTen = ?, ");
            }
            if (ngaySinh != null) {
                query.append(" ngaySinh = ?, ");
            }
            if (gioiTinh != null) {
                query.append(" gioiTinh = ?, ");
            }
            if (CCCD != null) {
                query.append(" CCCD = ?, ");
            }
            if (soDt != null) {
                query.append(" soDt = ?, ");
            }
            if (tenTaiKhoan != null) {
                query.append(" tenTaiKhoan = ?, ");
            }
            if (matKhau != null) {
                query.append(" matKhau = ?, ");
            }
            query.append(" WHERE id = ? ");
            try {
                PreparedStatement ps = conn.prepareStatement(query.toString());
                ps.setString(1, hoTen);
                ps.setDate(2, (java.sql.Date) ngaySinh);
                ps.setString(3, gioiTinh);
                ps.setString(4, CCCD);
                ps.setString(5, soDt);
                ps.setString(6, tenTaiKhoan);
                ps.setString(7, matKhau);
                ps.setLong(8, id);
                ResultSet rs = ps.executeQuery();

                JDBCUtil.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(ChuPhong obj) {
        if (obj.getId() == null) {
            System.out.println("loi id is null");
            return;
        }

        try {
            Connection con = JDBCUtil.getConnection();
            String query = "DELETE FROM ChuTro WHERE ChuTroID=?";
            try(PreparedStatement ps = con.prepareStatement(query)) {
                ps.setLong(1, obj.getId());
                ps.execute();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    
    public ChuPhong findById(Long id) {
        Connection co = JDBCUtil.getConnection();
        String query = " SELECT * FROM ChuTro WHERE ChuTroID=? ";
        ChuPhong ketQua = null;
        try(PreparedStatement ps = co.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Long chuTroId = rs.getLong("ChuTroId");
                String hoTen = rs.getString("HoTen");
                Date ngaySinh = new java.util.Date(rs.getDate("NgaySinh").getTime());
                String gioiTinh = rs.getString("GioiTinh");
                String cccd = rs.getString("SoCanCuocCongDan");
                String soDienThoai = rs.getString("SoDienThoai");
                String taiKhoan = rs.getString(("TaiKhoan"));
                String matKhau = rs.getString(("MatKhau"));
                ketQua = new ChuPhong(chuTroId, hoTen, ngaySinh, gioiTinh, cccd, soDienThoai, taiKhoan, matKhau);
            }
            JDBCUtil.closeConnection(co);
        } catch(Exception e){
            e.printStackTrace();
        }
        return ketQua;
    }

    public List<Phong> findPhong(ChuPhong chu){
        List<Phong> listPhong = new ArrayList<>();

        Connection con = JDBCUtil.getConnection();
        String query = " SELECT * FROM Tro WHERE ChuTroID = ? ";
        try(PreparedStatement ps = con.prepareStatement(query)) {
            ps.setLong(1, chu.getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Phong p = new Phong();
                p.setId(rs.getLong("TroID"));
                p.setDiaChi(DiaChiDAO.getInstance().findById(rs.getLong("DiaChiID")));
                p.setGia((rs.getDouble("GiaPhong")));
                p.setMoTa(rs.getString("MoTa"));
                p.setHinhAnh(rs.getString("HinhAnh"));
                p.setChu(ChuPhongDAO.getInstance().findById(chu.getId()));
                p.setKhach(KhachHangDAO.getInstance().findById(rs.getLong("KhachHangID")));
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
