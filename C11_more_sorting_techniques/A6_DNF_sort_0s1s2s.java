package C11_more_sorting_techniques;

import java.util.Arrays;
import java.util.Objects;

public class A6_DNF_sort_0s1s2s {
//    we can sort an array containing 0, 1 ,2 using counting sort but  that takes O(2N) time and O(range) space (here range = 0 to 3)
//    using dnf same can be done in  O(n) time and O(1) space
    public static void dnf_sort(int[] input){
//        all elements before i are 0's
        int i = 0;
//        all elements after j are 2's
        int j = input.length - 1;
//        k to iterate over the array
//        k is iterating such that all elements before k are either 0 or 1
        int k = 0;
        while (k <= j){
            if(input[k] == 0){
                swap(input, i++,k++);
            }else if(input[k] == 1){
                k++;
            }else{
                swap(input, j--, k);
            }
        }
        return;
    }
    private static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int input[] = {2, 1, 1, 1, 1,0, 0,0, 2, 0,1};
        dnf_sort(input);
        System.out.println(Arrays.toString(input));
    }
}
