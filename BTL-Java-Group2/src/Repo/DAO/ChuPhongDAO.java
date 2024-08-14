package Repo.DAO;

import Model.ChuPhong;
import database.JDBCUtil;

import java.sql.Connection;
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
    public void update(ChuPhong obj) {

    }

    @Override
    public void delete(ChuPhong obj) {
        try {
            Connection con = JDBCUtil.getConnection() ;
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



    @Override
    public ChuPhong findById(int id) {
        return null;
    }

    @Override
    public List<ChuPhong> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        return List.of();
    }
}
