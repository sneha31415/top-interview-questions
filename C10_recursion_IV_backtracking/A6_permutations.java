package C10_recursion_V_backtracking;
import java.util.*;

public class A6_permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        int n = nums.length;
        boolean[] visited = new boolean[n];

        permuteHelper(permutations, new ArrayList<>(), 0, nums, n, visited);
        return permutations;
    }

    private static void permuteHelper (List<List<Integer>> permutations, List<Integer> permutation, int currIdx, int[] nums, int n, boolean[] visited) {
        if (currIdx == n) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                permutation.add(nums[i]);
                visited[i] = true;
                permuteHelper (permutations, permutation, currIdx + 1, nums, n, visited);
                // backtrack
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
