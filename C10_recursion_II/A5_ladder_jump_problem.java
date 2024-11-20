package C10_recursion_III;

//given a ladder of n steps , a man is standing on the ground. he can climb 1, 2, 3 steps. Return the possible number of ways to climb the ladder
public class A5_ladder_jump_problem {
    public static int num_ways(int n){
        if (n == 1 || n == 2){
            return n;
        }
        if(n == 3){
            return 4;
        }
        return num_ways(n - 1) + num_ways(n - 2) + num_ways(n - 3);
    }

//   Type 2 :   there are k ways to jump
//    to be noted : base case toooo good
    public static int num_ways_k(int n, int k) {
//        if no one is going or only one is going the num ways are 1
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= k; i++){
            ans += num_ways_k(n - i, k);
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(num_ways(4));
        System.out.println(num_ways_k(4, 3));
    }
}
