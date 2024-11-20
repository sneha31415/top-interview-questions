package C19_dynamic_programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

// find the minimum steps to reach 1 from n
// you can do (n - 1), n / 2 or n / 3 at each step
public class    A2_minimum_steps_to_one {
//    --------------recursive-----------------
    public static int minimumStepsToOne(int n){
//        base case
        if (n == 1){
            return 0;
        }

        int minusOne = minimumStepsToOne(n - 1);
        int byTwo = Integer.MAX_VALUE;
        if (n % 2 == 0){
            byTwo = minimumStepsToOne(n / 2);
        }
        int byThree = Integer.MAX_VALUE;
        if (n % 3 == 0){
            byThree = minimumStepsToOne(n / 3);
        }
        return Math.min(minusOne, Math.min(byTwo, byThree)) + 1;
    }

//    -----------------recursive dp------------------
    public static int topDown(int n, int[] dp){
        if (n == 1){
            return 0;
        }
//        look up for precomputed values
        if (dp[n] != 0) return dp[n];

//        compute if dp[n] is not known
//        get the possible states ka answer that you can reach from n
        int minusOne = topDown(n - 1, dp);

        int byTwo = Integer.MAX_VALUE;
        if (n % 2 == 0) byTwo = topDown(n / 2, dp);

        int byThree = Integer.MAX_VALUE;
        if (n % 3 == 0) byThree = topDown(n / 3, dp);

        return dp[n] = Math.min(minusOne, Math.min(byTwo, byThree)) + 1;

    }

//    ------------------iterative dp-------------------------
    public static int bottomUp(int n){
        int[] dp = new int[n + 1];
//        dp[1] is 0
        for (int i = 2; i < n + 1; i++){
            int minusOne = dp[i - 1];
            int byTwo = Integer.MAX_VALUE;
            if (i % 2 == 0) byTwo = dp[i / 2];

            int byThree = Integer.MAX_VALUE;
            if (i % 3 == 0) byThree = dp[i / 3];

            dp[i] = Math.min(minusOne, Math.min(byTwo, byThree)) + 1;
        }
        return dp[n];
    }

//    follow up Questions : can the input be 0 or negative
    public static void main(String[] args) {
        int n = 100;
        System.out.println(minimumStepsToOne(n));

        int[] dp = new int[n + 1];
        System.out.println(topDown(n, dp));
        System.out.println(bottomUp(n));
        ArrayList<Character> vowel = new ArrayList<>();
        Collections.addAll(vowel, 'a', 'e', 'i', 'o', 'u');
        System.out.println(vowel);
    }
}
