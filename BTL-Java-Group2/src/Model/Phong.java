package Model;

import java.io.File;

public class Phong {
    private DiaChi diaChi;
    private double gia;
    private String moTa;
    private double dienTich;
    private File hinhAnh;
    private ChuPhong chu;
    private KhachHang khach;

    public Phong() {

    }

    public Phong(DiaChi diaChi, double gia, String moTa, double dienTich, File hinhAnh, ChuPhong chu, KhachHang khach) {
        this.diaChi = diaChi;
        this.gia = gia;
        this.moTa = moTa;
        this.dienTich = dienTich;
        this.hinhAnh = hinhAnh;
        this.chu = chu;
        this.khach = khach;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public File getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(File hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public ChuPhong getChu() {
        return chu;
    }

    public void setChu(ChuPhong chu) {
        this.chu = chu;
    }

    public KhachHang getKhach() {
        return khach;
    }

    public void setKhach(KhachHang khach) {
        this.khach = khach;
    }
}