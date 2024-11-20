package C2_character_arrays;

import java.util.Scanner;

public class A2_palindromic_string {
    public static boolean isPalindrome(String input){
        String reversed = "";
        for(int i = 0; i < input.length(); i++){
            reversed = input.charAt(i) + reversed;
        }
         return input.equals(reversed);

    }
//    2 pointer approach
    public static boolean isPalindrome2(String input){
        int n = input.length();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (input.charAt(l) != input.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string");
        String input = sc.next();

        System.out.println(isPalindrome(input));
        System.out.println(isPalindrome2(input));
    }
}
