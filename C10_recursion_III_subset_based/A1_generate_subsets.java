package C10_recursion_IV_subset_based;

import java.util.Arrays;
//Important for many problems
// given a string s, generate all its subsequences

public class A1_generate_subsets {
//    WAY 1: first include the first char and then dont include
    public static void generate_subsets(String s, char[] out, int i, int j){
        if(i == s.length()){
            System.out.println(Arrays.toString(out));
            return;
        }
//        two options
//        include the first char
        out[j] = s.charAt(i);
        generate_subsets(s, out, i + 1, j + 1);

//        dont include the first char
//        backtrack
        out[j] = '\0';
        generate_subsets(s, out, i + 1, j);
    }

//    WAY 2 : first dont include then include
    public static void generate_subsets2(String s, char[] out, int i, int j){
        if(i == s.length()){
            System.out.println(Arrays.toString(out));
            return;
        }
//        two options:
//        dont include the first char
        generate_subsets2(s, out, i + 1, j);

//        include the first char
        out[j] = s.charAt(i);
        generate_subsets2(s, out, i + 1, j + 1);
//        backtrack
        out[j] = '\0';
    }
    public static void main(String[] args) {
//        "out" array is used to store the subsequences on the way. Its like an helper storage
//        i is the pointer to point over 's' and j is to point over "out"
        generate_subsets2("abc", new char[4], 0, 0);
    }
}
