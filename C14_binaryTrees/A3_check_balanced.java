package C14_binaryTrees;

import java.util.Arrays;
import java.util.Comparator;

public class A3_check_balanced {

    public class Pair{
        int height;
        boolean isBalanced;
        public Pair(){}
        public Pair(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
//    tc = O(N)
    public boolean isBalancedoptimised(Node root){
        return helper(root).isBalanced;
    }
    private Pair helper(Node root){
//        null tree is balanced
        if(root == null){
            return new Pair(0, true);
        }
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isbalanced = Math.abs(left.height - right.height) <= 1;
//        for root to be balanced, both left and right subtree must be balanced "AND" leftsubtree and right subtree height diff must not exceed 1
        return new Pair(height, isbalanced && left.isBalanced && right.isBalanced);

    }
    public static void main(String[] args) {

    }
}
