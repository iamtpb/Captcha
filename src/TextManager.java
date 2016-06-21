import java.security.SecureRandom;
import java.util.Random;

public class TextManager {

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();
    Random random;

    public TextManager() {
        random = new Random();
    }

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public String getRandomString() {
        int x = random.nextInt(9 - 5 + 1);
        x += 3;
        return randomString(x);
    }
}
