package Controller;


import Model.DiaChi;
import Model.Phong;
import Repo.DAO.PhongDAO;

import java.util.List;

public class ChuPhongController {

    public List<Phong> timKiem(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, Integer timKiemGiaTu, Integer timKiemGiaDen) {
        return PhongDAO.getInstance().findPhong(Tinh, Huyen, Xa, TenDuong, soNha, timKiemGiaTu, timKiemGiaDen);
    }
}
