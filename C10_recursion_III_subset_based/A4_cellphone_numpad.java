package C10_recursion_IV_subset_based;

public class A4_cellphone_numpad {
    static String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public static void combinations(char[] input, char[] out, int i, int j){
//        base case: reaching the end of input string "23" (say)
        if(i == input.length){
            System.out.println(out);
            return;
        }
        int digit = input[i] - '0';

//        skip 0 and 1
        if (digit == 1 || digit == 0){
            combinations(input, out, i + 1, j);
        }
//        for say 3 we have "def", so add them to out[], now ask recursion to do the same for rest part of input
        for (int k = 0; k < keypad[digit].length(); k++){
            out[i] = keypad[digit].charAt(k);
//            now find rest part recursively
            combinations(input, out, i + 1, j + 1);
        }
    }
    public static void main(String[] args) {
        combinations("666".toCharArray(), new char[4], 0, 0);
    }
}
