package Repo.DAO;

import Model.Phong;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhongDAO implements DAOinterface<Phong> {
    public static PhongDAO getInstance() {
        return new PhongDAO();
    }

    @Override
    public void insert(Phong phong) {
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "INSERT INTO phong VALUES(?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setLong(1, phong.getId());
                ps.execute();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Phong obj) {

    }

    @Override
    public void delete(Phong obj) {

    }

    @Override
    public Phong findById(int id) {
        return null;
    }

    @Override
    public List<Phong> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        List<Phong> list = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" SELECT * FROM phong WHERE 1=1 ");
            if (Tinh != null) {
                stringBuilder.append(" Tinh LIKE ? ");
            }
            try (PreparedStatement ps = con.prepareStatement(stringBuilder.toString())){
                ps.setString(1, Tinh);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Phong p = new Phong();
                    p.setId(rs.getInt("id"));
                    int idChuPhong = rs.getInt("ChuTroID");
                    p.setChu(ChuPhongDAO.getInstance().findById(idChuPhong));
                    list.add(p);
                }
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
