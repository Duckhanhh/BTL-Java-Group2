package Controller;


import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;
import Model.Phong;
import Repo.DAO.ChuPhongDAO;
import Repo.DAO.PhongDAO;

import java.util.Date;
import java.util.List;

public class ChuPhongController {

    public List<Phong> timKiem(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, Double dienTich, Integer timKiemGiaTu, Integer timKiemGiaDen) {
        return PhongDAO.getInstance().findPhong(Tinh, Huyen, Xa, TenDuong, soNha, dienTich, timKiemGiaTu, timKiemGiaDen);
    }

    public void xoaKhachKhoiTro(Phong obj) {
        PhongDAO.getInstance().delete(obj);
    }

    public void suaPhong(Long id, DiaChi diaChi, Double gia, String moTa, Double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {
        PhongDAO.getInstance().updatePhong(id, diaChi, gia, moTa, dienTich, hinhAnh, chu, khach);
    }

    public void suaChuPhong(Long id, String hoTen, Date ngaySinh, String gioiTinh, String CCCD, String soDt){
        ChuPhongDAO.getInstance().updateChuPhong(id, hoTen, ngaySinh, gioiTinh, CCCD, soDt);
    }
}
