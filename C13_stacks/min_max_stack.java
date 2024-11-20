package C13_stacks;

import java.util.ArrayList;

public class min_max_stack {
    private final ArrayList<Integer> stack;
    private final ArrayList<Integer> min_stack;
    private final ArrayList<Integer> max_stack;

    public min_max_stack(){
        stack = new ArrayList<>();
        min_stack = new ArrayList<>();
        max_stack = new ArrayList<>();
    }
    public void push(int data){
        int currmax = data;
        int currmin = data;

        if(!stack.isEmpty()){
            currmax = Math.max(currmax, max_stack.get(max_stack.size() - 1));
            currmin = Math.min(currmin, min_stack.get(max_stack.size() - 1));
        }
//        if stack is empty, simply data will be added :)
        max_stack.add(currmax);
        min_stack.add(currmin);
        stack.add(data);
    }
    public int pop(){
        max_stack.remove(max_stack.size() - 1);
        min_stack.remove(min_stack.size() - 1);
        return stack.remove(stack.size() - 1);
    }
    public int top(){
        return stack.get(stack.size() - 1);
    }
    public int getMin(){
        return min_stack.get(min_stack.size() - 1);
    }
    public int getMax(){
        return max_stack.get(max_stack.size() - 1);
    }

    public static void main(String[] args) {
        min_max_stack s = new min_max_stack();
        s.push(1);
        s.push(2);
        s.push(5);
        s.push(3);
        System.out.println(s.getMax());
        System.out.println(s.getMin());
        s.pop();
        s.pop();
        System.out.println(s.getMax());
        System.out.println(s.getMin());
    }
}
