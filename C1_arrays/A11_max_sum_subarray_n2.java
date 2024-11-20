package C1_arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A11_max_sum_subarray_n2 {

//    O(n^2) with constant space
    public static int maxsum(List<Integer> array) {
        int max_sum = Integer.MIN_VALUE;
        for( int i = 0; i < array.size(); i++){
            int curr_sum = 0; //AND NOT -INFINITY
            for (int j = i; j < array.size(); j++){
                curr_sum += array.get(j);
                max_sum = Math.max(curr_sum, max_sum);
            }
        }
        return max_sum;
    }
    public static void main(String[] args) {
//        take the array input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++){
            array.add(sc.nextInt());
        }
//        generate the cumulative sum array
        int[] cs = new int[n+1];
        cs[0] = 0;
        for (int i = 1; i < n + 1; i++){
            cs[i] = cs[i - 1] + array.get(i - 1);
        }
// use the cs array to find each of the subarray sum
//   It is due to cs array that we just need to do cs[j] - cs[i - 1] to get subarray sum rather than summing from i  to j again and again. This is called as preprocessing
        int max_sum = Integer.MIN_VALUE;
        for (int i = 1; i < cs.length; i++){
            for (int j = i; j < cs.length; j++){
                int curr_subarray_sum = cs[j] - cs[i - 1];
                max_sum = Math.max(max_sum, curr_subarray_sum);
            }
        }
        System.out.println(max_sum);
    }
}
