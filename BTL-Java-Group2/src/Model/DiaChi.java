package Model;

public class DiaChi {
    private int id;
    private int so_nha;
    private String ten_duong;
    private String ten_phuong_xa;
    private String ten_quan_huyen;
    private String ten_tinh_thanh_pho;

    public DiaChi() {
    }

    public DiaChi(int id, int so_nha, String ten_duong, String ten_phuong_xa, String ten_quan_huyen, String ten_tinh_thanh_pho) {
        this.id = id;
        this.so_nha = so_nha;
        this.ten_duong = ten_duong;
        this.ten_phuong_xa = ten_phuong_xa;
        this.ten_quan_huyen = ten_quan_huyen;
        this.ten_tinh_thanh_pho = ten_tinh_thanh_pho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSo_nha() {
        return so_nha;
    }

    public void setSo_nha(int so_nha) {
        this.so_nha = so_nha;
    }

    public String getTen_duong() {
        return ten_duong;
    }

    public void setTen_duong(String ten_duong) {
        this.ten_duong = ten_duong;
    }

    public String getTen_phuong_xa() {
        return ten_phuong_xa;
    }

    public void setTen_phuong_xa(String ten_phuong_xa) {
        this.ten_phuong_xa = ten_phuong_xa;
    }

    public String getTen_quan_huyen() {
        return ten_quan_huyen;
    }

    public void setTen_quan_huyen(String ten_quan_huyen) {
        this.ten_quan_huyen = ten_quan_huyen;
    }

    public String getTen_tinh_thanh_pho() {
        return ten_tinh_thanh_pho;
    }

    public void setTen_tinh_thanh_pho(String ten_tinh_thanh_pho) {
        this.ten_tinh_thanh_pho = ten_tinh_thanh_pho;
    }

    @Override
    public String toString() {
        return "DiaChi{" +
                "id=" + id +
                ", so_nha=" + so_nha +
                ", ten_duong='" + ten_duong + '\'' +
                ", ten_phuong_xa='" + ten_phuong_xa + '\'' +
                ", ten_quan_huyen='" + ten_quan_huyen + '\'' +
                ", ten_tinh_thanh_pho='" + ten_tinh_thanh_pho + '\'' +
                '}';
    }
}
