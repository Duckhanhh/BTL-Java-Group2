package Repo.DAO;

import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;
import Model.Phong;

import java.util.List;

public interface DAOinterface<T> {
    public void insert(T obj);
    public void update(T obj);
    public void delete(T obj);

    public T findById(int id);
    public List<T> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu);
    public void update(int id, DiaChi diaChi, double gia, String moTa, double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach);
}
