package C7_bit_manipulation;

public class A4_count_set_bits {
//    given a number, count the number of 1s(set bits) in the binary rep of the number
//    1st way. TC = log n . as for a number "n", the number of bits will be logn + 1
    public static int count_bits(int n){
        int count = 0;
        while (n > 0){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

//    2nd way. TC= o(number of set bits). in the worst case, all the bits can be set so worst case tc is O(logn)
    public static int count_bits2(int n){
        int count = 0;
        while (n > 0){
            n = n & (n - 1);
            count += 1;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(count_bits(13));
        System.out.println(count_bits2(13));

    }
}
