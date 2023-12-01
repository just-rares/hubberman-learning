import java.awt.*;
import java.util.Random;

public class LearningSession {

    final static long totalTime = 60 * 60 * 1000;
    final static long workTime = 2 * 60 * 1000;
    final static long breakTime = 10 * 1000;

    /**
     * Creates a 60-minute work plan, with intermittent random breaks.
     * After 2 minutes of work, at a random time in the following minute,
     * a break is scheduled. During this break it's recommended to do nothing.
     * @throws InterruptedException If Thread.sleep() fails
     */
    public static void learningSession() throws InterruptedException {
    final Random random = new Random();

    long startTime = System.currentTimeMillis();

    while (System.currentTimeMillis() - startTime < totalTime) {
        // Start work period
        playWorkSound();
        Thread.sleep(workTime);

        // Random time for break within the next minute
        long randomBreakTime = random.nextInt(60 * 1000);
        Thread.sleep(randomBreakTime);

        // Start break
        playBreakSound();
        Thread.sleep(breakTime);
    }
}

    /**
     * Plays work specific sound.
     */
    private static void playWorkSound() {
        playBeep(2);
        System.out.println("Start Working");
    }

    /**
     * Play break specific time.
     */
    private static void playBreakSound() {
        playBeep(4);
        System.out.println("Get a break");
    }

    /**
     * Plays n beeps to designate different sounds.
     * @param n Number of beeps to be played.
     */
    private static void playBeep(int n) {
        for(int i = 0; i < n; ++i) {
            Toolkit.getDefaultToolkit().beep();
            try {
                Thread.sleep(500); // Delay between beeps
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
