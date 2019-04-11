public class bowlingScore {
    public static int bowlingCalc(int[][] scores) {
        int totalScore = 0;
        for (int i = 0; i < scores.length; i++) {
            //code for handling the last frame || adds the total of all 3 rolls
            if (i == 9) {
                totalScore += scores[i][0];
                totalScore += scores[i][1];
                totalScore += scores[i][1];
                //code for handling if the player scores a strike || adds the current frame rolls plus the next two rolls
            } else if (scores[i][0] == 10 || scores[i][1] == 10) {
                totalScore += scores[i][0];
                totalScore += scores[i][1];
                //handles if the next roll was a strike
                if (scores[i + 1][0] == 10) {
                    if(i!=8){
                        totalScore+=scores[i+1][0];
                        totalScore+=scores[i+2][0];
                        //handles if the next frame is the second last frame and a strike was the  first roll
                    }else{
                        totalScore+=scores[i+1][0];
                        totalScore+=scores[i+1][1];
                    }
                }else{
                    //handles if you didnt get a strike on the next frame
                    totalScore+=scores[i+1][0];
                    totalScore+=scores[i+1][1];
                }
                //code for handling if the player scores a spare || adds the current frame rolls plus the next roll
            } else if (scores[i][0] + scores[i][1] == 10) {
                totalScore += scores[i + 1][0];
                totalScore += scores[i][0];
                totalScore += scores[i][1];
                //code for handling neither a strike nor a spare adds only the current frame rolls
            } else {
                totalScore += scores[i][0];
                totalScore += scores[i][1];
            }
        }
        return totalScore;
    }

    public static void main(String[] args) {
        //frames
        int[] one = {10, 0};
        int[] two = {10, 0};
        int[] three = {10, 0};
        int[] four = {5, 5};
        int[] five = {10, 0};
        int[] six = {10, 0};
        int[] seven = {10, 0};
        int[] eight = {10, 0};
        int[] nine = {10, 0};
        int[] ten = {10, 10, 10};
        int[][] scores = {one, two, three, four, five, six, seven, eight, nine, ten};
        System.out.println(bowlingCalc(scores));
    }
}
