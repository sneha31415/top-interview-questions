package C16_tries;

import static C16_tries.A2_max_xor_of_two_elems.maxXor;

public class A3_max_xor_subset {
//    approach 1 : generate all subsets and take xor of each elem -> overall Tc = O(N^3)

//    approach 2 : avoid xor calculations for each subset. This is can be done using storing a cumulative xor array
//    Tc = O(N^2) to generate all subsets and O(1) for xor calculation

//    approach 3 : Trie
//    first make a cumulative xor array. Now run the two elements max xor on the cumulative xor array

    public static int max_xor_subset_brute(int[] input) {
        int n = input.length;
        int maxXorSubset = 0; // 0 ^ a = a
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int currXor = 0;
                for (int subsetIdx = start; subsetIdx <= end; subsetIdx++) {
                    currXor ^= input[subsetIdx];
                }
                maxXorSubset = Math.max(maxXorSubset, currXor);
            }
        }
        return maxXorSubset;
    }
    public static int max_xor_subset_better(int[] input) {
        int n = input.length;
        int[] cumulativeXor = new int[n + 1];
        for (int idx = 1; idx < n + 1; idx++) {
            cumulativeXor[idx] = cumulativeXor[idx - 1] ^ input[idx - 1];
        }

        int maxXorSubset = 0; // 0 ^ a = a
        for (int start = 0; start < n; start++) {
            for (int end = start; end < n; end++) {
                int currXor = cumulativeXor[end + 1] ^ cumulativeXor[start];
                maxXorSubset = Math.max(maxXorSubset, currXor);
            }
        }
        return maxXorSubset;
    }

    public static int max_xor_subset_best(int[] input) {
        int n = input.length;
        int[] cumulativeXor = new int[n + 1];
        for (int idx = 1; idx < n + 1; idx++) {
            cumulativeXor[idx] = cumulativeXor[idx - 1] ^ input[idx - 1];
        }
        return maxXor(cumulativeXor);
    }


    public static void main(String[] args) {
        int[] input = {1,2, 3, 4, 5, 6,7, 19};
        System.out.println(max_xor_subset_brute(input));
        System.out.println(max_xor_subset_better(input));
        System.out.println(max_xor_subset_best(input));
    }

}
