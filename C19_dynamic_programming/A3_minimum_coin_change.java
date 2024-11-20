package C19_dynamic_programming;

import java.util.Scanner;

public class A3_minimum_coin_change {
//    recursive
//    TC = O(T ^ N) where N is rupees
    public static int minimumCoinChange(int rupees, int[] allChanges){
//        you need no changes if rupees = 0
        if (rupees == 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;

//        try all possible changes
        for (int change : allChanges) {
            if (rupees - change >= 0) {
//                unlike the previous question, here we have to take the minimum of many options
                ans = Math.min(ans, minimumCoinChange(rupees -change, allChanges) + 1);
            }
        }
        return ans;
    }
// --------------------Top down---------------------
//      tc = O(T x N) where T is the type of coins and N is rupees
    public static int topDown(int rupees, int[] allChanges, int[] dp){
//        base case
        if (rupees == 0){
            return 0;
        }

//        look up
        if (dp[rupees] != 0) return dp[rupees];

//        recursion
        int ans = Integer.MAX_VALUE;
//        make a call on all possible subproblems and pick the minimum most option
        for (int change : allChanges) {
            if (rupees - change >= 0) {
                ans = Math.min(ans, topDown(rupees -change, allChanges, dp) + 1);
            }
        }
        return dp[rupees] = ans;
    }

//    ------------------bottom up ---------------------
//    tc = O(T x N) where T is the type of coins and N is rupees
    public static int bottomUp(int rupees, int[] allChanges){
        int[] dp = new int[rupees + 1];

//        fill each dp elem
        for (int i = 1; i <= rupees; i++) {
//            for each elem consider all possibilities and pick the minimum most
            int possibility = Integer.MAX_VALUE; //or initialise dp[i] = Integer.MAX_VALUE;
            for (int change : allChanges) {
                if (i - change >= 0) {
                    possibility = Math.min(possibility, dp[i - change] + 1);
                }
            }
            dp[i] = possibility;
        }
        return dp[rupees];
    }
//    follow ups : will there always be a change of 1? cuz if not then we may not be able to express some rupees
    public static void main(String[] args) {
        int[] allChanges = {1, 7, 10};
        int rupees = 56;
//        System.out.println(minimumCoinChange(rupees, allChanges));

        int[] dp = new int[rupees + 1];
//        dp[0] = 0 base case
        System.out.println(topDown(rupees, allChanges, dp));
        System.out.println(bottomUp(rupees, allChanges));
        System.out.println(minimumCoinChange(rupees, allChanges));


    }
}
