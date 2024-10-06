package hexlet.code.games;

import static hexlet.code.games.Games.MAXVALUE;
import static hexlet.code.games.Games.MINVALUE;
import static hexlet.code.games.Games.getRandInt;

public class GSD {
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
}
