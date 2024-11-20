package C13_stacks;

import java.util.LinkedList;

public class    stack <T>{
    private LinkedList<T> s;
    public stack(){
        s = new LinkedList<>();
    }
    public void push(T data){
//        we will add at the head of the LL to decrease the retrival time from O(n) to O(1)
        s.addFirst(data);
    }
    public T peek(){
        return s.peekFirst();
    }
    public T pop(){
        return s.pollFirst();
    }
    public  boolean isEmpty(){
        return s.size() == 0;
    }


    public static void main(String[] args) {
        stack<Character> s = new stack<>();
        for (int i = 0; i < 5;i++){
            s.push((char)('a' + i));
        }
        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
        System.out.println();
        stack<Integer> s1 = new stack<>();
        for (int i = 0; i < 5;i++){
            s1.push(i);
        }
        while(!s1.isEmpty()){
            System.out.print(s1.pop() + " ");
        }

    }

}
