package C9_sliding_window;
//note :For Positive only Numbers array: The sliding window approach works because of the predictable behavior of the sum — it only increases when expanding the window and decreases when contracting it.
//For Negative Numbers: The sliding window doesn't work well because the sum can fluctuate unpredictably, which is why you need a different approach like the HashMap-based solution in that case.
public class A3_longest_subarray_with_sum_k {
    public static int lenOfLongSubarr(int A[], int N, int k) {
        int max_length = 0;
        int left = 0;
        int curr_sum = 0;
        for (int right = 0; right < N; right++){
            curr_sum += A[right];

            while (left <= right && curr_sum > k){
                curr_sum -= A[left++];
            }
            if (curr_sum == k){
                max_length = Math.max(max_length, right - left + 1);
            }
        }
        return max_length;
    }


//    this will fail on : {-3, -2, 3} target = 3
    public static void main(String[] args) {

    }
}
