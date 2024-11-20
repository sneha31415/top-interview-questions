package C14_binaryTrees;

public class Node {
    int data;
    Node left;
    Node right;
    public Node(){}
    public Node(int data){
        this.data = data;
    }
    public Node(int data, Node left, Node right){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
