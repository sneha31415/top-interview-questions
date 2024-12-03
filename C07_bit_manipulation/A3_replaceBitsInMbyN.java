package C7_bit_manipulation;

public class A3_replaceBitsInMbyN {
//    input N = 100 00000 00 , M = 10101, i = 2, j = 6
//    output = 1001010100
    private static int clearRangeItoJ(int n, int i, int j){
        int ones = (~0);
        int a = ones << (j + 1);
        int b = (1 << i) - 1;
        int mask = (a | b);
        return n & mask;
}
    public static int replaceBits(int n, int m, int j, int i){
//        clear the bits in the range i to j
        int n_ = clearRangeItoJ(n, j, i);
//        left shift 10101 by i times to get 1010100
        int m_= m << i;
        return n_ | m_;
    }
}
