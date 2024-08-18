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

    public Long checkDiaChi(String tinh, String huyen, String xa, String duong, String soNha) {
        DiaChi newDiaChi = new DiaChi(null, soNha, duong, xa, huyen, tinh);
        Long idDiaChi = DiaChiDAO.getInstance().timDiaChi(newDiaChi.getTenTinhThanhPho(), newDiaChi.getTenQuanHuyen(), newDiaChi.getTenPhuongXa(), newDiaChi.getTenDuong(), newDiaChi.getSoNha());
        if (idDiaChi == -1L) {
            DiaChiDAO.getInstance().insertDiaChi(newDiaChi.getTenTinhThanhPho(), newDiaChi.getTenQuanHuyen(), newDiaChi.getTenPhuongXa(), newDiaChi.getTenDuong(), newDiaChi.getSoNha());
            idDiaChi = DiaChiDAO.getInstance().timDiaChi(newDiaChi.getTenTinhThanhPho(), newDiaChi.getTenQuanHuyen(), newDiaChi.getTenPhuongXa(), newDiaChi.getTenDuong(), newDiaChi.getSoNha());
        }
        return idDiaChi;
    }

    public boolean themTro(String tinh, String huyen, String xa, String duong, String soNha, Double gia, Integer dienTich, String hinhAnh, String moTa) {
        DiaChi newDiaChi = new DiaChi(null, soNha, duong, xa, huyen, tinh);
        newDiaChi.setId(checkDiaChi(tinh, huyen, xa, duong, soNha));
        Phong newPhong = new Phong(null, newDiaChi, gia, moTa, dienTich, hinhAnh, DataDangNhap.chu, null);
        return PhongDAO.getInstance().insert(newPhong);
    }

    public void xoaTro(Long id) {
        PhongDAO.getInstance().deletePhong(id);
    }

    public boolean suaPhong(Long id, DiaChi diaChi, Double gia, String moTa, Integer dienTich, String hinhAnh, boolean isXoaKhach) {
        Long idDiaChi = checkDiaChi(diaChi.getTenTinhThanhPho(), diaChi.getTenQuanHuyen(), diaChi.getTenPhuongXa(), diaChi.getTenDuong(), diaChi.getSoNha());

        return PhongDAO.getInstance().updatePhong(id, idDiaChi, gia, moTa, dienTich, hinhAnh, isXoaKhach);
    }

    public boolean suaChuPhong(Long id, String hoTen, Date ngaySinh, String gioiTinh, String CCCD, String soDt) {
        return ChuPhongDAO.getInstance().updateChuPhong(id, hoTen, ngaySinh, gioiTinh, CCCD, soDt);
    }

    public boolean xoaChu(Long idChuPhong) {
        return ChuPhongDAO.getInstance().deleteChuPhong(idChuPhong);
    }
}
