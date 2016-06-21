import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Captcha {
    int tries = 0;
    JFrame mainWindow;
    JPanel mainPanel;
    JLabel label_title, button_reset, label_msg;
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

        mainPanel = new JPanel();
        label_title = new JLabel("Captcha");
        captchaOverlayPanel = new CaptchaOverlayPanel();
        button_submit = new JButton("Submit");
        button_submit.addActionListener(new Event_Submitted()); //Button Handler
        button_reset = new JLabel("r");
        button_reset.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Reset Key Pressed");
                mainPanel.remove(1);
                captchaOverlayPanel = new CaptchaOverlayPanel();
                mainPanel.add(captchaOverlayPanel, 1);
                mainWindow.revalidate();
                mainWindow.repaint();
            }
        });
        tf_input = new JTextField();
        tf_input.setColumns(10);
        tf_input.setMaximumSize(new Dimension(100, 50));
        label_msg = new JLabel("Enter Text:");

        JPanel tx_reset = new JPanel();
        tx_reset.setLayout(new BoxLayout(tx_reset, BoxLayout.X_AXIS));
        tx_reset.add(tf_input);
        tx_reset.add(button_reset);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //Fix Alignment

        label_title.setAlignmentX(Component.CENTER_ALIGNMENT);
        tf_input.setAlignmentX(Component.CENTER_ALIGNMENT);
        button_submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        captchaOverlayPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Add Components to the Container

        mainPanel.add(label_title);
        mainPanel.add(captchaOverlayPanel);
        // mainPanel.add(tf_input);
        mainPanel.add(tx_reset);
        mainPanel.add(button_submit);

        mainWindow.add(mainPanel);
        mainWindow.pack();
        mainWindow.setVisible(true);

        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class Event_Submitted implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button_submit) {
                System.out.println("Triggered");
                System.out.println("Original: " + captchaOverlayPanel.getSecret());
                System.out.println("Entered: " + tf_input.getText());
                if (captchaOverlayPanel.getSecret().equals(tf_input.getText())) {
                    System.out.println("Checked!");
                }
                //mainWindow.remove(mainPanel);
                mainWindow.repaint();
            }
        }
    }
}
