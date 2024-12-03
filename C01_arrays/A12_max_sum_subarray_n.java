package C1_arrays;

import java.util.Scanner;

public class A12_max_sum_subarray_n {
    public static void main(String[] args) {
//        TAKING ARRAY INPUT
        int[] array = new int[100];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

//        KADANE'S ALGO
//        maintain curr max sum and curr sum
        int cs = 0;
        int ms = array[0]; //dont initialise with 0 as the ms can be -ve if whole array is negative nos.
        for (int i = 0; i < n; i++){
            cs += array[i];
            ms = Math.max(cs, ms);

//        if cs < 0, then adding the cs would be a loss as adding negatives will reduce the sum
            if (cs < 0){
                cs = 0;
            }
        }
        System.out.println(ms);
    }
}
