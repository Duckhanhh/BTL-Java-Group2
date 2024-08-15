package Repo.DAO;

import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;

import java.util.List;

public class KhachHangDAO implements DAOinterface<KhachHang>{

    @Override
    public void insert(KhachHang obj) {

    }

    @Override
    public void update(KhachHang obj) {

    }

    @Override
    public void delete(KhachHang obj) {

    }

    @Override
    public KhachHang findById(Long id) {
        return null;
    }

    @Override
    public List<KhachHang> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        return List.of();
    }

    @Override
    public void updatePhong(Long id, DiaChi diaChi, Double gia, String moTa, Double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {

    }
}
