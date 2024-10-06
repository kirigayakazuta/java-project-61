package hexlet.code;

public class Games {
    public static final String[] GAMES = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression"};
    private static final int minValue = 1;
    private static final int maxValue = 100;

    private static int getRandInt(int start, int end) {
        return  start + (int) (Math.random() * (end - start + 1));
    }

    public static String getGreeting(int gameNum) {
        if (gameNum == 2) return "Answer 'yes' if the number is even, otherwise answer 'no'.";
        else if (gameNum == 3) return "What is the result of the expression?";
        else if (gameNum == 4) return "Find the greatest common divisor of given numbers.";
        else if (gameNum == 5) return "What number is missing in the progression?";
        return null;
    }

    public static String[] getQuestionAndAnswer(int gameNum) {
        if (gameNum == 2) return even();
        else if (gameNum == 3) return calc();
        else if (gameNum == 4) return gsd();
        else if (gameNum == 5) return progression();
        else return new String[] { "", "" };
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

    private static int findGSD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) a = a % b;
            else b = b % a;
        }
        return Math.max(a, b);
    }

    public static String[] gsd() {
        int a = getRandInt(minValue, maxValue);
        int b = getRandInt(minValue, maxValue);
        return new String[] { a + " " + b, String.valueOf(findGSD(a, b)) };
    }

    public static String[] progression() {
        final int progressionLen = 10;
        final int startValueMin = 1;
        final int startValueMax = 20;
        final int startStepMin = 1;
        final int startStepMax = 8;
        final int step = getRandInt(startStepMin, startStepMax);
        final int pointNum = getRandInt(0, progressionLen - 1);
        int[] progressionArr = new int[progressionLen];
        progressionArr[0] = getRandInt(startValueMin, startValueMax);

        for (int i = 1; i < progressionLen; i++) {
            progressionArr[i] = progressionArr[i - 1] + step;
        }

        StringBuilder question = new StringBuilder();
        for (int i = 0; i < progressionLen; i++) {
            if (i == pointNum) question.append("..");
            else question.append(progressionArr[i]);
            if (i < progressionLen - 1) question.append(" ");
        }

        return new String[] { question.toString(), String.valueOf(progressionArr[pointNum])};
    }
}
