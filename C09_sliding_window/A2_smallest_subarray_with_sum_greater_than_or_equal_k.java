package C9_sliding_window;

// Find the Smallest Subarray length with Sum Greater Than or Equal to S
public class A2_smallest_subarray_with_sum_greater_than_or_equal_k {
    public static int sliding_window(int[] input, int k){
        int curr_sum = 0;
        int start = 0;
        int min_length = Integer.MAX_VALUE;
        int n = input.length;
        for (int end = 0; end < n; end++){
            curr_sum += input[end];
//            When currentSum is at least S, update minLength and contract the window by start++ to try to find a smaller valid window.
            while (curr_sum >= k){
//                updating length inside the loop in contrast to prev problem
                min_length = Math.min(min_length, end - start + 1);
                curr_sum -= input[start++];
            }
        }
        return min_length == Integer.MAX_VALUE ? 0 : min_length;
    }
    public static void main(String[] args) {
        int[] input = {1,2,3,4,5};
        int k = 5;
        System.out.println(sliding_window(input, k));
    }
}
