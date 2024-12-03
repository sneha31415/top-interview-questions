package C1_arrays;

import java.util.Scanner;

public class A4_binary_search {
//    binary search iterative
    public static void binarySearchIterative(int[] array, int target){
        int si = 0;
        int ei = array.length - 1;
        while (si <= ei){
            int mid = ei + (si - ei) / 2;
            if( array[mid] < target ){
                si = mid + 1;
            }
            else if (array[mid] > target){
                ei = mid - 1;
            }
            else{
                System.out.println("target element found at index " + mid);
                break;
            }
        }
        if ( si > ei){
            System.out.println("target not found");
        }
    }

    public static void binarySearchRecursive(int[] arr, int target, int si, int ei){
        if ( si > ei){
            System.out.println("element not found");
            return;
        }
        int mid = ei + (si - ei) / 2;
        if(arr[mid] < target){
            binarySearchRecursive(arr, target, mid + 1, ei );
        }
        else if (arr[mid] > target){
            binarySearchRecursive(arr, target, si, mid - 1 );
        }
        else{
            System.out.println("target found at index" + mid);
            return; //breaks are to there in loops only, we need to return "void" for recursive funcs
        }

    }
    public static void main(String[] args) {
//        input should be sorted
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target element");
        int target = sc.nextInt();

        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }
        binarySearchIterative(arr, target);
        binarySearchRecursive(arr, target, 0, arr.length - 1);

    }
}
