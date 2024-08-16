package Controller;


import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;
import Model.Phong;
import Repo.DAO.PhongDAO;

import java.util.List;

public class ChuPhongController {

    public List<Phong> timKiem(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, Integer timKiemGiaTu, Integer timKiemGiaDen) {
        return PhongDAO.getInstance().findPhong(Tinh, Huyen, Xa, TenDuong, soNha, timKiemGiaTu, timKiemGiaDen);
    }

    public void xoaKhachKhoiTro(Phong obj) {
        PhongDAO.getInstance().delete(obj);
    }

    public void suaPhong(Long id, DiaChi diaChi, Double gia, String moTa, Double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {
        PhongDAO.getInstance().updatePhong(id, diaChi, gia, moTa, dienTich, hinhAnh, chu, khach);
    }
}
