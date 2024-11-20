package C1_arrays;
import java.util.Scanner;
// given a sorted array, find two numbers such that they add to the target
// [1, 3, 4, 5,7, 8, 9] target = 11
//output = [4, 7]

//Brute force = O(n^2)
//approch 2 = O(nlogn) -> one for loop followed by binary search for the 2nd elem
// approach 3 = O(n) -> 2 pointer approach

public class A13_two_sum_sorted {
    public static void main(String[] args) {
//         TAKING ARRAY INPUT
        int[] array = new int[100];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

//        two Pointer approach
        int[] ans = new int[2];
        System.out.println("enter target");
        int target = sc.nextInt();
        int left = 0;
        int right = n - 1;
        // left <= right is wrong cz we need 2 distinct elems
        while (left < right){
            int curr_sum = array[left] + array[right];
            if(curr_sum == target){
                System.out.println(array[left] + " " +array[right]);
                break;
            }
            else if (curr_sum < target){
                left += 1;
            }
            else if (curr_sum > target){
                right -= 1;
            }
        }
        if(left >= right){
            System.out.println("no two elements found");
        }
    }

}
