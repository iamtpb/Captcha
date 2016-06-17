import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Captcha {
    JFrame mainWindow;
    JPanel mainPanel;
    JLabel label_title,label_image,label_text,label_msg;
    JTextField tf_input;

    public static void main(String[] args) {
        Captcha captcha = new Captcha();
    }

    public Captcha(){
        init();
    }

    public void init(){
        mainWindow = new JFrame();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setSize(new Dimension(200,300));

        //TODO: Implement Layout Manager

        mainPanel = new JPanel();
        label_title = new JLabel("Captcha");
        label_image = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src//img1.png");
        label_image.setIcon(imageIcon);
        tf_input = new JTextField();
        tf_input.setColumns(15);
        label_msg = new JLabel("Enter Text: (is Case Sensitive)");

        mainPanel.add(label_title);
        mainPanel.add(label_image);
        mainPanel.add(label_msg);
        mainPanel.add(tf_input);

        mainWindow.add(mainPanel);
        mainWindow.setVisible(true);
    }
}
