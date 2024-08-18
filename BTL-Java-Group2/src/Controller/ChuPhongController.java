package Controller;


import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;
import Model.Phong;
import Repo.DAO.ChuPhongDAO;
import Repo.DAO.DiaChiDAO;
import Repo.DAO.PhongDAO;
import data.DataDangNhap;

import java.util.Date;
import java.util.List;

public class ChuPhongController {
    public static ChuPhongController getInstance() {
        return new ChuPhongController();
    }

    public List<Phong> timKiem(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, Double timKiemGiaTu, Double timKiemGiaDen, Integer dienTichTu, Integer dienTichDen, Long idChu) {
        return PhongDAO.getInstance().findPhong(Tinh, Huyen, Xa, TenDuong, soNha, timKiemGiaTu, timKiemGiaDen, dienTichTu, dienTichDen, idChu);
    }

    public boolean themTro(String tinh, String huyen, String xa, String duong, String soNha, Double gia, Integer dienTich, String hinhAnh, String moTa) {
        DiaChi newDiaChi = new DiaChi(null, soNha, duong, xa, huyen, tinh);
        Long idDiaChi = DiaChiDAO.getInstance().timDiaChi(newDiaChi.getTenTinhThanhPho(), newDiaChi.getTenQuanHuyen(), newDiaChi.getTenPhuongXa(), newDiaChi.getTenDuong(), newDiaChi.getSoNha());
        if (idDiaChi == -1L) {
            DiaChiDAO.getInstance().insertDiaChi(newDiaChi.getTenTinhThanhPho(), newDiaChi.getTenQuanHuyen(), newDiaChi.getTenPhuongXa(), newDiaChi.getTenDuong(), newDiaChi.getSoNha());
            idDiaChi = DiaChiDAO.getInstance().timDiaChi(newDiaChi.getTenTinhThanhPho(), newDiaChi.getTenQuanHuyen(), newDiaChi.getTenPhuongXa(), newDiaChi.getTenDuong(), newDiaChi.getSoNha());
        }
        newDiaChi.setId(idDiaChi);
        Phong newPhong = new Phong(null, newDiaChi, gia, moTa, dienTich, hinhAnh, DataDangNhap.chu, null);
        return PhongDAO.getInstance().insert(newPhong);
    }

    public void xoaKhachKhoiTro(Phong obj) {
        PhongDAO.getInstance().delete(obj);
    }

    public void suaPhong(Long id, DiaChi diaChi, Double gia, String moTa, Double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {
        PhongDAO.getInstance().updatePhong(id, diaChi, gia, moTa, dienTich, hinhAnh, chu, khach);
    }

    public void suaChuPhong(Long id, String hoTen, Date ngaySinh, String gioiTinh, String CCCD, String soDt) {
        ChuPhongDAO.getInstance().updateChuPhong(id, hoTen, ngaySinh, gioiTinh, CCCD, soDt);
    }
}
