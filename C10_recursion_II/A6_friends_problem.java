package C10_recursion_III;

import java.util.Arrays;
import java.util.Scanner;

//given n friends decude the number of ways in which they can goto a party if each guy can go alone or as a couple(chose partner from the n people only)
public class A6_friends_problem {
    public static int num_ways_togo_party(int n){
        if (n == 1 || n == 0){
            return 1;
        }
        return num_ways_togo_party(n - 1) + (n - 1) * num_ways_togo_party(n - 2);
    }

//  bottom up
    public static int bottomUp(int n, int[] dp){
        if (n == 1 || n == 0){
            return 1;
        }
        if(dp[n] != 0) return dp[n];

        return dp[n] = num_ways_togo_party(n - 1) + (n - 1) * num_ways_togo_party(n - 2);
    }

    public static int topDown(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }

    public static int spaceOptimised(int n){
        if (n == 0){
            return 1;
        }
        int prev = 1; //dp[n - 1]
        int prevPrev = 1; //dp[n - 2]

        for (int i = 1; i <= n; i++){
            int ways = prev + (i - 1) * prevPrev;
            prevPrev = prev;
            prev =  ways;
        }
        return prev;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(num_ways_togo_party(n));

        int[] dp = new int[n + 1];
        System.out.println(bottomUp(n, dp));

        System.out.println(topDown(n));
        System.out.println(spaceOptimised(n));

        char[] temp = {'1', '4', '2'};
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
    }
}
