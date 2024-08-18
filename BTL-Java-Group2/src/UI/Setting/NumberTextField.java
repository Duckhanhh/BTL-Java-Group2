package UI.Setting;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumberTextField extends JTextField {
    public NumberTextField(int columns) {
        super(columns);

        // Áp dụng KeyListener để chỉ cho phép nhập số
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume(); // Ngăn không cho ký tự không phải số được nhập
                }
            }
        });
    }
}