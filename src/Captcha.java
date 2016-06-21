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
    CaptchaOverlayPanel captchaOverlayPanel;
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
        mainWindow.setSize(new Dimension(300, 300));

        //TODO: Implement Layout Manager

        mainPanel = new JPanel();
        label_title = new JLabel("Captcha");
        captchaOverlayPanel = new CaptchaOverlayPanel("lolololololol");
        button_submit = new JButton("Submit");
        button_submit.addActionListener(new Event_Submitted()); //Button Handler

        tf_input = new JTextField();
        tf_input.setColumns(10);
        tf_input.setMaximumSize(new Dimension(100, 50));
        label_msg = new JLabel("Enter Text:");
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        //Fix Alignment
        label_title.setAlignmentX(Component.CENTER_ALIGNMENT);
        tf_input.setAlignmentX(Component.CENTER_ALIGNMENT);
        button_submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        captchaOverlayPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //Add Components to the Container
        mainPanel.add(label_title);
        mainPanel.add(captchaOverlayPanel);
        //mainPanel.add(label_image);
        //mainPanel.add(label_msg);
        mainPanel.add(tf_input);
        mainPanel.add(button_submit);

        mainWindow.add(mainPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
