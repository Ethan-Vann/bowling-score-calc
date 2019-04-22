public class BowlingScore {
    public static int bowlingCalc(int[] scores) {
        int totalScore = 0;
        boolean first = true;
        for (int i = 0; i < scores.length; i++) {
            if (i == 18 || i == 19 || i == 20) {
                totalScore += scores[i];
            } else if (first) {
                first = false;
                if (scores[i] == 10) {
                    first = true;
                    totalScore += 10;
                    if (scores[i + 2] == 10 && i != 16) {
                        totalScore += scores[i + 2];
                        totalScore += scores[i + 4];
                    } else {
                        totalScore += scores[i + 2];
                        totalScore += scores[i + 3];
                    }
                    i += 1;
                } else {
                    totalScore += scores[i];
                }
            } else {
                first = true;
                if (scores[i] + scores[i - 1] == 10) {
                    totalScore += scores[i];
                    totalScore += scores[i + 1];
                } else {
                    totalScore += scores[i];
                }
            }
        }
        return totalScore;
    }

    public static void main(String[] args) {
        //frames
        int[] scores = {10, 0, 10, 0, 10, 0, 10, 0, 5, 5, 10, 0, 10, 0, 10, 0, 10, 0, 10, 10, 10};
        int[] scores2 = {1, 9, 3, 7, 2, 8, 5, 5, 5, 5, 2, 8, 3, 7, 9, 1, 6, 4, 4, 6, 1};
        int[] scores3 = {2, 7, 3, 4, 2, 7, 4, 6, 10, 0, 10, 0, 2, 7, 4, 6, 1, 9, 4, 2, 0};
        System.out.println("checking all strikes answer should be 300, answer: " + bowlingCalc(scores));
        System.out.println("checking all spares answer should be 140, answer: " + bowlingCalc(scores2));
        System.out.println("checking random rolls 1 answer should be 126, answer: " + bowlingCalc(scores3));
    }
}
