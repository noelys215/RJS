import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var random = new Random();

        System.out.print("Enter the number of dice to roll: ");
        int numOfDice = scanner.nextInt();

        if (numOfDice <= 0) {
            System.out.println("Number of dice must be greater than 0");
            return;
        }

        int total = 0;
        for (int i = 0; i < numOfDice; i++) {
            int roll = random.nextInt(1, 7);
            printDie(roll);
            System.out.println("You rolled: " + roll);
            total += roll;
        }

        System.out.println("Total: " + total);
        scanner.close();
    }

    static void printDie(int roll) {
        String[] diceFaces = {
                """
             -------
            |       |
            |   ●   |
            |       |
             -------
            """,
                """
             -------
            | ●     |
            |       |
            |     ● |
             -------
            """,
                """
             -------
            | ●     |
            |   ●   |
            |     ● |
             -------
            """,
                """
             -------
            | ●   ● |
            |       |
            | ●   ● |
             -------
            """,
                """
             -------
            | ●   ● |
            |   ●   |
            | ●   ● |
             -------
            """,
                """
             -------
            | ●   ● |
            | ●   ● |
            | ●   ● |
             -------
            """
        };

        System.out.print(diceFaces[roll - 1]);
    }
}
