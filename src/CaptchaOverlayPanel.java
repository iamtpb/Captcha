import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class CaptchaOverlayPanel extends JPanel {
    private BufferedImage bg;
    private Random random;
    private TextManager textManager;
    private String CaptchaSecret;

    public CaptchaOverlayPanel() {
        textManager = new TextManager();
        String cText = textManager.getRandomString();
        CaptchaSecret = cText;
        try {
            bg = ImageIO.read(new File("src//img3.png"));

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
        g.drawImage(bg, 0, 0, null);
    }

    public String getSecret() {
        return CaptchaSecret;
    }

    private BufferedImage process(BufferedImage oldImage, String cText) {
        BufferedImage img;

        int w = oldImage.getWidth();
        int h = oldImage.getHeight();

        img = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = img.createGraphics();
        g2d.drawImage(oldImage, 0, 0, null);

        g2d.setPaint(Color.black);

        FontMetrics fm = g2d.getFontMetrics();

        int x = (int) (img.getWidth() / 2 - fm.stringWidth(cText) / 1.3);
        int y = (int) (img.getHeight() / 1.5 - fm.getHeight() / 1.5);
        x -= 50;
        int offsetX = 0, offsetY = 0;
        for (int i = 0; i < cText.length(); i++) {
            char Char = cText.charAt(i);

            g2d.setFont(new Font("Serif", Font.ITALIC, randomizeFontSize()));

            g2d.drawString(String.valueOf(Char), x + offsetX, y + offsetY);
            offsetX += fm.charWidth(Char) + randomizeX();
            System.out.println(offsetX);
            offsetY += randomizeY();
        }
        g2d.dispose();

        return img;
    }

    private int randomizeFontSize() {
        random = new Random();
        int r_fontsize = random.nextInt(60 - 35 + 1);
        return r_fontsize + 35;
    }

    private int randomizeX() {
        random = new Random();
        int r_x = random.nextInt(30);
        return r_x;
    }

    private int randomizeY() {
        random = new Random();
        int r_y = random.nextInt(25);
        return r_y - 10;
    }
}
