package C14_binaryTrees;

import java.util.Scanner;

import static C14_binaryTrees.A1_build_BT.buildTree;
import static C14_binaryTrees.A1_build_BT.printTreeBFS;
import static C14_binaryTrees.A8_least_common_ancestor.least_common_ancestor;

//given a binary tree, and two nodes a, b .. find the dist between the a and b
public class A9_distance_between_two_nodes {
    public static int find_distance(Node root, int a, int b){
        Node lca = least_common_ancestor(root, a, b);
//      after lca, one node will be present in left and one in right
        int a_level = getLevel(lca, a, 0);
        int b_level = getLevel(lca, b, 0);
//        sum of levels from left and right
        return a_level + b_level;
    }

    private static int getLevel(Node root, int target, int level){
        if(root == null){
            return -1;
        }
//        each recursive call has its own copy of level, so when we find the target, that level is our level
        if(root.data == target){
            return level;
        }
        int leftlevel = getLevel(root.left, target, level + 1);
//        element found in left
        if(leftlevel != -1){
            return leftlevel;
        }
        return getLevel(root.right, target, level + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc); //1 2 4 6 -1 -1 7 10 -1 -1 11 -1 -1 5 8 -1 -1 9 -1 -1 3 -1 -1
        printTreeBFS(root);
        System.out.println(find_distance(root, 6, 4));
    }
}
