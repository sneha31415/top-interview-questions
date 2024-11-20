package C13_stacks;

//https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
public class min_max_stack_constant_space {
    public static void main(String[] args) {
        int n =6;
        int i = 0;
        int num  = n;
        while(num == n){
            n = (n | (1 << i));
            i++;
        }
    }
}
