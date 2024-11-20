package C14_binaryTrees;

import static C14_binaryTrees.A1_build_BT.printTreeBFS;

public class A5_BT_from_inorderAndPreorder {

    static int pointer = 0; // global pointer for iterating over the preorder array
//    basically, as per the preorder[pointer], find that root node in inorder and make function calls to get its left and right subtree
//    now do the same for the  next root. For next root do pointer++
    public static Node BT_from_inorderAndPreorder(int[] preorder, int[] inorder, int s, int e){
        if(s > e){
            return null;
        }
        Node root = new Node(preorder[pointer]);
//        find the location of root in inorder[]
        int i = 0;
//        use a map for O(1) look up
        while(inorder[i] != preorder[pointer]){
            i++;
        }
//        point to next head
        pointer++;
        root.left = BT_from_inorderAndPreorder(preorder, inorder, s , i - 1);
        root.right = BT_from_inorderAndPreorder(preorder, inorder, i + 1, e);
        return root;
    }
    public static void main(String[] args) {
        int [] preorder = {1, 2, 3,4, 8, 5, 6, 7};
        int[] inorder = {3, 2, 8, 4, 1, 6, 7, 5};
        Node root = BT_from_inorderAndPreorder(preorder, inorder, 0, preorder.length - 1);
        printTreeBFS(root);
    }
}
