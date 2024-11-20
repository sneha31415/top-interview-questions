package C11_more_sorting_techniques;

import java.util.Arrays;

public class A3_quick_sort {
    public static void quick_sort(int[] input, int s, int e){
        if(s >= e){
            return;
        }
        int pivot = get_pivot(input, s, e);
        quick_sort(input, s, pivot -1 );
        quick_sort(input, pivot + 1, e);
        return;
    }

    private static int get_pivot(int[] input, int s, int e){
        int pivot_elem = input[e];
        int j = s-1;
        for(int i = s; i <= e- 1; i++){
            if(input[i] <= pivot_elem ){
                swap(input, ++j, i);
            }
        }
        swap(input, ++j, e);
        return (j);
    }
    private static void swap(int[] input, int i, int j){
        int temperary = input[i];
        input[i] = input[j];
        input[j] = temperary;
    }
    public static void main(String[] args) {
        int[] input = {3, -1, 1, 0, 3, 2,6, 9, 0};
        quick_sort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
