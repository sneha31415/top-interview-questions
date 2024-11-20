package C11_more_sorting_techniques;

import java.util.Arrays;

//counting sort used when the range of elems is small
// complexity = O(N + range) which is approx O(N) for small ranges
// used when given array contains +ve numbers
public class A4_counting_sort {
    public static void counting_sort(int[] input){
//        find the largest elem
        int largest = -1;
        for (int i = 0; i < input.length; i++){
            largest = Math.max(largest, input[i]);
        }
        int[] freq = new int[largest + 1];
        for (int i = 0; i < input.length; i++){
            freq[input[i]]++;
        }
//        put it into input again
        int j = -1;
        for (int i = 0; i < largest + 1; i++){
            while(freq[i] > 0){
                input[++j] = i;
                freq[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int[] input = {1, 5, 3, 0,0, 2, 10, 5, 23 };
        counting_sort(input);
        System.out.println(Arrays.toString(input));
    }
}
