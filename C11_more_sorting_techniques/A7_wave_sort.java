package C11_more_sorting_techniques;

// sort the array in wave form
// i.e bigger smaller bigger smaller ...
// note : there can be multiple answers

import java.util.Arrays;

//approach 1 : sort the graph and swap alternate elements
public class A7_wave_sort {
    public static void wave_sort(int[] input){
        int n = input.length;
//        intuition : just make sure that elems at index 2*k are greater than their surronding elems
//        so we did i += 2 jump
        for (int i = 0; i < n; i+= 2){
//            compare with prev elem if it exists
                if(i - 1 > 0 && input[i] < input[i - 1]){
                    swap(input, i, i - 1);
                }
//             compare with next elem if it exists
                if(i + 1 < n && input[i] < input[i + 1]) {
                    swap(input, i, i + 1);
                }
        }
    }
    private static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        int [] input = {2, 1, 1, 0, 5, -1, 8};
        wave_sort(input);
        System.out.println(Arrays.toString(input));
    }
}
