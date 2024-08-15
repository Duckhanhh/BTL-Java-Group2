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

    public T findById(Long id);
    public List<T> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu);
    public void updatePhong(Long id, DiaChi diaChi, Double gia, String moTa, Double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach);

}
