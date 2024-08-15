package Repo.DAO;

import Model.KhachHang;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class KhachHangDAO implements DAOinterface<KhachHang> {

    @Override
    public void insert(KhachHang obj) {

    }

    @Override
    public void update(KhachHang obj) {

    }

    @Override
    public void delete(KhachHang obj) {
        if (obj.getId() == null){
            System.out.println("KhachHang id is null");
            return;
        }
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "DELETE FROM KhachHang WHERE KhachHangID = ?";
            try(PreparedStatement ps = con.prepareStatement(query)) {
                ps.setLong(1, obj.getId());
                ps.execute();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
