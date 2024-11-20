package C14_binaryTrees;

import java.util.HashMap;
import java.util.Scanner;


import static C14_binaryTrees.A1_build_BT.printTreeBFS;
import static C14_binaryTrees.A1_build_BT.buildTree;

public class A7_binary_treee_nodes_at_k_dist_from_given_node {
    public static int print_at_k_from_given_node(Node head, Node target, int k){
//      if we reach end of tree and dont find the target
        if(head == null){
            return -1;
        }
        if(head == target){
            print_at_k(head, k);
            return 0;
        }
//      *** target node will be present either in left subtree or in right subtree***
        int d_left = print_at_k_from_given_node(head.left, target, k);
//        this means that node is present in left subtree
        if(d_left != -1){
//           two cases: ancestor itself is at dist k or call on right ancestor
            if(d_left + 1 == k){
                System.out.print(head.data);
                return -1;
            }else{
                print_at_k(head.right, k - 2 - d_left); //explore
                return d_left + 1;
            }

        }
        int d_right = print_at_k_from_given_node(head.left, target, k);
//        target is found in right subtree
        if(d_right != -1){
            if(d_right + 1 == k){
                System.out.print(head.data);
                return -1;
            }else{
                print_at_k(head.left, k - 2 - d_left); //explore left subtree
                return d_right + 1;
            }

        }
//        node was not present in left and right subtree
        return -1;
    }
    private static void print_at_k(Node head, int k){
        if(head == null || k < 0 ){
            return;
        }
        if(k == 0){
            System.out.print(head.data + " ");
        }
        print_at_k(head.left, k -1 );
        print_at_k(head.right, k -1 );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc); //1 2 4 6 -1 -1 7 10 -1 -1 11 -1 -1 5 8 -1 -1 9 -1 -1 3 -1 -1
        printTreeBFS(root);
        print_at_k_from_given_node(root, root.left.left, 3);

    }
}
