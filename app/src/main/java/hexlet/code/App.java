package hexlet.code;

import java.util.Scanner;

public class App {
    private static final String[] GAMES = {"Exit", "Greet", "Even"};

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");

        for (int i =  1; i < GAMES.length; i++) {
            System.out.println(i + " - " + GAMES[i]);
        }
        System.out.println(0 + " - " + GAMES[0]);

        Scanner in = new Scanner(System.in);
        System.out.print("Your choice: ");
        int gameNum = in.nextInt();
        in.nextLine();

        if (gameNum == 0) return;

        if (gameNum == 1) Cli.greet(in);
        else if (gameNum == 2) Games.even(in);

        in.close();

    }
}
