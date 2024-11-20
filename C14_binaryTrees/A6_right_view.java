package C14_binaryTrees;

import java.util.Scanner;

import static C14_binaryTrees.A1_build_BT.*;

public class A6_right_view {

//    this represents the global max in the tree so far
    static int max_level = -1; // to avoid copies of max_level across different calls, we make this variable as global
    public static void right_view(Node root, int level){
        if(root == null){
            return;
        }
        if(level > max_level){
            System.out.print(root.data + " ");
            max_level = level;
        }
//        increase the local level when u go left and right
//        go in the right hand side first
        right_view(root.right, level + 1);
        right_view(root.left, level + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc); // 1 2 4 -1 -1 5 -1 -1 3 6 -1 -1 -1
        printTreeBFS(root);
        System.out.println();
        right_view(root, 0);
    }
}
