package C7_bit_manipulation;

// problem : return the number of numbers that are divisible by any of the prime number less than 20 in the range of (1, limit )

public class A9_inclusion_exclusion {
    private static int count_set_bits(int n){
        int count  = 0;
        while (n > 0){
            count ++;
            n = n & (n - 1);
        }
        return count;
    }

    public static int HardProblem(int limit){
//        bit masking
//       we will represent 2 -> 1, 3 -> 10, 5 -> 100, 7 -> 1000, 11 -> 10000 etc
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
        int n = primes.length;
        int result = 0;
        int num_subsets = (1 << n) - 1;//zero excluded
//       zero cannot be a subset(as zero cant be the dr)
//        iterate over all the possible combinations i.e (1 to (2^n) - 1)
        for (int i = 1; i < (1 << n); i++){
//            if num of set bits is odd, we add the result of that subset in our result else subtract
            int set_bits = count_set_bits(i);
            int denominator = 1;
//            iterate over all the bits of that number
            for (int j = 0; j < n; j++){
                if ((i&(1<<j)) != 0){
                    denominator *= primes[j];
                }
            }
            result = ((set_bits&1) == 1) ? result + limit/denominator : result - limit/denominator;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(HardProblem(12));
        System.out.println(HardProblem(150));
    }
}
