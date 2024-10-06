package hexlet.code.games;

import static hexlet.code.games.Games.MAXVALUE;
import static hexlet.code.games.Games.MINVALUE;
import static hexlet.code.games.Games.getRandInt;

public class Calc {

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
}
