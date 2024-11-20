package C7_bit_manipulation;

// [1 2 2 1 3 4 6 6] o/p = [3 4]
public class A2_two_unique_num {
//    helper func to check if the i th bit is set to 1
    private static boolean check_set(int n , int i){
        return (n & (1 << i)) > 0 ;
    }
    public static int[] unique_nums(int[] nums){
        int xor = 0;
        for (int num : nums){
            xor ^= num;
        }
//        check the first bit that is 1
        int i = 0;
        int xor_copy = xor;
        while (xor_copy > 0){
            if ((xor_copy & 1) == 1){
                break;
            }
            xor_copy >>= 1;
            i++;
        }
//        check for the nums that have set bit at i
        int first_unique = 0;
        for (int num : nums){
            if (check_set(num, i)) {
                first_unique ^= num;
            }
        }
        int second_unique = first_unique ^ xor;
        return new int[]{first_unique, second_unique};
    }
    public static void main(String[] args) {
        int[] uniques = new int[2];
        uniques = unique_nums(new int[]{1,2,1,3,2,4, 3, 50});
        System.out.println(uniques[0]+ " " + uniques[1]);
    }
}
