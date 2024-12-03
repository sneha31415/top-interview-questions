package C1_arrays;

public class A5_bubble_sort {
    public static void bubble_sort(int[] arr){
//        n-1 large elements are moved to the last through n-1 iteration
//        after n -1 iterations the last elem will be automatically sorted
//        i denotes iterations
        for(int i = 0; i < arr.length - 1; i++){
//            (arr.length - 1 - i) to (arr.length - 1) is already sorted
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static void main(String[] args) {
        int [] arr = { 1, 2, 3, 1, 9, 4, 6, 5};
        bubble_sort(arr);
        for(int elem : arr){
            System.out.print(elem + " ");
        }
    }
}
