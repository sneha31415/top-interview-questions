package C13_stacks;
// design a stack class that supports the operations :
// push(), pop(), top(), getmax(), getmin()
import java.util.Stack;

public class A5_min_max_stack {
    static class min_max_stack{
        private Stack<Integer> s;
        private Stack<Integer> min;
        private Stack<Integer> max;
        public min_max_stack(){
            s = new Stack<>();
            min = new Stack<>();
            max = new Stack<>();
        }

//        noob code
        public void push(int elem){
            if(s.isEmpty()){
                s.push(elem);
                min.push(elem);
                max.push(elem);
            }else{
                if(max.peek() > elem){
                    max.push(elem);
                    min.push(min.peek());
                }else if(min.peek() < elem){
                    min.push(elem);
                    max.push(max.peek());
                }else{
                    min.push(min.peek());
                    max.push(max.peek());
                }
                s.push(elem);
            }
        }

        public int pop(){
            min.pop();
            max.pop();
            return s.pop();
        }
        public int top(){
            return s.peek();
        }
        public int getmax(){
            return max.peek();
        }
        public int getmin(){
            return min.peek();
        }
    }
    public static void main(String[] args) {
        min_max_stack s = new min_max_stack();
        s.push(1);
        s.push(2);
        s.push(5);
        s.push(3);
        System.out.println(s.getmax());
        System.out.println(s.getmin());
        s.pop();
        s.pop();
        System.out.println(s.getmax());
        System.out.println(s.getmin());
    }
}
