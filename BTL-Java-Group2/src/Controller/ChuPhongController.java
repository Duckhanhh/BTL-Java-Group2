package Controller;


import Model.DiaChi;
import Model.Phong;
import Repo.DAO.PhongDAO;

import java.util.List;

public class ChuPhongController {

    public List<Phong> timKiem(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        return PhongDAO.getInstance().findPhong(Tinh, Huyen, Xa, TenDuong, soNha, timKiemGiaTu);
    }
    public void deleteKhach(Phong obj) {
        PhongDAO.getInstance().delete(obj);
    }
    public void update(Phong obj) {
        PhongDAO.getInstance().update(obj);
    }
}
