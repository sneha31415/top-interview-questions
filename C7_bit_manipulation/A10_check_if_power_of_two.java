package C7_bit_manipulation;

public class A10_check_if_power_of_two {
//    n can be positive , negative or zero


//    approach 1 : Bit manipulation
    public static boolean isPowerOfTwo(int n) {
        if(n == 0 || n == Integer.MIN_VALUE){
            return false;
        }
        return (n & (n-1)) == 0;
    }

//    approach 2 : iterative
    public static  boolean isPowerOfTwoIterative(int n) {
        int bits = 0;
        while (n>0){
            bits++;
            n = (n & (n - 1));
        }
        return bits == 1;
    }
    public static void main(String[] args) {
        int x = 0b100;
        System.out.println(x);
    }
}
