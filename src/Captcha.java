import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Captcha {
    int tries = 0;
    JFrame mainWindow;
    JPanel mainPanel;
    JLabel label_title,label_image,label_text,label_msg;
    JTextField tf_input;
    JButton button_submit;
    public static void main(String[] args) {
        Captcha captcha = new Captcha();
    }

    public Captcha(){
        init();
    }

    public void init(){
        tries = 0;
        mainWindow = new JFrame();
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setSize(new Dimension(150, 250));

        //TODO: Implement Layout Manager

        mainPanel = new JPanel();
        label_title = new JLabel("--- Captcha ---");
        label_image = new JLabel();
        button_submit = new JButton("Submit");
        button_submit.addActionListener(new Event_Submitted()); //Button Handler

        ImageIcon imageIcon = new ImageIcon("src//img1.png");
        label_image.setIcon(imageIcon);
        tf_input = new JTextField();
        tf_input.setColumns(10);
        label_msg = new JLabel("Enter Text:");

        mainPanel.add(label_title);
        mainPanel.add(label_image);
        mainPanel.add(label_msg);
        mainPanel.add(tf_input);
        mainPanel.add(button_submit);
        mainWindow.add(mainPanel);
        mainWindow.setVisible(true);

    }

    private class Event_Submitted implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Triggered");
            mainWindow.remove(mainPanel);
            mainWindow.repaint();
        }
    }
}
