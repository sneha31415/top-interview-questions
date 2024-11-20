package C19_dynamic_programming;

//problem : find the number of ways to climb n stairs in which u can take a jump of max k at each step
//initially u r standing at the ground
public class A6_climbling_stairs {
    public static int climbingStairs(int n, int k){
        if (n < 0) return 0;

//       num stairs = 0. Number of ways to stand on ground is 1. =
        if (n == 0) return 1;

        int ans = 0;
        for (int i = 1; i <= k; i++){
            ans += climbingStairs(n - i, k);
        }
        return ans;
    }


//    ----------------top down-------------------
//    Tc = O(N x K)
public static int topDown(int n, int k, int[] dp){
//        number of ways to stand on ground is 1
    if (n == 0) return 1;

//    lookup
    if (dp[n] != 0) return dp[n];

    int ways = 0;
    for (int i = 1; i <= k; i++){
//        you cannot make a call for negative number of stairs
        if (n - i >= 0) {
            ways += topDown(n - i, k, dp);
        }
    }
    return dp[n] = ways ;
}


//-------------------bottom up---------------------
//    Tc = O(N x K) bcuz for each N we iterate over the last k steps and sum them
    public static int bottomUp(int n, int k){
        int[] dp = new int[n + 1];
        dp[0] = 1 ; // base case


//        fill each i number of stairs,
        for (int i = 0; i < n + 1; i++){
//        try all the possible ways to reach ith stair. ie iterate over the last k steps and sum it
            for (int step = 1; step <= k; step++){
                if (i - step >= 0){
//        answer of the previous states is used to compute current state
                    dp[i] += dp[i - step];
                }
            }
        }
        return dp[n];
    }

//    ---------bottom up approach optimised to O(N)--------
//    kinda sliding window
    public static int bottomUpOptimised(int n, int k){
        int dp[] = new int[n + 1];
//      base case
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = 2 * dp[i - 1];
            if (i - k - 1 >= 0){
                dp[i] -= dp[i - k - 1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(climbingStairs(n , k));
        int[] dp = new int[n + 1];
        System.out.println(topDown(n , k, dp));
        System.out.println(bottomUp(n , k));
        System.out.println(bottomUpOptimised(n , k));

    }
}
