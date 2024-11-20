package C16_tries;

public class A2_max_xor_of_two_elems {
    static class Node{
        Node left; // left denotes a zero
        Node right; // right denotes a one
        public Node(){
            this.left = null;
            this.right = null;
        }
    }

    static class Trie{
        Node root;
        public Trie(){
            root = new Node();
        }
        public void insert(int num) {
            Node ptr = root;
//            5 => ....00000101
//            we have to insert the msb first
            for (int i = 31; i >= 0; i--) {
                int mstBit = (num >> i)&1;

                if (mstBit == 1) {
                    if (ptr.right == null) {
                        ptr.right = new Node(); //no need to assign any values to node as exisitence of left and right tells whether 0 or 1 is present
                    }
                    ptr = ptr.right;
                }else{
                    if (ptr.left == null) {
                        ptr.left = new Node();
                    }
                    ptr = ptr.left;
                }
            }
        }
    }

    public static int maxXorHelper(int number, Trie prefixTree) {
        Node ptr = prefixTree.root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            int msbBit = (number >> i) & 1;
            if (msbBit == 1) {
//                msb bit is 1 so we need a 0(i.e complement) to maximise xor
                if (ptr.left != null) {
//                    1 ^ 0 = 1, so contribution is (2^i) in maxXor
                    maxXor += (1<<i);
                    ptr = ptr.left;
                }else{
//                    1 ^ 1 = 0 so no contribution
                    ptr = ptr.right;
                }
            }
//            msb bit is 0
            else {
//          msb bit is 1 so we need a 0(i.e complement) to maximise xor
                if (ptr.right != null) {
                    maxXor += (1 << i);
                    ptr = ptr.right;
                }else{
                    ptr = ptr.left;
                }
            }
        }
        return maxXor;
    }

    public static int maxXor (int[] nums) {
        Trie prefixTree = new Trie();
        int maxXor = 0;
        for (int num : nums) {
            prefixTree.insert(num);
            maxXor = Math.max(maxXor, maxXorHelper(num, prefixTree));
        }
        return maxXor;
    }
    public static void main(String[] args) {
       int[] nums = {3};
        System.out.println(maxXor(nums));
    }

    /*
    -----FLOW-----
    node will have left and right
    trie class will have Nodes and an insert(number) function
    I'm considering each number to fit in 32 bit range
    A helper function that will calculate the maximum xor of number with the elems inserted so far
    finally a main function that will use the helper function to get most maximum xor
    */
}
