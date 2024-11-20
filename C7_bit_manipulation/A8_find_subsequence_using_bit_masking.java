package C7_bit_manipulation;

import java.util.LinkedList;
import java.util.Queue;

public class A8_find_subsequence_using_bit_masking {
//    find all the subsequences using bit masking. Note that substrings are continuous but subsequences are not
//    input =  abc
//    o/p = "", a, b, c, ab, bc, ca, abc

//    for n = 3 => 011 we should return
    private static String filter(int n, String s){
        int len = s.length();
        String result = "";
        for (int i = 0; i < len; i++){
            int last_bit = n & 1;
//            if last bit obtained is 1 take the i th char else skip the ith char
            result = last_bit == 1? result + s.charAt(i) : result;
            n >>= 1;
        }
        return result;
    }
    public static void subsequences(String s){
        int n = s.length();
        int num  = 0;
//        loop runs from 0 to 7 if (n = 3)
        while(num < (1 << n)){
            System.out.print(filter(num, s) + " ");
            num++;
        }
    }
    public static void main(String[] args) {

        subsequences("abcc");
        
    }
}
