import java.awt.Toolkit;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LearningSession ls = new LearningSession(60, 2, 10, true);
        ls.learningSession();
    }

}
