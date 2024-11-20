package C10_recursion_III;

public class A7_binary_strings {
//    count the number of valid binary strings of length n that have no consecutive 1's
//     intuition : the string can end with either 1 or 0. So think how the end and rest part of string must combine to give a valid string of length n
    public static int num_strings(int n){
        if (n < 0){
            return 0;
        }
        if(n == 0 || n == 1){
            return n + 1;
        }
//       if the string ends with 0, then n length string is valid if (n - 1) len string is valid
//       if the string ends with 1, then n length string is valid if (n - 2) len string is valid and has '0' in the 2nd last position
        return num_strings(n - 1) + num_strings(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(num_strings(4));
    }
}
