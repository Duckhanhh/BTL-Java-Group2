package Repo.DAO;

import Model.ChuPhong;
import Model.KhachHang;
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
    public Phong findById(Long id) {
        return null;
    }

    public List<Phong> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu, int timKiemGiaDen) {
        List<Phong> list = new ArrayList<>();
        int num_col = 1;
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" SELECT * FROM Tro INNER JOIN DiaChi ON Tro.DiaChiID = DiaChi.DiaChiID" +
                    " WHERE 1=1 ");
            //Doan nay de hoan thien cau lenh sql
            if (Tinh != null) {
                stringBuilder.append(" AND TinhThanhPho LIKE ? ");
            }
            if (Huyen != null) {
                stringBuilder.append(" AND HuyenQuan LIKE ? ");
            }
            if (Xa != null) {
                stringBuilder.append(" AND PhuongXa LIKE ? ");
            }
            if (TenDuong != null) {
                stringBuilder.append(" AND TenDuong LIKE ? ");
            }
            if (soNha != null) {
                stringBuilder.append(" AND SoNha LIKE ? ");
            }
            stringBuilder.append(" AND GiaPhong > ? AND GiaPhong < ? ");

            try (PreparedStatement ps = con.prepareStatement(stringBuilder.toString())){
                if (Tinh != null) {
                    ps.setString(num_col, Tinh);
                    num_col++;
                }
                if (Huyen != null) {
                    ps.setString(num_col, Huyen);
                    num_col++;
                }
                if (Xa != null) {
                    ps.setString(num_col, Xa);
                    num_col++;
                }
                if (TenDuong != null) {
                    ps.setString(num_col, TenDuong);
                    num_col++;
                }
                if (soNha != null) {
                    ps.setString(num_col, soNha);
                    num_col++;
                }
                ps.setInt(num_col, timKiemGiaTu);
                num_col++;
                ps.setInt(num_col, timKiemGiaDen);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Phong p = new Phong();
                    p.setId(rs.getLong("TroID"));
                    p.setDiaChi(DiaChiDAO.getInstance().findById(rs.getLong("DiaChiID")));
                    p.setGia((rs.getDouble("GiaPhong")));
                    p.setMoTa(rs.getString("MoTa"));
                    //moi
                    p.setDienTich(rs.getDouble("DienTich"));
                    p.setHinhAnh(rs.getString("HinhAnh"));
                    p.setChu(ChuPhongDAO.getInstance().findById(rs.getLong("ChuTroID")));
                    p.setKhach(KhachHangDAO.getInstance().findById(rs.getLong("KhachHangID")));
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
