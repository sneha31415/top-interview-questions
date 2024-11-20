package C7_bit_manipulation;

import java.util.Scanner;

//given an array where every number except one num occurs twice, find the unique number.
// [1,2,2,1,5,6,6] >> 5
//intuition => a ^ b ^ a = b
public class A1_unique_number {
    public static int unique_num(int[] nums){
        int xor = 0;
        for (int num : nums){
            xor ^= num;
        }
        return xor;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //n must be odd
        int[] input = new int[n];
        for (int i = 0; i < n; i++){
            input[i] = sc.nextInt();
        }
        System.out.println(unique_num(input));
    }
}
