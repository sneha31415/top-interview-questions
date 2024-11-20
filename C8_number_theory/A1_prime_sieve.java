package C8_number_theory;

import java.util.Scanner;

public class A1_prime_sieve {

//    brute force: check from [2 to (n - 1)]
//    better approach : check from [2 to root (n)]
//    optimised = prime sieve
    public static boolean isprime(int n){
        if (n == 1){
            return false;
        }
        if (n == 2){
            return true;
        }
        for (int i = 2; i * i < n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

// task is to generate all the primes in the range n
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
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
        int n = 100;
        int primes[] = new int[n + 1 ];
        prime_seive(primes);
        int count = 0;
        for (int i = 0; i <= n; i++){
            if (primes[i] == 1){
                System.out.print(i + " ");
                }
            }
        System.out.println();

//        made a prefix sum array to store the number of primes upto index i for i in range (n)
        int[] prefix_sum =  new int[n + 1];
//        TC = O(n)
        for (int i = 1; i <= n; i++){
            prefix_sum[i] = prefix_sum[i - 1] + primes[i];
        }
//        question: number of primes between 11 to 20 (both inclusive)
        System.out.println(prefix_sum[20] - prefix_sum[10]);
// so for q queries, tc for calulation of prefix sum is O(q) given that prefix sum is computed
        }
    }

