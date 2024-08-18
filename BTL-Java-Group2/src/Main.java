import Model.Phong;
import database.JDBCUtil;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
//        JFrame frame = new JFrame("Phòng trọ");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(900, 500);
//        frame.setLayout(new BorderLayout());
//
//        // Call method to add components
//        addComponentsToFrame(frame);
//
//        frame.setVisible(true);
    }

    private static void addComponentsToFrame(JFrame frame) {
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Top panel for title
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Danh sách các phòng trọ", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);

        // Center panel for form and table
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        formPanel.add(new JLabel("Mã SV:"));
        JTextField txtMaSV = new JTextField();
        formPanel.add(txtMaSV);

        formPanel.add(new JLabel("Quê Quán:"));
        JTextField txtQueQuan = new JTextField();
        formPanel.add(txtQueQuan);

        formPanel.add(new JLabel("Họ Tên:"));
        JTextField txtHoTen = new JTextField();
        formPanel.add(txtHoTen);

        formPanel.add(new JLabel("Số điện thoại:"));
        JTextField txtSDT = new JTextField();
        formPanel.add(txtSDT);

        formPanel.add(new JLabel("Ngày Sinh:"));
        JTextField txtNgaySinh = new JTextField();
        formPanel.add(txtNgaySinh);

        formPanel.add(new JLabel("Gmail:"));
        JTextField txtGmail = new JTextField();
        formPanel.add(txtGmail);

        formPanel.add(new JLabel());  // Empty placeholder
        formPanel.add(new JLabel());  // Empty placeholder

        centerPanel.add(formPanel, BorderLayout.NORTH);

        // Table panel
        String[] columnNames = {"Mã Sinh Viên", "Họ Tên", "Ngày Sinh", "Giới Tính", "Quê Quán", "Số điện thoại", "Gmail", "Mã Lớp", "Cộng nợ"};
        Object[][] data = {
                {"11", "Trần Trung Hiếu", "2001-01-01", "Nam", "Hà Nam", "12345578", "hieu@gmail.com", "1", "0"},
                {"12", "Đoàn Nam Hùng", "2001-01-01", "Nam", "Thái Bình", "086243620", "hung@gmail.com", "2", "1"},
                // Add more rows as needed
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Left side panel for menu
        JPanel menuPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnDanhSachSinhVien = new JButton("Danh sách Sinh viên");
        JButton btnNhapHoc = new JButton("Nhập học");
        JButton btnDongHocPhi = new JButton("Đóng học phí");
        JButton btnThongBaoNopTien = new JButton("Thông báo Nộp Tiền");
        JButton btnXuatBaoCao = new JButton("Xuất Báo Cáo");

        menuPanel.add(btnDanhSachSinhVien);
        menuPanel.add(btnNhapHoc);
        menuPanel.add(btnDongHocPhi);
        menuPanel.add(btnThongBaoNopTien);
        menuPanel.add(btnXuatBaoCao);

        mainPanel.add(menuPanel, BorderLayout.WEST);

        // Bottom panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton btnTimKiem = new JButton("Tìm Kiếm");
        JButton btnCapNhat = new JButton("Cập Nhật");
        JButton btnXoa = new JButton("Xóa");
        JButton btnHienThi = new JButton("Hiển Thị");

        buttonPanel.add(btnTimKiem);
        buttonPanel.add(btnCapNhat);
        buttonPanel.add(btnXoa);
        buttonPanel.add(btnHienThi);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        frame.add(mainPanel, BorderLayout.CENTER);
    }
}