package C14_binaryTrees;

import java.util.Scanner;

import static C14_binaryTrees.A1_build_BT.buildTree;
import static C14_binaryTrees.A1_build_BT.printTree;

// Q : replace each node with the sum of all their descendents. Dont change the leaf nodes
public class A2_sum_replacement {

    public static int sum_replacement(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.data;
        }
        int left = sum_replacement(root.left);
        int right = sum_replacement(root.right);

        int headval = root.data; // save the root node data
        root.data = left + right; //update root node data with its children sum
        return  left + right + headval;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc); // 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 -1
        printTree(root);
        sum_replacement(root);
        printTree(root);

    }
}
