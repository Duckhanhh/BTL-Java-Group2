package UI.Setting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateInputVerifier extends JTextField {
    public DateInputVerifier(int columns) {
        super(columns);

        this.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                try {
                    // Kiểm tra định dạng ngày tháng
                    LocalDate.parse(text, formatter);
                    return true; // Nếu đúng định dạng, trả về true
                } catch (DateTimeParseException e) {
                    // Nếu sai định dạng, trả về false
                    JOptionPane.showMessageDialog(input, "Ngày nhập không đúng định dạng yyyy-MM-dd");
                    return false;
                }
            }
        });
    }

}
