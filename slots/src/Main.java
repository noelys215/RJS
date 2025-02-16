import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 100;
        int bet;
        int payout;
        String[] row;

        System.out.println("*************************");
        System.out.println("  Welcome to Java Slots  ");
        System.out.println("Symbols: 🍒 🍉 🍋 🔔 ⭐ ");
        System.out.println("*************************");

        while (balance > 0) {
            System.out.println("Current Balance: $" + balance);
            System.out.print("Place your bet amount: ");
            bet = scanner.nextInt();

            if (bet > balance) {
                System.out.println("Insufficient Funds");
                continue;
            } else if (bet <= 0) {
                System.out.println("Bet must be greater than 0");
            } else {
                balance -= bet;
                System.out.println("$" + balance);
            }
        }

        scanner.close();
    }
}