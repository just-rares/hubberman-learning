import java.awt.*;
import java.util.Random;

public class LearningSession {

    private long totalTime = 60 * 1000;
    private long workTime = 60 * 1000;
    private long breakTime = 1000;
    private boolean randomRewards = true;

    /**
     * Basic constructor with predefined values. Recommended.
     */
    public LearningSession() {
        this.totalTime *= 60;
        this.workTime *= 2;
        this.breakTime *= 10;
    }

    /**
     * @param totalTime Number of minutes your work session will be in minutes.
     * @param workTime Safe time before random break comes in minutes.
     * @param breakTime Break duration in seconds.
     * @param randomRewards Whether to add random rewards in the sessions.
     */
    public LearningSession(long totalTime, long workTime, long breakTime, boolean randomRewards) {
        this.totalTime *= totalTime;
        this.workTime *= totalTime;
        this.breakTime *= totalTime;
        this.randomRewards = randomRewards;
    }

    /**
     * Creates a 60-minute work plan, with intermittent random breaks.
     * After 2 minutes of work, at a random time in the following minute,
     * a break is scheduled. During this break it's recommended to do nothing.
     * @throws InterruptedException If Thread.sleep() fails
     */
    public void learningSession() throws InterruptedException {
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
        playRewardSound();
        Thread.sleep(breakTime);
    }
}

    /**
     * Plays work specific sound.
     */
    private void playWorkSound() {
        playBeep(1);
        System.out.println("Start Working");
    }

    /**
     * Play break specific time.
     */
    private void playBreakSound() {
        playBeep(1);
        System.out.println("Get a break");
    }

    /**
     * Plays reward at random periods
     */
    private void playRewardSound() {
        Random random = new Random();
        if(random.nextInt(10) == 9) {
            playBeep(2);
        }
    }

    /**
     * Plays n beeps to designate different sounds.
     * @param n Number of beeps to be played.
     */
    private void playBeep(int n) {
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
