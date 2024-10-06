package hexlet.code.games;

import static hexlet.code.games.Games.MAXVALUE;
import static hexlet.code.games.Games.MINVALUE;
import static hexlet.code.games.Games.getRandInt;

public class Even {
    public static String[] even() {
        int n = getRandInt(MINVALUE, MAXVALUE);
        String answer = n % 2 == 0 ? "yes" : "no";
        String question = String.valueOf(n);
        return new String[] {question, answer};
    }
}
