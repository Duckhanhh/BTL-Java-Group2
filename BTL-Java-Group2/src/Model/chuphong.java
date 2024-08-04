package Model;

import java.util.ArrayList;
import java.util.Date;

public class chuphong {
    private  String hoten;
    private Date ngaysinh;
    private String gioitinh;
    private String CCCD;
    private String sodt;
    private List<Phong> danhsachphong;
    private String tentk;
    private String matkhau;

    chuphong(){

    }
    public chuphong(String hoten,Date ngaysinh , String gioitinh,String CCCD,String sodt,String tentk,String matkhau,List<Tro> danhsachtro){
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.CCCD = CCCD;
        this.sodt = sodt;
        this.tentk = tentk;
        this.matkhau = matkhau;
        this.danhsachtro = danhsachtro;
    }

    public String getHoten() {
        return hoten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getCCCD() {
        return CCCD;
    }

    public String getSodt() {
        return sodt;
    }

    public List<Phong> getDanhsachtro() {
        return danhsachphong;
    }

    public String getTentk() {
        return tentk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public void setDanhsachtro(List<Phong> danhsachtro) {
        this.danhsachphong = danhsachphong;
    }

    public void setTentk(String tentk) {
        this.tentk = tentk;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    @Override
    public String toString() {
        return "chutro{" +
                "hoten='" + hoten + '\'' +
                ", ngaysinh=" + ngaysinh +
                ", gioitinh='" + gioitinh + '\'' +
                ", CCCD='" + CCCD + '\'' +
                ", sodt='" + sodt + '\'' +
                ", danhsachtro=" + danhsachphong +
                ", tentk='" + tentk + '\'' +
                ", matkhau='" + matkhau + '\'' +
                '}';
    }
}

