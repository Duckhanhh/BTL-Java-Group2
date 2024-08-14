package Repo.DAO;

import database.JDBCUtil;
import Model.DiaChi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DiaChiDAO implements DAOinterface<DiaChi>{
    public static DiaChiDAO getInstance() {
        return new DiaChiDAO();
    }

    @Override
    public void insert(DiaChi obj) {

    }

    @Override
    public void update(DiaChi obj) {

    }

    @Override
    public void delete(DiaChi obj) {

    }

    @Override
    public DiaChi findById(Long id) {
        Connection co = JDBCUtil.getConnection();
        String query = " SELECT * FROM DiaChi WHERE id=? ";
        DiaChi ketQua = null;
        try(PreparedStatement ps = co.prepareStatement(query)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery(query);
            Long DiaChiId = rs.getLong("DiaChiID");
            Long soNha = rs.getLong("SoNha");
            String tenDuong = rs.getString("TenDuong");
            String tenPhuongXa = rs.getString("PhuongXa");
            String tenQuanHuyen = rs.getString("HuyenQuan");
            String tenTinhThanhPho = rs.getString("TinhThanhPho");
            ketQua = new DiaChi(DiaChiId, soNha, tenDuong, tenPhuongXa, tenQuanHuyen, tenTinhThanhPho);
            JDBCUtil.closeConnection(co);
        } catch(Exception e){
            e.printStackTrace();
        }
        return ketQua;
    }
}
