package Controller;

import Model.KhachHang;
import Repo.DAO.KhachHangDAO;

import java.util.Date;


public class KhachHangController {
    public void suaKhach(Long id, String hoTen, Date namSinh, String gioiTinh, String cccd, String soDienThoai, String email, String matKhau){
        KhachHangDAO.getInstance().update(id, hoTen, namSinh, gioiTinh, cccd, soDienThoai, email, matKhau);
    }
}
