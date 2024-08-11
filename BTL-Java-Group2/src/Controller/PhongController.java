package Controller;


import Model.Phong;
import Repo.PhongDAO;

public class PhongController {

    public void insertPhong(Phong p) {
        PhongDAO.getInstance().insert(p);
    }

}
