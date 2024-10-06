package hexlet.code.games;

import java.util.Map;

public class Games {
    public static final String[] GAMES = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};
    public static final Map<String, Integer> GAMESMAP = Map.of(
            "Exit",         0,
            "Greet",        1,
            "Even",         2,
            "Calc",         3,
            "GCD",          4,
            "Progression",  5,
            "Prime",        6);
    public static final int MINVALUE = 1;
    public static final int MAXVALUE = 100;

    public static int getRandInt(int start, int end) {
        return  start + (int) (Math.random() * (end - start + 1));
    }

    public static String getGreeting(int gameNum) {
        String res = "";
        if (gameNum == GAMESMAP.get("Even")) {
            res = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        } else if (gameNum == GAMESMAP.get("Calc")) {
            res = "What is the result of the expression?";
        } else if (gameNum == GAMESMAP.get("GCD")) {
            res = "Find the greatest common divisor of given numbers.";
        } else if (gameNum == GAMESMAP.get("Progression")) {
            res = "What number is missing in the progression?";
        } else if (gameNum == GAMESMAP.get("Prime")) {
            res = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        }
        return res;
    }

    public static String[] getQuestionAndAnswer(int gameNum) {
        String[] res = {"", ""};
        if (gameNum == GAMESMAP.get("Even")) {
            res = Even.even();
        } else if (gameNum == GAMESMAP.get("Calc")) {
            res = Calc.calc();
        } else if (gameNum == GAMESMAP.get("GCD")) {
            res = GSD.gsd();
        } else if (gameNum == GAMESMAP.get("Progression")) {
            res = Progression.progression();
        } else if (gameNum == GAMESMAP.get("Prime")) {
            res = Prime.prime();
        }
        return res;
    }
}
