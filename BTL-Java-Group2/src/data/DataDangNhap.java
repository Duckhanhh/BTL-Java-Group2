package data;

import Model.ChuPhong;
import Model.KhachHang;

public class DataDangNhap {
    public static ChuPhong chu = null;
    public static KhachHang khachHang = null;
    public static Long getId() {
        return chu.getId();
    }

}
