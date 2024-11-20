package C14_binaryTrees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A1_build_BT {
    public static Node buildTree(Scanner sc){
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        Node root = new Node(data);
//        build the left and right tree recursively
        root.left = buildTree(sc);
        root.right = buildTree(sc);
        return root;
    }
    public static void printTree(Node root){
        if(root == null){
            System.out.print('N' + " ");
            return;
        }
        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
    public static void printTreeBFS(Node root){
        if(root == null){
            return;
        }
        Queue<Node> pending = new LinkedList<>();
        pending.add(root);
        while(!pending.isEmpty()){
            int n = pending.size();
//            for loop for each level
            for(int i = 0; i < n; i++){
                Node curr = pending.poll();
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    pending.add(curr.left);
                }
                if(curr.right != null){
                    pending.add(curr.right);
                }
            }
//            new line after each level
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        Node root = buildTree(sc);
//        printTree(root);

        StringBuilder smallest = new StringBuilder();
        System.out.println(smallest);
        System.out.println(smallest.toString());
        }
        }
