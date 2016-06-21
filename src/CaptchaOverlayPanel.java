import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class CaptchaOverlayPanel extends JPanel {
    private BufferedImage bg;

    public CaptchaOverlayPanel(String cText) {
        try {
            bg = ImageIO.read(new File("src//img1.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setSize(200, 200);
        this.setPreferredSize(new Dimension(200, 100));
        this.setMinimumSize(new Dimension(200, 100));
        this.setMaximumSize(new Dimension(200, 100));
        bg = process(bg, cText);
    }

    public Dimension getPreferredSize() {
        return new Dimension(bg.getWidth(), bg.getHeight());
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg, 10, 20, null);
    }

    private BufferedImage process(BufferedImage oldImage, String cText) {
        BufferedImage img;
        int w = oldImage.getWidth();
        int h = oldImage.getHeight();

        img = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(oldImage, 10, 20, null);

        g2d.setPaint(Color.red);
        g2d.setFont(new Font("Serif", Font.BOLD, 20));


        FontMetrics fm = g2d.getFontMetrics();

        int x = img.getWidth() - fm.stringWidth(cText) - 5;
        int y = fm.getHeight();

        g2d.drawString(cText, x, y);
        g2d.dispose();

        return img;
    }

}
