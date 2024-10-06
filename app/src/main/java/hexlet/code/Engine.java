package hexlet.code;

import java.util.Scanner;
import static hexlet.code.Games.GAMES;

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

    public static void startGame() {
        System.out.println("Please enter the game number and press Enter.");
        printGames();

        Scanner in = new Scanner(System.in);
        System.out.print("Your choice: ");
        int gameNum = in.nextInt();
        in.nextLine();

        if (gameNum == 0) return;

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = in.nextLine();
        System.out.println("Hello, " + name + "!");

        if (gameNum == 1) return;

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
            }
            else {
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.",
                        myAnswer, parameters[ANSWER]));
                return;
            }
        }

        System.out.println("Congratulations, " + name + "!");
        in.close();
    }
}
