package C11_more_sorting_techniques;

import java.util.Arrays;

public class A1_merge_sort {
    public static void mergeSort(int[] input, int s, int e){
        if(s >= e){
            return;
        }
        int mid = (s + e) / 2;
        mergeSort(input, s, mid);
        mergeSort(input, mid + 1, e);
        merge(input, s, e);
    }
    private static void merge(int[] input, int s, int e){
        int mid = (s + e) / 2;
        int i = s;
        int j = mid + 1;
        int k = s;

        int[] storage = new int[100];
        while (i <= mid && j <= e){
            if(input[i] <= input[j]){
                storage[k++] = input[i++];
            }else{
                storage[k++] = input[j++];
            }
        }

        while (i <= mid){
            storage[k++] = input[i++];
        }
        while(j <= e){
            storage[k++] = input[j++];
        }

        for (int idx = s; idx  <= e; idx++){
            input[idx] = storage[idx];
        }
    }

    public static void main(String[] args) {
        int[] input = {3, -1, 1, 0, 3, 2,6, 9, 0};
        mergeSort(input, 0, input.length - 1);
        System.out.println(Arrays.toString(input));
    }
}
