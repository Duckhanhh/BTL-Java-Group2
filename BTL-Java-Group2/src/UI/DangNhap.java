package UI;

import Controller.TaiKhoanController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DangNhap extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JCheckBox isChuPhongCheckBox;
    private boolean isSuccess;

    public DangNhap() {
        setTitle("Đăng nhập");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel usernameLabel = new JLabel("Tên đăng nhập:");
        usernameLabel.setBounds(20, 30, 100, 25);
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(110, 30, 160, 25);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Mật khẩu:");
        passwordLabel.setBounds(20, 70, 80, 25);
        add(passwordLabel);

        isChuPhongCheckBox = new JCheckBox();
        isChuPhongCheckBox.setText("Chủ phòng");
        isChuPhongCheckBox.setBounds(100, 100, 100, 25);
        add(isChuPhongCheckBox);

        passwordField = new JPasswordField();
        passwordField.setBounds(110, 70, 160, 25);
        add(passwordField);

        loginButton = new JButton("Đăng nhập");
        loginButton.setBounds(50, 130, 100, 25);
        add(loginButton);

        registerButton = new JButton("Đăng ký");
        registerButton.setBounds(180, 130, 100, 25);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                if (isChuPhongCheckBox.isSelected()) {
                    isSuccess = TaiKhoanController.getInstance().DangNhap(username, password, 0L);
                } else {
                    isSuccess = TaiKhoanController.getInstance().DangNhap(username, password, 1L);
                }
                if (isSuccess) {
                    JFChuPhong mhChuPhong = new JFChuPhong();
                    JFKhachHang mkHachHang = new JFKhachHang();
                    if (isChuPhongCheckBox.isSelected()) {
                        mhChuPhong.setVisible(true);
                    } else {
                        mkHachHang.setVisible(true);
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thất bại! Kiểm tra lại tên đăng nhập và mật khẩu!");
                }

            }
        });

        registerButton.addActionListener(e -> {
            DangKy registerForm = new DangKy();
            registerForm.setVisible(true);
            dispose();
        });
    }

    public static void main(String[] args) {
        DangNhap loginForm = new DangNhap();
        loginForm.setVisible(true);
    }
}