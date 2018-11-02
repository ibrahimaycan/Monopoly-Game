
import java.util.Random;

public class Die {
    private int face;
    public int getFaceValue() {
        Random random = new Random();
        face = 1+random.nextInt(6);
        return face;
    }
}
