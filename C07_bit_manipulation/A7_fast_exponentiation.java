package C7_bit_manipulation;

public class A7_fast_exponentiation {
//    tc = logn cuz no. of bits = logn
    public static int fast_exponentiation(int n, int p){
        int running_powers = n;
        int result = 1;
        while (p > 0){
            int last_bit = p & 1;
            if (last_bit == 1){
                result *= running_powers;
            }
            System.out.println(result + " " + running_powers);
            running_powers *= running_powers;
            p >>= 1;

        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(fast_exponentiation(3,5));
    }
}
