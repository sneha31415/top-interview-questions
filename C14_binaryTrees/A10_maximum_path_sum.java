package C14_binaryTrees;

// leetcode solution
public class A10_maximum_path_sum {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    class Pair{
        int maxSumSoFar;
        int maxSumWithRoot;

        public Pair(int maxSumSoFar, int maxSumWithRoot) {
            this.maxSumSoFar = maxSumSoFar;
            this.maxSumWithRoot= maxSumWithRoot;
        }
    }
    public int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).maxSumSoFar;
    }
    private Pair maxPathSumHelper(TreeNode root) {
        if (root == null) {
            int small = -(int)(1e5);
            return new Pair(small, small);
        }

        Pair left = maxPathSumHelper(root.left);
        Pair right = maxPathSumHelper(root.right);

        int leftBranch = left.maxSumWithRoot;
        int rightBranch = right.maxSumWithRoot;
        // you cant consider both left and right subtree with root and send it to the parent
        // you can consider atmost 1
        int maxSumWithRoot = Math.max(root.val, Math.max(root.val + leftBranch, root.val + rightBranch));

        int maxSumSoFar = Math.max(Math.max(maxSumWithRoot, root.val + leftBranch + rightBranch),
                Math.max(left.maxSumSoFar, right.maxSumSoFar));

        return new Pair(maxSumSoFar, maxSumWithRoot);

    }
}
