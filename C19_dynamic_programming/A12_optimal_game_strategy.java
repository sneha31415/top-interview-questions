package C19_dynamic_programming;

import java.util.*;

// given array >> [7, 3, 2, 5, 8, 4]
// two players modi and trump can pick points from the start and end of array.
// both are equally smart. Find the maximum points of modi and the margin by which he wins
public class A12_optimal_game_strategy {
    public static int maxPoints(int[] input, int start, int end){
        if (start > end) {
            return 0;
        }
        int way1 = input[start] + Math.min(maxPoints(input, start + 2, end), maxPoints(input, start + 1, end - 1));
        int way2 = input[end] + Math.min(maxPoints(input, start + 1, end - 1), maxPoints(input, start, end - 2));
        return Math.max(way1, way2);
    }

    public static int margin(int[] scores){
        int scoreSum = 0;
        for (int score : scores){
            scoreSum += score;
        }
        int modiPoints = maxPoints(scores, 0, scores.length - 1);
        int trumpPoints =  scoreSum - modiPoints;
        return modiPoints - trumpPoints;
    }

    //    top down dp
    public static int topdown(int[] input, int start, int end, int[][]dp){
//        base
        if (start > end) {
            return 0;
        }
//        look up
        if (dp[start][end] != -1) return dp[start][end];

//        recursive
//        trump will choose in such a way that modi's scores further lessens
        int modiChoice1 = input[start] + Math.min(topdown(input, start + 2, end, dp), topdown(input, start + 1, end - 1, dp));
        int modiChoice2 = input[end] + Math.min(topdown(input, start + 1, end - 1, dp), topdown(input, start, end - 2, dp));

        return dp[start][end] = Math.max(modiChoice1, modiChoice2);
    }

//    bottom up 

    public static void main(String[] args) {
        int[] input = {7, 3, 2, 8, 5, 4};
        System.out.println(maxPoints(input, 0, input.length - 1));
//        System.out.println(margin(input));
        int n = input.length;

        int[][] dp = new int[n][n];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        System.out.println(topdown(input, 0, n - 1 , dp));
        for (int[] row : dp){
            System.out.println(Arrays.toString(row));
        }
    }
}
