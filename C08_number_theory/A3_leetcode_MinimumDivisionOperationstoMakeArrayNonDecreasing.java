package C8_number_theory;
import  java.util.*;
public class A3_leetcode_MinimumDivisionOperationstoMakeArrayNonDecreasing {
    class Solution {
        static int N = 1000010;
        static int[] sieve = new int[N];

        static {
            build();
        }

        static void build(){
            Arrays.fill(sieve, -1);
            sieve[1] = 1;
            for (int i = 2; i < N; i++) {
                if(sieve[i] == -1){
                    sieve[i] = i;
                    for (int j = 2*i; j < N; j += i) {
                        if(sieve[j] == -1) sieve[j] = i;
                    }
                }
            }
        }

        public int minOperations(int[] nums) {
            int n = nums.length;
            int res = 0;

            for (int i = n-2; i >=0 ; i--) {
                if(nums[i] > nums[i+1] && sieve[nums[i]] != nums[i]){
                    nums[i] = sieve[nums[i]];
                    res++;
                }
            }

            for (int i = 1; i < n; i++) {
                if(nums[i-1] > nums[i]) return -1;
            }

            return res;
        }
    }
}
