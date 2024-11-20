package C10_recursion_II_implementation_based;
// worst case = O(n^2)
// average case = O(nlogn)
//inplace algorithm, extra space for recursion call stack


import java.util.Arrays;

public class A6_quick_sort {
    private static void swap(int[] input, int i, int j){
        int toSwap = input[i];
        input[i] = input[j];
        input[j] = toSwap;
    }
    private static int partition(int[] input, int s, int e){
        int pivot = e;
        int i = -1; // denotes the smaller than pivot part
//        i = e is the pivot so we skip it
        for (int j = s; j <= e - 1; j++){
            if (input[j] <= input[pivot]){
//                bring elems smaller than pivot to the left of pivot
                swap(input, ++i, j);
            }
        }
//        place the pivot at its correct position
        swap(input, ++i, pivot);
        return i;
    }
    public static void quickSort(int[] input, int s, int e){
        if (s >= e){
            return;
        }
//        this places the elems less than pivot to its left
          int pivot = partition(input, s, e);
//            sort the left part recursively
            quickSort(input, s, pivot - 1);
//            sort the left part recursively
            quickSort(input, pivot + 1, e);
        }

    public static void main(String[] args) {
        int[] input = {-1, 0, 2, 5, -3, 1, 10, 0, 1, 3};
        quickSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
