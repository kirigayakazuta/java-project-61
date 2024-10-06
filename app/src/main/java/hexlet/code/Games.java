package hexlet.code;

import java.util.Scanner;

public class Games {
    public static void even(Scanner in) {
        int ansCount = 0;
        int maxAnsCount = 3;
        int minValue = 1;
        int maxValue = 100;
        String name = Cli.greet(in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (ansCount < maxAnsCount) {
            int randomValue = minValue + (int) (Math.random() * (maxValue - minValue + 1));
            System.out.println("Question: " + randomValue);
            System.out.print("Your answer: ");
            String answer = in.nextLine();
            if (answer.equals("yes") && randomValue % 2 == 0) {
                ansCount++;
                System.out.println("Correct!");
            }
            else if (answer.equals("no") && randomValue % 2 != 0) {
                ansCount++;
                System.out.println("Correct!");
            }
            else {
                System.out.println(String.format("'%s' is wrong answer ;(. Correct answer was '%s'.",
                        answer, randomValue % 2 == 0 ? "yes" : "no"));
                return;
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }
}
