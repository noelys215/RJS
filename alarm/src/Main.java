import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalTime alarmTime = null;
            String filePath = "beep.wav";

            while (alarmTime == null) {
                System.out.print("Enter an alarm time (HH:MM:SS): ");
                String inputTime = scanner.nextLine().trim();
                alarmTime = parseTime(inputTime, formatter);
            }

            System.out.println("Alarm set for " + alarmTime);
            Thread alarmThread = new Thread(new AlarmClock(alarmTime, filePath));
            alarmThread.start();
        }
    }

    private static LocalTime parseTime(String input, DateTimeFormatter formatter) {
        try {
            return LocalTime.parse(input, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid format, please use HH:MM:SS");
            return null;
        }
    }
}
