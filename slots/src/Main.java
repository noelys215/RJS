import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int balance = 100;
        String playAgain;

        System.out.println("*************************");
        System.out.println("  Welcome to Java Slots  ");
        System.out.println("Symbols: 🍒 🍉 🍋 🔔 ⭐ ");
        System.out.println("*************************");

        while (balance > 0) {
            System.out.println("Current Balance: $" + balance);
            System.out.print("Place your bet amount: ");
            int bet = scanner.nextInt();

            if (bet > balance) {
                System.out.println("Insufficient Funds");
                continue;
            }
            if (bet <= 0) {
                System.out.println("Bet must be greater than 0");
                continue;
            }

            balance -= bet;
            System.out.println("Spinning...");

            var row = spinRow();
            printRow(row);
            int payout = calculatePayout(row, bet);

            if (payout > 0) {
                System.out.println("You won $" + payout);
                balance += payout;
            } else {
                System.out.println("Sorry, you lost this round.");
            }

            System.out.println("Do you want to play again? (Y/N): ");
            playAgain = scanner.next().toUpperCase();

            if (!playAgain.equals("Y")) break;
        }

        System.out.println("GAME OVER! Final Balance: $" + balance);
        scanner.close();
    }

    static String[] spinRow() {
        String[] symbols = {"🍒", "🍉", "🍋", "🔔", "⭐"};
        var random = new Random();
        return new String[]{symbols[random.nextInt(symbols.length)],
                symbols[random.nextInt(symbols.length)],
                symbols[random.nextInt(symbols.length)]};
    }

    static void printRow(String[] row) {
        System.out.println("**************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("**************");
    }

    static int calculatePayout(String[] row, int bet) {
        var multipliers = new java.util.HashMap<String, Integer>();
        multipliers.put("🍒", 3);
        multipliers.put("🍉", 4);
        multipliers.put("🍋", 5);
        multipliers.put("🔔", 10);
        multipliers.put("⭐", 20);

        int matches = countMatches(row);
        if (matches > 0) return bet * multipliers.getOrDefault(row[matches], 0);
        return 0;
    }

    static int countMatches(String[] row) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) return 0;  // Three matches
        if (row[0].equals(row[1]) || row[1].equals(row[2])) return 1;  // Two matches
        return -1; // No match
    }
}
