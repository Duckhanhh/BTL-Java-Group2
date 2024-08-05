package Model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private Integer year;
    private String gender;
    private String cccd;
    private String phone;
    private String email;
    private String password;

    List<String> ListMotel = new ArrayList<>();

    public Client() {
    }

    public Client(String name, Integer year, String gender, String cccd, String phone, String email, String password) {
        this.name = name;
        this.year = year;
        this.gender = gender;
        this.cccd = cccd;
        this.phone = phone;
        this.email = email;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getListMotel() {
        return ListMotel;
    }

    public void setListMotel(List<String> listMotel) {
        ListMotel = listMotel;
    }
}