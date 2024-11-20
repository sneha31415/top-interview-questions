package C16_tries;
import java.util.*;

public class Trie {
    Node root;
    public Trie(){
        root = new Node('\u0000');
    }

    public void insert(String word) {
        Node ptr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ptr.children.containsKey(c) ) {
                ptr = ptr.children.get(c);
            }else{
                Node n = new Node(c);
                ptr.children.put(c, n);
                ptr = n;
            }
        }
        ptr.isTerminal = true;
    }

    public boolean contains(String word) {
        Node ptr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (ptr.children.containsKey(c)){
                ptr = ptr.children.get(c);
            }else{
                return false;
            }
        }
//        suppose our trie contains "now" but we are searching for "no", then we should check if "o" is terminal
        return ptr.isTerminal;
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        String[] words = {"no", "not", "news", "apple", "ape"};
        for (String word : words) {
            t.insert(word);
        }
        System.out.println(t.contains("ap"));

        int[] A = {4, 2, 2, 6, 4};
        int c =0 ;
        for (int a : A) {
            c ^= a;
            System.out.println(c);
        }
        System.out.println(2 ^ 6);
    }
}
