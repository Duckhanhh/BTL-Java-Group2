package Controller;

import Model.KhachHang;
import Model.Phong;
import Repo.DAO.KhachHangDAO;
import Repo.DAO.PhongDAO;

import java.util.Date;
import java.util.List;


public class KhachHangController {
    public static KhachHangController getInstance() {
        return new KhachHangController();
    }

    public boolean suaKhachHang(Long id, String hoTen, Date namSinh, String gioiTinh, String cccd, String soDienThoai) {
        return KhachHangDAO.getInstance().updateKhachHang(id, hoTen, namSinh, gioiTinh, cccd, soDienThoai);
    }

    public List<Phong> timKiem(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, Double timKiemGiaTu, Double timKiemGiaDen, Integer dienTichTu, Integer dienTichDen, Long idKhach) {
        return PhongDAO.getInstance().findPhongKhach(Tinh, Huyen, Xa, TenDuong, soNha, timKiemGiaTu, timKiemGiaDen, dienTichTu, dienTichDen, idKhach);
    }

    public boolean dangKyPhong(Long id) {
        return PhongDAO.getInstance().khachDangKy(id);
    }

    public boolean huyDangKyPhong(Long id) {
        return PhongDAO.getInstance().khachHuyDangKy(id);
    }

    public boolean xoaKhachHang(Long id) {
        return KhachHangDAO.getInstance().delete(id);
    }
}
