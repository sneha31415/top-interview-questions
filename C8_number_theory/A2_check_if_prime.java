package C8_number_theory;

import java.util.ArrayList;
import java.util.List;

// problem statement: check if a given large number is prime or not ~ eg N = 10 ^12
// approach : if the number fits in the bitsieve array, then check the sieve, else iterate over 2 to root(N) and check if any prime divides N
public class A2_check_if_prime {
    static List<Integer> primes = new ArrayList<>();
    public static void prime_seive(int[] nums){
        int n = nums.length;
//        first mark all the odd numbers as prime
        for (int i = 3; i < n; i += 2){
            nums[i] = 1;
        }
//        sieve
        for (int i = 3; i < n; i += 2){
//            if the curr number is not marked (i.e it is prime)
            if (nums[i] == 1) {
                primes.add(i);
//                the mark all the multiples of this number as non prime
                for (int j = i * i; j < n; j += i) {
                    if (j % i == 0){
                        nums[j] = 0;
                    }
                }
            }
        }
//        spcl cases
        nums[2] = 1;
        nums[0] = nums[1] = 0;
    }
    public static void main(String[] args) {
        int n = Integer.MAX_VALUE / 50;
        int[] sieve =  new int[n];
        prime_seive(sieve);

        Long number = 2147483647L;

//        check if number fits in thw sieve size
//        if (number < primes.size()){
//            number = (int)number;
//            return primes.get(number) == 1;
//        }
        boolean isprime = true;
        for (int i = 3; primes.get(i) * primes.get(i) < number; i++){
            if(number % primes.get(i) == 0){
                System.out.println(number + " is not a prime");
                System.out.println(primes.get(i));
                isprime =  false;
                break;
            }
        }
        if(isprime) {
            System.out.println(number + " is a prime");
        }

    }
}
