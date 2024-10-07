package hexlet.code;

import hexlet.code.games.Games;

import java.util.Scanner;
import static hexlet.code.games.Games.GAMES;

public class Engine {

    private static final int MAX = 3;
    private static final int QUESTION = 0;
    private static final int ANSWER = 1;

    private static void printGames() {
        for (int i = 1; i < GAMES.length; i++) {
            System.out.println(i + " - " + GAMES[i]);
        }
        System.out.println(0 + " - " + GAMES[0]);
    }

    private static void printError() {
        System.out.print("Incorrect input. Try again.");
    }

    private static int getGameNum(Scanner in) {
        int gameNum;
        System.out.print("Your choice: ");
        if (!in.hasNextInt()) {
            printError();
            return 0;
        }
        gameNum = in.nextInt();
        if (gameNum < 0 || gameNum > GAMES.length - 1) {
            printError();
            return 0;
        }
        in.nextLine();

        return gameNum;
    }

    private static String getName(Scanner in) {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void startGame() {
        System.out.println("Please enter the game number and press Enter.");
        printGames();
        Scanner in = new Scanner(System.in);

        int gameNum = getGameNum(in);
        if (gameNum == 0) {
            return;
        }

        String name = getName(in);
        if (gameNum == 1) {
            return;
        }

        System.out.println(Games.getGreeting(gameNum));

        int ansCount = 0;
        while (ansCount < MAX) {
            String[] parameters = Games.getQuestionAndAnswer(gameNum);
            System.out.println("Question: " + parameters[QUESTION]);
            System.out.print("Your answer: ");
            String myAnswer = in.nextLine();

            if (myAnswer.equals(parameters[ANSWER])) {
                ansCount++;
                System.out.println("Correct!");
            } else {
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.",
                        myAnswer, parameters[ANSWER]));
                System.out.println("Let's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
        in.close();
    }
}
