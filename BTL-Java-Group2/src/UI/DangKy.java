package UI;

import Controller.TaiKhoanController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DangKy extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton backButton;
    private JCheckBox isChuPhong;

    public DangKy() {
        setTitle("Đăng ký");
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

        isChuPhong = new JCheckBox();
        isChuPhong.setText("Chủ Phòng");
        isChuPhong.setSelected(false);
        isChuPhong.setBounds(100, 100, 100, 25);
        add(isChuPhong);

        passwordField = new JPasswordField();
        passwordField.setBounds(110, 70, 160, 25);
        add(passwordField);

        registerButton = new JButton("Đăng ký");
        registerButton.setBounds(50, 125, 100, 25);
        add(registerButton);

        backButton = new JButton("Quay lại");
        backButton.setBounds(160, 125, 80, 25);
        add(backButton);

        registerButton.addActionListener(e -> {
            boolean isSuccess;
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            // Thêm mã xử lý đăng ký tại đây
            if (isChuPhong.isSelected()) {
                isSuccess = TaiKhoanController.getInstance().DangKy(username, password, 0L);
            } else {
                isSuccess = TaiKhoanController.getInstance().DangKy(username, password, 1L);
            }
            if (isSuccess) {
                JOptionPane.showMessageDialog(null, "Đăng ký thành công!");
                DangNhap loginForm = new DangNhap();
                loginForm.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Đăng ký thất bại!");
            }

        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangNhap loginForm = new DangNhap();
                loginForm.setVisible(true);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        DangKy registerForm = new DangKy();
        registerForm.setVisible(true);
    }
}
