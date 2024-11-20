package C1_arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A10_max_sum_subarray_n3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++){
            array.add(sc.nextInt());
        }
//          BRUTE FORCE
//        generate all subarrays and find the maxx sum
        int max_sum = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        for( int i = 0; i < array.size(); i++){
            for (int j = i; j < array.size(); j++){
                int curr_sum = 0; //AND NOT -INFINITY
                for (int k = i; k <= j; k++){
                    curr_sum += array.get(k);
                }
                if (curr_sum > max_sum){
                    max_sum = curr_sum;
                    left = i;
                    right = j;
                }
                }
            }
        System.out.println(max_sum);
        for (int k = left; k <= right; k++){
            System.out.print(array.get(k) + ",");
        }
               }
    }

