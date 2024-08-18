package Controller;

import Repo.TaiKhoanRepo;

public class TaiKhoanController {
    public static TaiKhoanController getInstance(){
        return new TaiKhoanController();
    }

    public boolean DangNhap(String username, String password, Long role) {
        return TaiKhoanRepo.getInstance().DangNhap(username, password, role);
    }

    public boolean DangKy(String username, String password, Long role) {
        return TaiKhoanRepo.getInstance().DangKy(username, password, role);
    }
}
