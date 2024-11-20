package C14_binaryTrees;

public class A8_least_common_ancestor {
    public static Node least_common_ancestor(Node root, int a, int b){
        if(root == null){
            return null;
        }
//        return the node if any of it is a, or b
        if(root.data == a || root.data == b){
            return root;
        }
        Node leftpresence = least_common_ancestor(root.left, a , b);
        Node rightpresence = least_common_ancestor(root.right, a , b);

//        return the root if the left subtree contains one node and right contains one
        if(leftpresence != null && rightpresence != null){
            return root;
        }
//        if we reach this line then either of leftpresence or rightpresence is null. or both are null
        if(leftpresence != null){
            return leftpresence;
        }
        return rightpresence;
    }
    public static void main(String[] args) {

    }
}
