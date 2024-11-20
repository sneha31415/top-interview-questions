package C13_stacks;

import java.util.Stack;

public class A2_valid_paranthesis {
    public static boolean valid_paranthesis(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push('(');
            }
            else if(ch == ')'){
                if(stack.size() == 0){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String bkt = "))(";
        System.out.println(valid_paranthesis(bkt));
    }
}
