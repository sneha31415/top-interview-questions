//REF ARTICLE : https://codeforces.com/blog/entry/78762 

//  https://leetcode.com/problems/zero-array-transformation-i/description/
// similar  -> https://leetcode.com/problems/zero-array-transformation-ii/description/

public static boolean isZeroArray(int[] nums, int[][] queries) {
    int n = nums.length;
    int[] prefixSum = new int[n + 1];

    // create the difference array
    for (int[] query : queries) {
        int left = query[0], right = query[1];
        prefixSum[left]++;
        prefixSum[right + 1]--;
    }

    // make the prefix sum
    for (int i = 1; i < n + 1; i++) {
        prefixSum[i] += prefixSum[i - 1];
    }
    // check in there are enough queries to make nums[i] = 0
    for (int i = 0; i < n; i++) {
        if (prefixSum[i] < nums[i]) return false;
    }
    return true;
}