package C19_dynamic_programming;

public class A1_fibonnaci {
//    -------------recursive approach---------------
//    TC = O(2^N) , SC = O(N)-> stack space
    public static int fibonacci(int n){
//        base case
        if (n == 0 || n == 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

//    --------top - down approach(recursion + memoization)-----------
//    Sc = O(N + N), TC = O(N)
    public static int recursiveDP(int n, int[] dp){
//        base case
        if (n == 0 || n == 1){
            return n;
        }

//        if fib(n) is already computed, dont recompute
        if (dp[n] != 0){
            return dp[n];
        }
//        before returning, store the answer in dp
        return dp[n] = recursiveDP(n - 1, dp) + recursiveDP(n - 2, dp);
    }


//    ------------bottom up approach---------------
//    Sc = O(N), TC = O(N)
    public static int iterativeDP(int n){
        int[] dp = new int[n + 1];
//        dp[0] = 0; bydefault
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

//    --------------bottom up approach space optimisation-----------------
//    keep 2 variables to keep track of the previous 2 fibonacci, instead of a dp array
//    sc = O(1), Tc = O(N)
    public static int iterativeSpaceOptimised(int n){
        int prev = 1;
        int prevPrev = 0;
        int fib = 0;
        for (int i = 2; i <= n; i++){
            fib =  prev + prevPrev;
            prevPrev = prev;
            prev = fib;
        }
        return fib;
    }
    public static void main(String[] args) {
        int n = 40;
        int[] dp = new int[n + 1];
        System.out.println(fibonacci(n));
        System.out.println(recursiveDP(n, dp));
        System.out.println(iterativeDP(n));
        System.out.println(iterativeSpaceOptimised(n));
    }
}
