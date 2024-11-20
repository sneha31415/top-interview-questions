package C13_stacks;

import java.util.Scanner;
import java.util.Stack;

public class A1_reverse_stack {
    public static void reverse_stack(Stack<Integer> s){
        Stack<Integer> helper = new Stack<>();
        int n = s.size();
        for(int i = 0; i < n; i++){
//            pick the element at top of stack and store it
            int top = s.pop();
//            transfer the rest of elements(except the sorted ones) into helper
            while(s.size() > i){
                helper.push(s.pop());
            }
//            the top elem that we picked in the new bottom for the reversed stack
            s.push(top);
//            put back helper ele to s
            while(!helper.isEmpty()){
                s.push(helper.pop());
            }
        }
    }

    //        way 2
    public static void reverse2 (Stack<Integer> s){
        Stack<Integer> helper = new Stack<>();
        int n = s.size();
        for (int i = 0; i < n; i++) {
            int top = s.pop();
//            the i elems in helper are already in their correct place
            transfer(s, helper, n - i - 1);
//            top elem of s is now at the bottom(at its correct place)
            s.push(top);
            transfer(helper, s, n - i - 1);
        }
    }
    private static void transfer(Stack<Integer> s, Stack<Integer> helper, int num_elem){
        for(int i = 0; i < num_elem; i++){
            helper.push(s.pop());
        }
    }
    public static void reverse_recursive(Stack<Integer> s){
        if(s.size() == 0){
            return;
        }
        int top = s.pop();
        reverse_recursive(s);

//        insert top at the bottom
        Stack<Integer> helper = new Stack<>();
        while(!s.isEmpty()){
            helper.push(s.pop());
        }
        s.push(top);
        while(!helper.isEmpty()){
            s.push(helper.pop());
        }
    }

    public static void pure_recursive(Stack<Integer> s){
        if(s.size() == 0){
            return;
        }
//        extract the top and store it. Later we will put it at the bottom of the "small reversed stack"
        int top = s.pop();
//        reverse the rest of the stack(recursively)
        pure_recursive(s);
//        insert the top at the bottom of the reversed stack(recursively)
        insertAtBottom(s, top);
    }
    private static void insertAtBottom(Stack<Integer> s, int bottom){
        if(s.size() == 0){
            s.push(bottom);
            return;
        }
        int top = s.pop();
        insertAtBottom(s, bottom);
//        after base case is hit, we reach this line. So after adding bottom, we start adding all calls ka tops
        s.push(top);
    }
    public static void main(String[] args) {
        Stack<Integer> s= new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            s.push(i);
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        Stack<Integer> s1= new Stack<>();
        for (int i = 0; i < n; i++){
            s1.push(i);
        }
        pure_recursive(s1);
        System.out.println();
        while(!s1.isEmpty()){
            System.out.print(s1.pop() + " ");
        }
    }
}
