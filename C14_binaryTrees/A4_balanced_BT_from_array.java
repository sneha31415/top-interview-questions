package C14_binaryTrees;

import static C14_binaryTrees.A1_build_BT.printTree;
import static C14_binaryTrees.A1_build_BT.printTreeBFS;

public class A4_balanced_BT_from_array {
    public static Node buildBalancedBT(int[] input, int s, int e){
        if(s > e){
            return null;
        }
//        we are maintaining leftht - rightht <= 1 by giving equal elems to both left subtree and rightsubtree
        int mid = (s + e) / 2;
        Node root = new Node(input[mid]);
        root.left = buildBalancedBT(input, s, mid - 1);
        root.right = buildBalancedBT(input, mid + 1, e);
        return root;
    }
    public static void main(String[] args) {
        int[] input = {0, 1, 2, 3, 4, 5};
        Node root = buildBalancedBT(input, 0, input.length - 1);
        printTreeBFS(root);

    }
}
