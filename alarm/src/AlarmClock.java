import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class AlarmClock implements Runnable {
    private final LocalTime alarmTime;
    private final String filePath;

    public AlarmClock(LocalTime alarmTime, String filePath) {
        this.alarmTime = alarmTime;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        while (Duration.between(LocalTime.now(), alarmTime).getSeconds() > 0) {
            try {
                Thread.sleep(1000);
                LocalTime now = LocalTime.now();
                System.out.printf("\r%02d:%02d:%02d", now.getHour(), now.getMinute(), now.getSecond());
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println("\n*ALARM NOISES*");
        playSound();
    }

    private void playSound() {
        try (Scanner scanner = new Scanner(System.in);
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File(filePath))) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            System.out.print("Press Enter to Stop ");
            scanner.nextLine();
            clip.stop();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }
}
