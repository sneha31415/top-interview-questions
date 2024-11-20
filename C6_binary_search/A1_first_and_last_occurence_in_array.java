package C6_binary_search;

import java.util.Scanner;

//get the first and last occurence of an element from an array
// desired Tc = o(logn)
// i/p = (1, 2, 3, 4, 5, 8, 8, 8, 8, 8, 9, 10) target = 8
// >> o/p = first_occ = 5, last_occ = 9
public class A1_first_and_last_occurence_in_array {
    public static int first_occurence(int[] input, int target){
        int first_occurance = -1;
        int n = input.length;
        int l = 0;
        int r = n - 1;
        while (l <= r){
            int mid = r - (r - l)/2;
            if (input[mid] == target){
                first_occurance = mid;
//                dont stop searching, explore ""LEFT""
                r = mid - 1;
            }
            else if (input[mid] > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return first_occurance;
    }

    public static int last_occurance(int[] input, int target){
        int last_occurance = -1;
        int n = input.length;
        int l = 0;
        int r = n - 1;
        while (l <= r){
            int mid = r - (r - l)/2;
            if (input[mid] == target){
                last_occurance = mid;
//                dont stop searching, explore ""RIGHT""
                l = mid+ 1;
            }
            else if (input[mid] > target){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return last_occurance;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++){
            input[i] = sc.nextInt();
        }
        System.out.println(first_occurence(input, target));
        System.out.println(last_occurance(input, target));
    }
}
