package hexlet.code;

import java.util.Scanner;

public class Games {
    private static final int minValue = 1;
    private static final int maxValue = 100;

    private static int getRandInt(int start, int end) {
        return  start + (int) (Math.random() * (end - start + 1));
    }

    public static String getGreeting(int gameNum) {
        if (gameNum == 2) return "Answer 'yes' if the number is even, otherwise answer 'no'.";
        else if (gameNum == 3) return "What is the result of the expression?";
        return null;
    }

    public static String[] getQuestionAndAnswer(int gameNum) {
        if (gameNum == 2) return even();
        else return calc();
    }

    public static String[] even() {
        int randomValue = getRandInt(minValue, maxValue);
        String answer = randomValue % 2 == 0 ? "yes" : "no";
        String question = String.valueOf(randomValue);
        return new String[] { question, answer };
    }

    public static String[] calc() {
        int answer;
        String operation;
        int a = getRandInt(minValue, maxValue);
        int b = getRandInt(minValue, maxValue);
        int operationNum = getRandInt(0, 2);
        if (operationNum == 0) {
            operation = "+";
            answer = a + b;
        }
        else if (operationNum == 1) {
            operation = "-";
            answer = a - b;
        }
        else {
            operation = "*";
            answer = a * b;
        }
        return new String[] { String.format("%d %s %d", a, operation, b), String.valueOf(answer) };
    }
}
