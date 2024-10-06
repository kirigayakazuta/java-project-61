package hexlet.code.games;

import static hexlet.code.games.Games.MAXVALUE;
import static hexlet.code.games.Games.MINVALUE;
import static hexlet.code.games.Games.getRandInt;

public class Prime {
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
