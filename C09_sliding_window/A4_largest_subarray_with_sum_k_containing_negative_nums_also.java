package C9_sliding_window;
import java.util.*;
// The below code will also work fpr arrays containing negative nums unlike A3
public class A4_largest_subarray_with_sum_k_containing_negative_nums_also {
    public static int lenOfLongSubarr(int arr[], int N, int k) {
        HashMap<Integer, Integer> cummSumMap = new HashMap<>();
//        if the cumm is k, we need not subtract
        cummSumMap.put(0, -1);

        int cummSum = 0;
        int lenOfLongestSubarr = 0;

        for (int i = 0; i < N; i++) {
            cummSum += arr[i];
            int subtract = cummSum - k;
            if (cummSumMap.containsKey(subtract)) {
                lenOfLongestSubarr = Math.max(lenOfLongestSubarr, i - cummSumMap.get(subtract));
            }

            // keeping smaller values of indices will maximise length. so have a check if cummSUm value exist
            if (!cummSumMap.containsKey(cummSum)) {
                cummSumMap.put(cummSum, i);
            }
        }
        return lenOfLongestSubarr;
    }
    /*
    intuition:
     cummSum - subtract = target
     subtract = (cummSum - target) -> we will search this in hashmap

     and if we get it, we update our minValue.
     */
//    target = 0 {-1, 1, -1, 3}
    public static void main(String[] args) {

    }
}
