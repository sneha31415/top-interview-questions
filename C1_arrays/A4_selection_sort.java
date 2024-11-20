package C1_arrays;

public class A4_selection_sort {
    public static void selection_sort(int arr[]){
//        compare only till the 2nd last elem
        for( int i = 0; i < arr.length - 1; i++) {
//            loop to find the smallest element index in the unsorted part
            int min_index = i;
            for (int j = i; j <= arr.length - 1; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
//            swap
            int temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }
    public static void main(String[] args) {
        int [] arr = new int[] {1,5,3,6};
        selection_sort(arr);
        for(int elem: arr){
            System.out.print(elem + " ");
        }
    }
}
