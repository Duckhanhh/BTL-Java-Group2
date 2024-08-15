package Repo.DAO;

import java.util.List;

public interface DAOinterface<T> {
    public void insert(T obj);
    public void update(T obj);
    public void delete(T obj);
    public T findById(Long id);
    //public List<T> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu);
}
