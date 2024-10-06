package hexlet.code;

public class Games {
    public static final String[] GAMES = {"Exit", "Greet", "Even", "Calc", "GCD", "Progression", "Prime"};
    private static final int MINVALUE = 1;
    private static final int MAXVALUE = 100;

    private static int getRandInt(int start, int end) {
        return  start + (int) (Math.random() * (end - start + 1));
    }

    public static String getGreeting(int gameNum) {
        String res = "";
        if (gameNum == 2) {
            res = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        } else if (gameNum == 3) {
            res = "What is the result of the expression?";
        } else if (gameNum == 4) {
            res = "Find the greatest common divisor of given numbers.";
        } else if (gameNum == 5) {
            res = "What number is missing in the progression?";
        } else if (gameNum == 6) {
            res = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        }
        return res;
    }

    public static String[] getQuestionAndAnswer(int gameNum) {
        String[] res = {"", ""};
        if (gameNum == 2) {
            res = even();
        } else if (gameNum == 3) {
            res = calc();
        } else if (gameNum == 4) {
            res = gsd();
        } else if (gameNum == 5) {
            res = progression();
        } else if (gameNum == 6) {
            res = prime();
        }
        return res;
    }

    public static String[] even() {
        int n = getRandInt(MINVALUE, MAXVALUE);
        String answer = n % 2 == 0 ? "yes" : "no";
        String question = String.valueOf(n);
        return new String[] {question, answer};
    }

    public static String[] calc() {
        int answer;
        String operation;
        int a = getRandInt(MINVALUE, MAXVALUE);
        int b = getRandInt(MINVALUE, MAXVALUE);
        int operationNum = getRandInt(0, 2);
        if (operationNum == 0) {
            operation = "+";
            answer = a + b;
        } else if (operationNum == 1) {
            operation = "-";
            answer = a - b;
        } else {
            operation = "*";
            answer = a * b;
        }
        return new String[] {String.format("%d %s %d", a, operation, b), String.valueOf(answer)};
    }

    private static int findGSD(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return Math.max(a, b);
    }

    public static String[] gsd() {
        int a = getRandInt(MINVALUE, MAXVALUE);
        int b = getRandInt(MINVALUE, MAXVALUE);
        return new String[] {a + " " + b, String.valueOf(findGSD(a, b))};
    }

    private static int[] getProgressionArr(int progressionLen, int firstElem, int step) {
        int[] progressionArr = new int[progressionLen];
        progressionArr[0] = firstElem;

        for (int i = 1; i < progressionLen; i++) {
            progressionArr[i] = progressionArr[i - 1] + step;
        }
        return progressionArr;
    }

    public static String[] progression() {
        final int progressionLen = 10;
        final int startValueMin = 1;
        final int startValueMax = 20;
        final int startStepMin = 1;
        final int startStepMax = 8;
        final int step = getRandInt(startStepMin, startStepMax);
        final int pointNum = getRandInt(0, progressionLen - 1);
        final int firstElem = getRandInt(startValueMin, startValueMax);

        int[] progressionArr = getProgressionArr(progressionLen, firstElem, step);

        StringBuilder question = new StringBuilder();
        for (int i = 0; i < progressionLen; i++) {
            if (i == pointNum) {
                question.append("..");
            } else {
                question.append(progressionArr[i]);
            }

            if (i < progressionLen - 1) {
                question.append(" ");
            }
        }

        return new String[] {question.toString(), String.valueOf(progressionArr[pointNum])};
    }

    private static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static String[] prime() {
        final int n = getRandInt(MINVALUE, MAXVALUE);
        return new String[] {String.valueOf(n), isPrime(n) ? "yes" : "no"};
    }
}
