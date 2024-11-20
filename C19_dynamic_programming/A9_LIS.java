package C19_dynamic_programming;

import java.util.Arrays;

// find the longest increasing subsequence length
// eg . 8 1 3 6 7 10 4
// ans >> 1 3 6 7 10 (length = 5)
public class A9_LIS {
    public static int LIS(int[] input){
        int n = input.length;
        int maxlenLIS = 0;
//        dp[i] will store the maxlen of LIS by including a[i]
        int[] dp = new int[n];

        for (int i = 0; i < n; i++){
//            find the best ending
//            search for j < i and a[j] < a[i]. store the max dp[j] + 1 in dp[i]
            for (int j = i - 1; j >= 0; j--){
                if (input[j] < input[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
//            include the curr elem in its LIS
            dp[i] += 1;
            maxlenLIS = Math.max(maxlenLIS, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxlenLIS;
    }
    public static void main(String[] args) {
        int[] input = {8, 1, 3, 6, 7, 10, 4};
        System.out.println(LIS(input));
    }
}
