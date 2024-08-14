package Model;

import java.util.List;

public class KhachHang {
    private long id;
    private String hoTen;
    private Integer namSinh;
    private String gioiTinh;
    private String cccd;
    private String soDienThoai;
    private String email;
    private String matKhau;

    private List<Phong> listPhong;

    public KhachHang() {
    }

    public KhachHang(long id, String hoTen, Integer namSinh, String gioiTinh, String cccd, String soDienThoai, String email, String matKhau) {
        this.id = id;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.gioiTinh = gioiTinh;
        this.cccd = cccd;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.matKhau = matKhau;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public List<Phong> getListPhong() {
        return listPhong;
    }

    public void setListPhong(List<Phong> listPhong) {
        this.listPhong = listPhong;
    }
}
