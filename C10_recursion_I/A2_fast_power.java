package C10_recursion_II_implementation_based;

public class A2_fast_power {
//    tc = O(N)
    public static double power(int a, int n){
        if (n == 0){
            return 1;
        }
        if (n < 0){
            return power(a, n + 1) / a;
        }else{
            return power(a, n - 1) * a;
        }
    }

//   TC =  O(logn)
    public static double fast_power(double a, int n){
        if (n == 0){
            return 1;
        }
        double smaller_ans = fast_power(a, n / 2);
        smaller_ans *= smaller_ans;

        if ((n & 1) == 1){
            return a * smaller_ans;
        }
        return smaller_ans;
    }
    public static double general_fast_power(double a, int n){
        double myans = fast_power(a, n);
        if (n < 0){
            return 1 / myans;
        }
        return myans;
    }

    public static void main(String[] args) {
        System.out.println(power(3, -2));
        System.out.println(power(2,  2));
        System.out.println(fast_power(3, -3));
        System.out.println(general_fast_power(3, -2));
        int a = 3 << 2;
    }

}
