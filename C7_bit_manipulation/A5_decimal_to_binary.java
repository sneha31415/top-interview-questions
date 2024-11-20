package C7_bit_manipulation;

public class A5_decimal_to_binary {
//    in the computer memory, 8 is stored as 1000
    public static int decimal_to_binary(int n){
        int power = 1;
        int binary = 0;
        while (n > 0){
            int last_bit = n & 1;
            binary +=  power * last_bit;
            power *= 10;
            n >>= 1; // divide number by 2
        }
        return binary;
    }

    public static void main(String[] args) {
        System.out.println(decimal_to_binary(18));
    }
}
