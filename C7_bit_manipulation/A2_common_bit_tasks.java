package C7_bit_manipulation;

public class A2_common_bit_tasks {
    public static boolean isOdd(int n){
//    a number is odd if its binary rep has last bit as 1
//    if n & 1 == 1 then number is odd
        return (n & 1) == 1;
    }

//  get the i th bit from the right side from the binary represenation. indexing starts from 0 from right
    public static int getBit(int n, int i){
        int bit = (n & (1 << i)) > 0 ? 1 : 0; // 1 << i is the mask
        return bit;
    }
    public static int setBit(int n, int i){
//           create a mask and do "or" to preserve the other bits
        int mask = 1 << i;
        return (n | mask);
    }
//    for 00101 to clear i = 2th bit
//    00101
//  & 11011 >> 00001
    public static int clearBit(int n, int i){
        int mask = 1 << i;
        mask = ~(mask);
        return n & mask;
    }

//   given n, get the ith bit with the value v, v can be 0/1
    public static int updateBit(int n, int i , int v){
//        step1: clear the ith bit
        int cleared = clearBit(n, i);
        return cleared | (v << i);
    }

//    01110 1010, i = 3 . o/p = 01110 0000
    public static int clearRange(int n, int i){
//        -1 or (~0) is all 1's i.e 11111111.. now left shift by i places
        int mask = (-1 << i);
        return n & mask;
    }

    public static int clearRangeItoJ(int n, int i, int j){
        int ones = (~0);
        int a = ones << (j + 1);
        int b = (1 << i) - 1;
        int mask = (a | b);
        return n & mask;
    }
    public static void main(String[] args) {
        System.out.println(isOdd(2));
        System.out.println(getBit(5, 1)); //0101
        System.out.println(getBit(5, 0)); //0101
        System.out.println(setBit(5, 1));
        System.out.println(~8);
        System.out.println(clearBit(5, 3));
        System.out.println(updateBit(5, 1, 1)); //set the 1st bit from right to 1. 0101 > 0111
//        here i is the number of bits that are being cleared and not the position
        System.out.println(clearRange(5, 2));
        System.out.println(clearRangeItoJ(30, 1,  3));
    }
}
