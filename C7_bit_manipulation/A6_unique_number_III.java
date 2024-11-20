package C7_bit_manipulation;

import java.util.Arrays;

public class A6_unique_number_III {
    public static int unique_num(int[] input){
//        maximum we can have 64 bits
        int[] result = new int[64];
        for (int num : input){
            int pos = result.length - 1;
            while (num > 0){
                result[pos] += num & 1;
                num >>= 1;
                pos --;
            }
        }
        System.out.println(Arrays.toString(result));
        int unique = 0;
//        extract the bits of unique number and convert from binary to decimal
        for (int j : result) {
            unique = (unique << 1) + j % 3;
        }
        return unique;
    }
    public static void main(String[] args) {
        int[] input = {1,1,1,2,3,2,2};
        System.out.println(unique_num(input));

    }
}
