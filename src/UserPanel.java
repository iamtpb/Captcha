import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel {

    public UserPanel() {
        init();
        this.setPreferredSize(new Dimension(200, 200));
        this.setMinimumSize(new Dimension(200, 200));
        this.setMaximumSize(new Dimension(200, 200));
    }

    private void init() {
        JLabel label_name = new JLabel("Logged in Successfully!");
        this.add(label_name);
    }
}
