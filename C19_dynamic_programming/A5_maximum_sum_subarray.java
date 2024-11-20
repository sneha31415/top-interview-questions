package C19_dynamic_programming;


//follow up questions : what should i return if whole array contains negatives
//  what should i return if input array is empty
public class A5_maximum_sum_subarray {
//    bottom  up dp
    public static int maximum_sum_subarray(int[] input){
        int global_max = Integer.MIN_VALUE;
        int currSum = 0;
        int n = input.length;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++){
            currSum += input[i];
            global_max = Math.max(currSum, global_max);

//            i th elem of dp, always contains the max sum uptil i
            dp[i] = global_max;

//            kadane's
            if (currSum < 0){
                currSum = 0;
            }
        }
        return dp[n - 1];
    }

//  ------- cb code by prateek---------
    public static int maxsumsubarray(int[] input){
//       crux : currSum ki jagah we are using dp here
//        thus dp ensures that we dont add a negative sum
        int n = input.length;
        int[] dp = new int[n];
        int maxSoFar = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++){
            if (i == 0){
                dp[0] = input[0];
            }else {
                dp[i] = dp[i - 1] + input[i]; //same as currSum += input[i]
            }

            maxSoFar = Math.max(maxSoFar, dp[i]);

            if (dp[i] < 0){
                dp[i] = 0;
            }
        }
        return maxSoFar;
    }

//    -------------space optimised----------------
//    **the ans of the curr state just depends on the previous state, so we need not store all the states**
    public static int spaceOptimised(int[] input) {
        int global_max = Integer.MIN_VALUE;
        int currSum = 0;
        int n = input.length;

        for (int i = 0; i < n; i++) {
            currSum += input[i];
            global_max = Math.max(currSum, global_max);

//           kadane's
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return global_max;
    }

    public static void main(String[] args) {
        int[] input = {-3, 1, 2, -10, 4, 5, 7,9,0,3};
        System.out.println(maximum_sum_subarray(input));
        System.out.println(maxsumsubarray(input));
        System.out.println(spaceOptimised(input));
        int[] inputnegatives = {-3, -1, -2, -10, -4, -5};
        System.out.println(maximum_sum_subarray(inputnegatives));
        System.out.println(maxsumsubarray(inputnegatives));
        System.out.println(spaceOptimised(inputnegatives));

    }
}
