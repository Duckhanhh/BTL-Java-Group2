package Repo.DAO;

import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;
import Model.Phong;

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

    }

    @Override
    public ChuPhong findById(int id) {
        return null;
    }

    @Override
    public List<ChuPhong> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        return List.of();
    }

    @Override
    public void update(int id, DiaChi diaChi, double gia, String moTa, double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {

    }

}
