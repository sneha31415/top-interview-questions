package C18_problem_solving_using_hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class A3_longest_subarray_with_sum_k {
//    since we need "longest" subarray, here also we will store the first occurance of each cumulative sum
//    this problem is a generalization of A2
    public static int longest_subarray_with_sum_k(int[] input, int k){
        int maxlen = 0, cummulative = 0, n = input.length;
        HashMap<Integer, Integer> prefix_idx_map = new HashMap<>();
        for (int i = 0; i < n; i++){
            cummulative += input[i];
            if(cummulative == k){
                maxlen = Math.max(maxlen, i + 1);
            }
            if(prefix_idx_map.containsKey(cummulative - k)){
                maxlen = Math.max(maxlen, i - prefix_idx_map.get(cummulative - k));
            }
//            last time k was 0, so cummulative - k was same as cummulative so we had put an "else condition"
//            but here we need an "if"
            if(!prefix_idx_map.containsKey(cummulative)) {
//                first occurance
                prefix_idx_map.put(cummulative, i);
            }

        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] input = {3, 1, 1, 4, 0, 3};
        System.out.println(longest_subarray_with_sum_k(input, 3));
    }
}
