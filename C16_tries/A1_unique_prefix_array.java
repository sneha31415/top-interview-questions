package C16_tries;

import java.util.Arrays;
import java.util.HashMap;

public class A1_unique_prefix_array {
    static class NodeWithFreq {
        char data;
        HashMap<Character, NodeWithFreq> children;
        boolean isTerminal;
        int freq;

        public NodeWithFreq(char data) {
            this.data = data;
            isTerminal = false;
            children = new HashMap<>();
            freq = 0;
        }

    }
    static public class TrieWithFreq {
        NodeWithFreq root;

        public TrieWithFreq() {
            root = new NodeWithFreq('\u0000');
        }

        public void insert(String word) {
            NodeWithFreq ptr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ptr.children.containsKey(c)) {
                    ptr.children.get(c).freq++;
                    ptr = ptr.children.get(c);
                } else {
                    NodeWithFreq n = new NodeWithFreq(c);
                    ptr.children.put(c, n);
                    ptr.children.get(c).freq++;
                    ptr = n;
                }

            }
            ptr.isTerminal = true;
        }

        public boolean contains(String word) {
            NodeWithFreq ptr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ptr.children.containsKey(c)) {
                    ptr = ptr.children.get(c);
                } else {
                    return false;
                }
            }
//        suppose our trie contains "now" but we are searching for "no", then we should check if "o" is terminal
            return ptr.isTerminal;
        }
    }
    public static String[] uniquePrefixArray(String[] words) {
        TrieWithFreq t = new TrieWithFreq();
        for (String word : words) {
            t.insert(word);
        }

        String[] uniquePrefixArray = new String[words.length];
        int idx = 0;
        for (String word : words) {
            NodeWithFreq ptr = t.root;
            boolean uniquePrefix = false;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (ptr.children.get(c).freq == 1) {
                    uniquePrefixArray[idx++] = word.substring(0, i + 1);
                    uniquePrefix = true;
                    break;
                }
                ptr = ptr.children.get(c);
            }
//            cobra has no common prefix if cobras is present
            if (!uniquePrefix) uniquePrefixArray[idx++] = "";
        }
        return uniquePrefixArray;
    }
    public static void main(String[] args) {
        String[] words = {"cobra", "cobras", "apple", "ape", "animal", "dog", "duck"};
        String[] uniquePrefixArray = uniquePrefixArray(words);
        System.out.println(Arrays.toString(uniquePrefixArray));
    }
}
