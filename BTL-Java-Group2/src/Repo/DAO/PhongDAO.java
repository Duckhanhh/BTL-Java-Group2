package Repo.DAO;

import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;
import Model.Phong;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhongDAO {
    public static PhongDAO getInstance() {
        return new PhongDAO();
    }

    public boolean insert(Phong phong) {
        try {
            if (phong.getDiaChi() == null &&
                    phong.getGia() == 0.0 && phong.getMoTa() == null &&
                    phong.getDienTich() == 0.0 && phong.getHinhAnh() == null) {
                throw new IllegalArgumentException("Không được để trống hết");
            }
            Connection con = JDBCUtil.getConnection();
            String query = "INSERT INTO Tro(troid, giaphong, mota, hinhanh, chutroid, diachiid, dientich) VALUES (NEXT VALUE FOR Tro_seq, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                // Xử lý giá trị null cho gia
                Double gia = phong.getGia();
                if (gia != null) {
                    ps.setDouble(1, gia);
                } else {
                    ps.setNull(1, java.sql.Types.DOUBLE);
                }

                // Xử lý giá trị null cho moTa
                String moTa = phong.getMoTa();
                if (moTa != null) {
                    ps.setString(2, moTa);
                } else {
                    ps.setNull(2, java.sql.Types.VARCHAR);
                }

                // Xử lý giá trị null cho hinhAnh
                String hinhAnh = phong.getHinhAnh();
                if (hinhAnh != null) {
                    ps.setString(3, hinhAnh);
                } else {
                    ps.setNull(3, java.sql.Types.VARCHAR);
                }

                // Xử lý giá trị không null cho chu và diaChi
                ps.setLong(4, phong.getChu().getId());
                ps.setLong(5, phong.getDiaChi().getId());

                // Xử lý giá trị null cho dienTich
                Integer dienTich = phong.getDienTich();
                if (dienTich != null) {
                    ps.setDouble(6, dienTich);
                } else {
                    ps.setNull(6, java.sql.Types.DOUBLE);
                }

                // Thực hiện câu lệnh chèn
                int affectedRows = ps.executeUpdate();
                JDBCUtil.closeConnection(con);

                return affectedRows > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void updatePhong(Long id, DiaChi diaChi, Double gia, String moTa, Double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("UPDATE phong SET ");

            boolean firstField = true;

            if (gia != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append("GiaPhong = ?");
                firstField = false;
            }
            if (moTa != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append("MoTa = ?");
                firstField = false;
            }
            if (hinhAnh != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append("HinhAnh = ?");
                firstField = false;
            }
            if (chu.getId() != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append("ChuTroID = ?");
                firstField = false;
            }
            if (khach.getId() != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append("KhachHangID = ?");
                firstField = false;
            }
            if (diaChi.getId() != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append("DiaChiID = ?");
                firstField = false;
            }
            if (dienTich != null) {
                if (!firstField) stringBuilder.append(", ");
                stringBuilder.append("DienTich = ?");
            }

            stringBuilder.append(" WHERE TroID = ?");

            PreparedStatement ps = con.prepareStatement(stringBuilder.toString());

            int paramIndex = 1;

            if (gia != null) {
                ps.setDouble(paramIndex++, gia);
            }
            if (moTa != null) {
                ps.setString(paramIndex++, moTa);
            }
            if (hinhAnh != null) {
                ps.setString(paramIndex++, hinhAnh);
            }
            if (chu.getId() != null) {
                ps.setLong(paramIndex++, chu.getId());
            }
            if (khach.getId() != null) {
                ps.setLong(paramIndex++, khach.getId());
            }
            if (diaChi.getId() != null) {
                ps.setLong(paramIndex++, diaChi.getId());
            }
            if (dienTich != null) {
                ps.setDouble(paramIndex++, dienTich);
            }

            ps.setLong(paramIndex, id);

            ps.executeUpdate();

            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void delete(Phong obj) {
        if (obj.getId() == null) {
            System.out.println("id is null");
            return;
        }
        try {
            Connection con = JDBCUtil.getConnection();
            String query = "DELETE FROM Tro WHERE TroID = ?";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setLong(1, obj.getId());
                ps.execute();
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Phong findById(Long id) {
        return null;
    }

    public List<Phong> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, Double timKiemGiaTu, Double timKiemGiaDen, Integer dienTichTu, Integer dienTichDen, Long idChu) {
        List<Phong> list = new ArrayList<>();
        int num_col = 1;
        try {
            Connection con = JDBCUtil.getConnection();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" SELECT * FROM Tro INNER JOIN DiaChi ON Tro.DiaChiID = DiaChi.DiaChiID WHERE 1=1 ");
            //Doan nay de hoan thien cau lenh sql
            if (Tinh != null && !Tinh.isBlank() && !Tinh.isEmpty()) {
                stringBuilder.append(" AND TinhThanhPho LIKE ? ");
            }
            if (Huyen != null && !Huyen.isEmpty() && !Huyen.isBlank()) {
                stringBuilder.append(" AND HuyenQuan LIKE ? ");
            }
            if (Xa != null && !Xa.isBlank() && !Xa.isEmpty()) {
                stringBuilder.append(" AND PhuongXa LIKE ? ");
            }
            if (TenDuong != null && !TenDuong.isEmpty() && !TenDuong.isBlank()) {
                stringBuilder.append(" AND TenDuong LIKE ? ");
            }
            if (soNha != null && !soNha.isBlank() && !soNha.isEmpty()){
                stringBuilder.append(" AND SoNha LIKE ? ");
            }
            if (timKiemGiaTu != null) {
                stringBuilder.append(" AND GiaPhong > ?  ");
            }
            if (timKiemGiaDen != null) {
                stringBuilder.append(" AND GiaPhong < ? ");
            }
            if (dienTichTu != null) {
                stringBuilder.append(" AND DienTich > ?  ");
            }
            if (dienTichDen != null) {
                stringBuilder.append(" AND DienTich < ? ");
            }
            if (idChu != null) {
                stringBuilder.append(" AND ChuTroID = ?");
            }

            try (PreparedStatement ps = con.prepareStatement(stringBuilder.toString())) {
                if (Tinh != null && !Tinh.isBlank() && !Tinh.isEmpty()) {
                    ps.setString(num_col, Tinh);
                    num_col++;
                }
                if (Huyen != null && !Huyen.isEmpty() && !Huyen.isBlank()) {
                    ps.setString(num_col, Huyen);
                    num_col++;
                }
                if (Xa != null && !Xa.isBlank() && !Xa.isEmpty()) {
                    ps.setString(num_col, Xa);
                    num_col++;
                }
                if (TenDuong != null && !TenDuong.isEmpty() && !TenDuong.isBlank()) {
                    ps.setString(num_col, TenDuong);
                    num_col++;
                }
                if (soNha != null && !soNha.isBlank() && !soNha.isEmpty()){
                    ps.setString(num_col, soNha);
                    num_col++;
                }
                if (timKiemGiaTu != null) {
                    ps.setDouble(num_col, timKiemGiaTu);
                    num_col++;
                }
                if (timKiemGiaDen != null) {
                    ps.setDouble(num_col, timKiemGiaDen);
                    num_col++;
                }
                if (dienTichTu != null) {
                    ps.setDouble(num_col, dienTichTu);
                    num_col++;
                }
                if (dienTichDen != null) {
                    ps.setDouble(num_col, dienTichDen);
                    num_col++;
                }
                if (idChu != null) {
                    ps.setLong(num_col, idChu);
                }
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Phong p = new Phong();
                    p.setId(rs.getLong("TroID"));
                    p.setDiaChi(DiaChiDAO.getInstance().findById(rs.getLong("DiaChiID")));
                    p.setGia((rs.getDouble("GiaPhong")));
                    p.setMoTa(rs.getString("MoTa"));
                    //moi
                    p.setDienTich(rs.getInt("DienTich"));
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
