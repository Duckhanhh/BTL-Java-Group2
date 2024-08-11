package Repo;

import Model.Phong;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class PhongDAO implements DAOinterface<Phong> {
    public static PhongDAO getInstance() {
        return new PhongDAO();
    }

    @Override
    public void insert(Phong phong) {
        Connection con = JDBCUtil.getConnection();
        try {
            String query = "INSERT INTO phong VALUES(?,?,?,?,?,?,?,?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setInt(1, phong.getId());
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
    public List<Phong> findAll() {
        return List.of();
    }
}
