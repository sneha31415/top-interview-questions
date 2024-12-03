package C1_arrays;

public class A6_insertion_sort {
    public static void insertion_sort(int[] arr){
//        the first elem is always sorted
        for (int i = 1; i < arr.length; i++){
//            first element in the unsorted part
            int curr_insert = arr[i];
//            now place this in the correct position in the sorted part of the array
//            j starts from the first position of the sorted array looking for the correct index for "curr_insert"
            int j = i - 1;
            while (j >= 0 && arr[j] > curr_insert){
//                shift the cards forward untill you get the correct position
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr_insert;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,6,3,3,2,6,0};
        insertion_sort(arr);
        for(int elem: arr){
            System.out.print(elem + " ");
        }
    }
}
