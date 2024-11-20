package C10_recursion_II_implementation_based;

import java.util.Arrays;

public class A4_merge_sort {
    private static void merge(int[] input, int s, int e){
        int mid = (s + e) / 2;
        int i = s, j = mid + 1, k = s;
        int[] temp = new int[e - s + 1];
        while (i <= mid && j < e){
            if (input[i] <= input[j]){
                temp[k++] = input[i++];
            }else {
                temp[k++] = input[j++];
            }
        }
        while (i <= mid){
            temp[k++] = input[i++];
        }
        while (j <= e){
            temp[k++] = input[j++];
        }
//        put the elems from temp back to input
        for (int idx = 0; idx < temp.length; i++){
            input[idx + s] = temp[idx];
        }
    }
    public static void merge_sort(int[] input, int s, int e){
//        one or zero element array is always sorted
        if (s >= e){
            return;
        }
        int mid = (s + e) / 2;
//        first divide
        merge_sort(input, s, mid);
        merge_sort(input, mid + 1, e);
//        merge two sorted arrays
        merge(input, s, e);
    }
    public static void main(String[] args) {
        int[] array = {-1, 0, 10, 5, 8, 3, -6, 0};
        merge_sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }
}
