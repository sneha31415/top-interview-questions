package C10_recursion_IV_subset_based;
import java.util.*;
// given a number n, generate valid paranthesis with N pairs of brackets
// in the last problem basically we had two options ie include the character or not
// here we have two options i,e put '(' bkt or ')'

public class A2_generate_paranthesis {
    public static void generate_paranthesis(int n, int i, char[] out, int open, int close){
        if(i == 2 * n){
            System.out.println(out);
            return;
        }
        if (open < n) {
            out[i] = '(';   // i is diff for each call. so eventually we overwrite to generate ()() from (())
            generate_paranthesis(n, i + 1, out, open + 1, close);
        }
        if (close < open) {
            out[i] = ')';
            generate_paranthesis(n, i + 1, out, open, close + 1);
        }
    }
    public static void generate_paranthesis2(int n, ArrayList<Character> out, int open, int close){
        if(out.size() == 2 * n){
            System.out.println(out);
            return;
        }
        if(open < n) {
            out.add('(');
            generate_paranthesis2(n, out, open + 1, close);
            out.remove(out.size() - 1); //backtrack
        }
        if(close < open) {
            out.add(')');
            generate_paranthesis2(n, out, open, close + 1);
            out.remove(out.size() - 1); //backtrack
        }
    }

    public static void main(String[] args) {
        generate_paranthesis2(3,  new ArrayList<>(), 0, 0);

    }
}
