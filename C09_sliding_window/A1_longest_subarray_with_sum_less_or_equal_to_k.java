package C9_sliding_window;
// Find the Longest Subarray length with Sum Less Than or Equal to K
public class A1_longest_subarray_with_sum_less_or_equal_to_k {
    public static int sliding_window(int[] input, int k){
        int max_length = 0;
        int start = 0;
        int n = input.length;
        int curr_sum = 0;
        for (int end = 0; end < n; end++){
            curr_sum += input[end];
//            contract the window untill the sum is not less than k
            while (curr_sum > k){
                curr_sum -= input[start++];
            }
//            now that you have reached an optimum value of curr_sum, note down the length
            max_length = Math.max(max_length, end - start + 1);
        }
        return max_length;
    }

    public static void main(String[] args) {
        int[] input = {4,1,3,1, 4, 5};
        System.out.println(sliding_window(input, 6));
    }
}
