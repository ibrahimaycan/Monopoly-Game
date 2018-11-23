
import java.util.Random;

public class Die {
    private int face;
    private Random random;

    public Die(){
        random=new Random();
        face=1+random.nextInt(6);
    }
    public int getFaceValue() {
        return face;
    }

    public void setFace() {
        this.face = random.nextInt(6)+1;
    }
}
