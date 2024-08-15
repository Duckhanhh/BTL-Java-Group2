package Model;

import java.io.File;

public class Phong {
    private Long id;
    private DiaChi diaChi;
    private Double gia;
    private String moTa;
    private Double dienTich;
    private File hinhAnh;
    private ChuPhong chu;
    private KhachHang khach;

    public Phong() {
    }

    public Phong(Long id, DiaChi diaChi, Double gia, String moTa, Double dienTich, File hinhAnh, ChuPhong chu, KhachHang khach) {
        this.id = id;
        this.diaChi = diaChi;
        this.gia = gia;
        this.moTa = moTa;
        this.dienTich = dienTich;
        this.hinhAnh = hinhAnh;
        this.chu = chu;
        this.khach = khach;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DiaChi getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }

    public Double getGia() {
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

    public Double getDienTich() {
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