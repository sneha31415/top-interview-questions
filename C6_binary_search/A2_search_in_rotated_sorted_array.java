package C6_binary_search;

import java.util.Scanner;

public class A2_search_in_rotated_sorted_array {
    public static int rotated_sorted_search(int[] input, int target){
        int s = 0;
        int e = input.length - 1;
        while (s <= e){
            int mid = (s + e) / 2;
            if (input[mid] == target){
                return mid;
            }
//            case 1 mid lies in the left part
            else if (input[mid] >= input[s]){
//                (s to mid) is sorted. so if the below condition is satisfied then target is guaranteed to be in the range s to mid
//                2 cases => target element lies on left or right
//                BEWARE OF <= SIGN
                if (target < input[mid] && target >= input[s]){
                    e = mid - 1;
                }else{
                    s = mid + 1;
                }
            }
//            case 2 : mid lies in the right part
            else{ // (mid to e) is sorted
                if (target > input[mid] && target <= input[e]){
                    s = mid + 1;
                }else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++){
            input[i] = sc.nextInt();
        }
        System.out.println(rotated_sorted_search(input, target));
    }
}
