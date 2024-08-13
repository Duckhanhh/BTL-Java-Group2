package Controller;

import Model.KhachHang;
import Repo.DAO.KhachHangDAO;

import java.util.Date;

public class KhachHangController {
    public void suaKhach(KhachHang khachHang){
        KhachHangDAO.getInstance().update(khachHang);
    }
}
