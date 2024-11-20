package C11_more_sorting_techniques;

import java.util.Arrays;

public class A10_cyclic_sort {
//    ITSSS WRONG
//    public static void cyclicSort(int[] input) {
//        int n = input.length, i = 0;
//        while (i < n) {
//            while (input[i] != i + 1){
//                swap(input, i, input[i] - 1);
//            }
//            i++;
//        }
//    }

    public static void cyclicSort(int[] input) {
        int n = input.length, i = 0;
        while (i < n) {
            int correctIndex = input[i] - 1;
            // at 0th index we need a 1
            if (input[i] != input[correctIndex]){
                swap(input, i, correctIndex);
            }
            else {
                i++;
            }
        }
    }

    private static void swap(int[] input, int index1, int index2) {
        int temp = input[index1];
        input[index1] = input[index2];
        input[index2] = temp;
    }
    public static void main(String[] args) {
        int[] input = {4,3,2,7,8,2,3,1};
        cyclicSort(input);
        System.out.println(Arrays.toString(input));

//        7,3,2,3,8,2,3,1
//        3,3,2,3,8,2,3,1

    }
}
