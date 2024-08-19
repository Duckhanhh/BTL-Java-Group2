package UI;

import Controller.KhachHangController;
import Model.KhachHang;
import Model.Phong;
import UI.Dialog.DialogKhachHangUpdate;
import UI.Setting.NumberTextField;
import data.DataDangNhap;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JFKhachHang extends javax.swing.JFrame {

    public JFKhachHang() {
        initComponents();
        this.jLabel1.setBackground(Color.LIGHT_GRAY);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField(8);
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField(8);
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField(8);
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField(8);
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField(8);
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField(8);
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField(8);
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField(8);
        jTextField11 = new javax.swing.JTextField(8);
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"STT", "ID", "Giá thuê", "Diện tích", "Hình ảnh", "Khách hàng", "Chủ phòng"}) {
            Class[] types = new Class[]{
                    java.lang.Integer.class, java.lang.Long.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jTable1.getSelectionModel().addListSelectionListener(evt -> {
                    selectedRow = jTable1.getSelectedRow();
                    jButton4.setEnabled(selectedRow != -1 && listIdKhach.get(selectedRow).equals(-1L));
                    jButton5.setEnabled(selectedRow != -1 && listIdKhach.get(selectedRow).equals(DataDangNhap.khachHang.getId()));
                    if (selectedRow != -1)
                        idPhong = (Long) jTable1.getValueAt(selectedRow, 1);
                }
        );

        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chương trình quản lý & tìm kiếm trọ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Tìm kiếm trọ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Địa chỉ: ");

        jLabel3.setText("Tỉnh(TP):");

        jTextField1.addActionListener(evt -> jTextField1ActionPerformed());

        jLabel4.setText("Huyện(Quận):");

        jTextField2.addActionListener(evt -> jTextField2ActionPerformed());

        jLabel5.setText("Phường(Xã):");

        jTextField3.addActionListener(evt -> jTextField3ActionPerformed());

        jLabel6.setText("Đường: ");

        jTextField4.addActionListener(evt -> jTextField4ActionPerformed());

        jLabel7.setText("Số nhà:");

        jTextField5.addActionListener(evt -> jTextField5ActionPerformed());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giá thuê:");

        jLabel9.setText("Từ:");

        jTextField6.addActionListener(evt -> jTextField6ActionPerformed());

        jLabel10.setText("Đến:");

        jTextField7.addActionListener(evt -> jTextField7ActionPerformed());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Diện tích:");
        jTextField11.addActionListener(evt -> jTextField11ActionPerformed());

        jLabel12.setText("Đến:");

        jLabel13.setText("Từ:");

        jTextField10.addActionListener(evt -> jTextField10ActionPerformed());


        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setText("Đặt lại");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton4.setText("Đăng ký");
        jButton4.addActionListener(this::jButton4ActionPerformed);
        jButton4.setEnabled(false);

        jButton5.setText("Hủy Đăng ký");
        jButton5.addActionListener(this::jButton5ActionPerformed);
        jButton5.setEnabled(false);

        jCheckBox1.setText("Phòng đã thuê");
        jCheckBox1.addActionListener(this::jCheckBox1ActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(367, 367, 367)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jLabel2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel11)
                                                                .addGap(10, 10, 10)
                                                                .addComponent(jLabel13)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel12)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jCheckBox1))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel7)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(81, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton5))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(282, 282, 282)))
                                .addGap(270, 270, 270))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel13)
                                                        .addComponent(jLabel12)
                                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jCheckBox1)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel8)
                                                .addComponent(jLabel9)
                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel10)
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton4)
                                        .addComponent(jButton5))
                                .addContainerGap())
        );

        jPanel2.setAutoscrolls(true);

        jTable1.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getAccessibleContext().setAccessibleDescription("");
        jTable1.setRowSelectionAllowed(true);
        jTable1.setColumnSelectionAllowed(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2)
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        jMenu2.setText("Setting");
        updateItem = new JMenuItem("Sửa tài khoản");
        updateItem.addActionListener(evt -> jMenuItem1ActionPerformed());
        deleteItem = new JMenuItem("Xóa tài khoản");
        deleteItem.addActionListener(evt -> jMenuItem2ActionPerformed());
        logout = new JMenuItem("Đăng xuất");
        logout.addActionListener(evt -> jMenuItem3ActionPerformed());
        jMenu2.add(updateItem);
        jMenu2.add(deleteItem);
        jMenu2.add(logout);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Xử lý các JTextField
        jTextField1ActionPerformed();
        jTextField2ActionPerformed();
        jTextField3ActionPerformed();
        jTextField4ActionPerformed();
        jTextField5ActionPerformed();
        jTextField6ActionPerformed();
        jTextField7ActionPerformed();
        jTextField10ActionPerformed();
        jTextField11ActionPerformed();

        // Tìm kiếm dữ liệu
        List<Phong> listPhong = KhachHangController.getInstance().timKiem(tfTinh, tfHuyen, tfXa, tfDuong, tfSoNha, giaThueTu, giaThueDen, dienTichTu, dienTichDen, idKhach);
        if (listPhong == null || listPhong.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Danh sách phòng trống hoặc không thể tải được.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Cập nhật dữ liệu
        data = new Object[listPhong.size()][7];
        listIdKhach = new ArrayList<>();
        for (int i = 0; i < listPhong.size(); i++) {
            Phong phong = listPhong.get(i);
            data[i][0] = i + 1;  // STT
            data[i][1] = phong.getId();
            data[i][2] = phong.getGia();
            data[i][3] = phong.getDienTich();
            data[i][4] = phong.getHinhAnh();
            data[i][5] = (phong.getKhach() == null) ? null : phong.getKhach().getEmail();
            listIdKhach.add((phong.getKhach() == null) ? -1L : phong.getKhach().getId());
            data[i][6] = phong.getChu().getTenTaiKhoan();

            // Cập nhật mô hình dữ liệu của jTable1
            javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) jTable1.getModel();
            model.setDataVector(data, new String[]{"STT", "ID", "Giá thuê", "Diện tích", "Hình ảnh", "Khách hàng", "Chủ phòng"});
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField10.setText(null);
        jTextField11.setText(null);
        jCheckBox1.setSelected(false);
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
        boolean isSuccess = KhachHangController.getInstance().dangKyPhong(idPhong);
        if (isSuccess) {
            JOptionPane.showMessageDialog(null, "Đăng ký phòng thành công!");
        } else {
            JOptionPane.showMessageDialog(null, "Đăng ký phòng không thành công!");
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn hủy đăng ký phòng?");
        if (a == JOptionPane.YES_OPTION) {
            boolean isSuccess = KhachHangController.getInstance().huyDangKyPhong(idPhong);
            if (isSuccess) {
                JOptionPane.showMessageDialog(null, "Hủy đăng ký phòng thành công!");
            } else {
                JOptionPane.showMessageDialog(null, "Hủy đăng ký phòng không thành công!");
            }
        }
    }

    private void jTextField7ActionPerformed() {
        giaThueDen = jTextField7 != null && !jTextField7.getText().trim().isEmpty() ? Double.parseDouble(jTextField7.getText()) : null;
    }

    private void jTextField6ActionPerformed() {
        giaThueTu = jTextField6 != null && !jTextField6.getText().trim().isEmpty() ? Double.parseDouble(jTextField6.getText()) : null;
    }

    private void jTextField5ActionPerformed() {
        tfSoNha = !jTextField5.getText().isEmpty() && !jTextField5.getText().isBlank() ? jTextField5.getText() : null;
    }

    private void jTextField4ActionPerformed() {
        tfDuong = !jTextField4.getText().isEmpty() && !jTextField4.getText().isBlank() ? jTextField4.getText() : null;
    }

    private void jTextField3ActionPerformed() {
        tfXa = !jTextField3.getText().isEmpty() && !jTextField3.getText().isBlank() ? jTextField3.getText() : null;
    }

    private void jTextField2ActionPerformed() {
        tfHuyen = !jTextField2.getText().isEmpty() && !jTextField2.getText().isBlank() ? jTextField2.getText() : null;
    }

    private void jTextField1ActionPerformed() {
        tfTinh = !jTextField1.getText().isEmpty() && !jTextField1.getText().isBlank() ? jTextField1.getText() : null;
    }

    private void jTextField10ActionPerformed() {
        dienTichTu = !jTextField10.getText().isBlank() && !jTextField10.getText().isEmpty() ? Integer.parseInt(jTextField10.getText()) : null;
    }

    private void jTextField11ActionPerformed() {
        dienTichDen = !jTextField11.getText().isBlank() && !jTextField11.getText().isEmpty() ? Integer.parseInt(jTextField11.getText()) : null;
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBox1.isSelected()) {
            idKhach = DataDangNhap.khachHang.getId();
        } else {
            idKhach = null;
        }
    }

    public void jMenuItem1ActionPerformed() {
        DialogKhachHangUpdate dialog = new DialogKhachHangUpdate();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);
    }

    public void jMenuItem2ActionPerformed() {
        int a = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tài khoản?");
        if (a == JOptionPane.YES_OPTION) {
            KhachHangController.getInstance().xoaKhachHang(DataDangNhap.khachHang.getId());
            DangNhap dangNhap = new DangNhap();
            dangNhap.setVisible(true);
            dispose();
        }
    }

    public void jMenuItem3ActionPerformed() {
        DataDangNhap.khachHang = new KhachHang();
        DangNhap dangNhap = new DangNhap();
        dangNhap.setVisible(true);
        dispose();
    }

    public static void main(String args[]) {
        JFKhachHang chuPhong = new JFKhachHang();
        chuPhong.setVisible(true);
    }

    private JMenuItem updateItem;
    private JMenuItem deleteItem;
    private JMenuItem logout;
    public static Long idPhong;
    private List<Long> listIdKhach = new ArrayList<>();
    private String tfTinh;
    private String tfHuyen;
    private String tfXa;
    private String tfDuong;
    private String tfSoNha;
    private Double giaThueTu;
    private Double giaThueDen;
    private Integer dienTichTu;
    private Integer dienTichDen;
    private Long idKhach;
    private Integer selectedRow;
    private Object[][] data;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1 = new JTextField(8);
    private javax.swing.JTextField jTextField10 = new NumberTextField(8);
    private javax.swing.JTextField jTextField11 = new NumberTextField(8);
    private javax.swing.JTextField jTextField2 = new JTextField(8);
    private javax.swing.JTextField jTextField3 = new JTextField(8);
    private javax.swing.JTextField jTextField4 = new JTextField(8);
    private javax.swing.JTextField jTextField5 = new JTextField(8);
    private javax.swing.JTextField jTextField6 = new NumberTextField(8);
    private javax.swing.JTextField jTextField7 = new NumberTextField(8);
    // End of variables declaration
}
