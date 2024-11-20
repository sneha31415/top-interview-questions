package C10_recursion_II_implementation_based;

import java.util.Arrays;

public class A3_bubble_sort {
    private static void swap(int[] input, int i , int j){
        int temp  = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static void bubble_sort(int[] input, int n){
        if (n == 0 || n == 1){
            return;
        }
//        after one iteration the largest elem goes to the last
        for (int i = 0; i < n - 1; i++){
            if (input[i] > input[i + 1]){
                swap(input, i, i + 1);
            }
//            the outer loop of bubble sort is converted into recursion
//            now only 0 .. n-2 is the unsorted part. i,e array of size n - 1 is unsorted
            bubble_sort(input, n - 1);
        }
    }
    public static void bubble_sort_pure_recursive(int[] array, int i, int n){
//      base case for outer loop
//        this base case should be first
        if (n == 0 || n == 1){
            return;
        }
//        base case for inner loop
        if (i == n - 1){
            return;
        }

//        inner loop. i maintains at that index we are currently working at
//        first swapping done by us rest done by recursion
        if (array[i] > array[i + 1]){
            swap(array, i, i + 1);
        }
        bubble_sort_pure_recursive(array, i + 1, n);
//        outer loop
        bubble_sort_pure_recursive(array, i , n - 1);
    }
//    ------OR --------
    public static void bubble_sort_pure_recursive2(int[] array, int i, int n){
        if (n == 0 || n == 1){
            return;
        }
        if ( i == n - 1){
//            single pass of the current array has been done
            bubble_sort_pure_recursive2(array, 0, n - 1);
        }
        if (array[i] > array[i + 1]){
            swap(array, i, i + 1);
        }
//        for single pass of the array
        bubble_sort_pure_recursive2(array, i + 1, n);

    }
    public static void main(String[] args) {
        int[] input = {-1, 0, 10, 5, 8, 3, -6, 0};
        bubble_sort(input, input.length);
        System.out.println(Arrays.toString(input));
        int[] array = {-1, 0, 10, 5, 8, 3, -6, 0};
        bubble_sort_pure_recursive(array, 0, array.length);
        System.out.println(Arrays.toString(array));
    }
}
