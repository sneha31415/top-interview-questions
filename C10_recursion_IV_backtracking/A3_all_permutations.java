package C10_recursion_V_backtracking;

import java.util.HashSet;
import java.util.Set;

public class A3_all_permutations {
    private static void swap(char[] input, int i, int j){
        char toSwap = input[i];
        input[i] = input[j];
        input[j] = toSwap;
    }
    //  i denotes curr char where we are working and j chooses the first element from i to (n - 1)
    public static void print_all_permutations(char[] input, int i, Set<String> st){
//        when you hit the base, you have got a permutation
        if(i == input.length){
//            System.out.println(input);
//            to add only unique permutations in case when input = "aba" types
            st.add(String.valueOf(input));
            return;
        }
        for(int j = i; j < input.length; j++){
            swap(input, i, j);
//            permute rest part recursively
            print_all_permutations(input, i + 1, st);
//            backtrack
//            restore the original array
            swap(input, i, j);
        }
    }

    public static void main(String[] args) {
        Set<String> st = new HashSet<>();
        print_all_permutations("aba".toCharArray(), 0, st);
        System.out.println(st);
        Set<String> st2 = new HashSet<>();

        print_all_permutations("abc".toCharArray(), 0, st2);
        System.out.println(st2);
    }
}
