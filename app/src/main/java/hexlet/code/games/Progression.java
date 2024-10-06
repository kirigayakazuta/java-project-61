package hexlet.code.games;

import static hexlet.code.games.Games.getRandInt;

public class Progression {
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
}
