package Repo.DAO;

import Model.ChuPhong;
import Model.DiaChi;
import Model.KhachHang;
import Model.Phong;
import database.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KhachHangDAO implements DAOinterface<KhachHang>{

    @Override
    public void insert(KhachHang obj) {

    }

    @Override
    public void update(KhachHang obj) {

    }

    @Override
    public void delete(KhachHang obj) {

    }

    @Override
    public KhachHang findById(int id) {
        return null;
    }

    @Override
    public List<KhachHang> findPhong(String Tinh, String Huyen, String Xa, String TenDuong, String soNha, int timKiemGiaTu) {
        return List.of();
    }

    @Override
    public void update(int id, DiaChi diaChi, double gia, String moTa, double dienTich, String hinhAnh, ChuPhong chu, KhachHang khach) {

    }
}
