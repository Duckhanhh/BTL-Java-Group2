package Model;

import java.io.File;

public class Phong {
    private DiaChi address;
    private double gia;
    private String mota;
    private double dientich;
    private File hinhanh;
    private chuphong chu;
    private Client KH;

    public Phong() {
    }

    public Phong(DiaChi address, double gia, String mota, double dientich, File hinhanh, chuphong chu, Client KH) {
        this.address = address;
        this.gia = gia;
        this.mota = mota;
        this.dientich = dientich;
        this.hinhanh = hinhanh;
        this.chu = chu;
        this.KH = KH;
    }

    public DiaChi getAddress() {
        return address;
    }

    public void setAddress(DiaChi address) {
        this.address = address;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public double getDientich() {
        return dientich;
    }

    public void setDientich(double dientich) {
        this.dientich = dientich;
    }

    public File getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(File hinhanh) {
        this.hinhanh = hinhanh;
    }

    public chuphong getChu() {
        return chu;
    }

    public void setChu(chuphong chu) {
        this.chu = chu;
    }

    public Client getKH() {
        return KH;
    }

    public void setKH(Client KH) {
        this.KH = KH;
    }
}
