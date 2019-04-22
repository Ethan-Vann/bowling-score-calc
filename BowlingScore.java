public class BowlingScore {
    public static int bowlingCalc(int[] scores) {
        int totalScore = 0;
        //first used to keep track of whether this is the first roll of the turn
        boolean first = true;
        for (int i = 0; i < scores.length; i++) {
            //special handling for the last 3 rolls
            if (i == 18 || i == 19 || i == 20) {
                totalScore += scores[i];
                //if this is the first roll
            } else if (first) {
                //set first to false to handle the next roll
                first = false;
                //handling for a strike
                if (scores[i] == 10) {
                    //set first to true because strikes skip a roll
                    first = true;
                    //add the 10 points from a strike
                    totalScore += 10;
                    //if the next roll is also a strike add the first roll after it
                    if (scores[i + 2] == 10 && i != 16) {
                        totalScore += scores[i + 2];
                        totalScore += scores[i + 4];
                        //if the next roll isn't a strike simple add both of the next turn rolls to the total
                    } else {
                        totalScore += scores[i + 2];
                        totalScore += scores[i + 3];
                    }
                    i += 1;
                    //if its not a strike simple add the result of this role
                } else {
                    totalScore += scores[i];
                }
                //handling for the second roll of a turn
            } else {
                //set first back to true to get ready to handle the next roll
                first = true;
                //handling of spares add the next roll as well, no special cases
                if (scores[i] + scores[i - 1] == 10) {
                    totalScore += scores[i];
                    totalScore += scores[i + 1];
                    //handling for no spare, just add the result of the roll
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
        System.out.println("checking random rolls answer should be 126, answer: " + bowlingCalc(scores3));
    }
}
