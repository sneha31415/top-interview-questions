package C18_problem_solving_using_hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class A1_subarray_sum_zero {
//    return true is there exists a subarray whose sum is zero
    public static boolean zeroSumSubarray(int[] input){
        int n = input.length;
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += input[j];
                if(sum == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean zeroSumSubarrayBetter(int[] input){
        int n = input.length;
        int[] prefix = new int[n + 1];
        prefix[0] = 0;
        for(int i = 0; i < n; i++){
            prefix[i + 1] = input[i] + prefix[i];
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j <= n; j++){
                if(prefix[j] - prefix[i] == 0){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean zeroSumSubarrayBest(int[] input){
        int cumulative = 0; // running prefix sum
        HashSet<Integer> prefix = new HashSet<>();
//        to find the subarray also, maintain a hashmap with prefix sums, and indices
        for(int i = 0; i < input.length; i++){
            cumulative += input[i];
//            Edge case : when the whole array sums to zero, (cum = 0)
            if(cumulative == 0 || prefix.contains(cumulative)) {
                return true;
            }
            prefix.add(cumulative);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {-1,-1,-1, -1, 4};
        System.out.println(zeroSumSubarrayBest(input)); // O(n^2)
        System.out.println(zeroSumSubarrayBetter(input)); // O(n^2)
        System.out.println(zeroSumSubarray(input)); // O(n)
    }
}
