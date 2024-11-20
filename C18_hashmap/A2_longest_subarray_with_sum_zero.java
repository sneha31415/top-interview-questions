package C18_problem_solving_using_hashmap;

import java.util.HashMap;

public class A2_longest_subarray_with_sum_zero {
    public static int longest_zero_sum_subarray(int[] input){
//        map of prefix sum with their indices
        HashMap<Integer, Integer> prefix_index_map = new HashMap<>();
        int maxlen = 0, cumulative = 0, n = input.length;
        for(int i = 0; i < n; i++){
            cumulative += input[i];
            if(cumulative == 0){ // also we dont  need to store index of zero, cuz ans is (i + 1) independent of previous prefix sums
                maxlen = Math.max(maxlen, i + 1);
            }
            else if(prefix_index_map.containsKey(cumulative)){
                maxlen = Math.max(maxlen, i - prefix_index_map.get(cumulative));
            }else{
              // we will only store the first occurance of every cumulative to maximise the length
                prefix_index_map.put(cumulative, i);
            }
        }
        return maxlen;
    }
    public static void main(String[] args) {
        int[] input = {0, -1, 1, 2, 5, -5};
        System.out.println(longest_zero_sum_subarray(input));
    }
}
