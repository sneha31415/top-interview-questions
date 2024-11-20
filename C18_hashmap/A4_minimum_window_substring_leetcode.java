package C18_problem_solving_using_hashmap;
import java.util.*;

/*
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.


Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
**/

public class A4_minimum_window_substring_leetcode {
    public String minWindow(String s, String t) {
        int limit = 'z' - 'A' + 1;
        int[] sFreq = new int[limit];
        int[] targetFreq = new int[limit];

        setTargetFreq(t, targetFreq);

        int startIndex = 0, endIndex = 0, n = s.length();
        int minStart = 0, minEnd = n;

        while (endIndex < n) {
            char c = s.charAt(endIndex);
            sFreq[c - 'A']++;

//          check validity
            while (isValidWindow(sFreq, targetFreq)) {
                // since its a valid window, update min if possible
                if (endIndex - startIndex + 1 < minEnd - minStart + 1) {
                    minStart = startIndex;
                    minEnd = endIndex;
                }

                // shrink window
                sFreq[s.charAt(startIndex++) - 'A']--;
            }
            endIndex++;
        }
        if (minEnd == n) return ""; //flag

        return s.substring(minStart, minEnd + 1);
    }

    private boolean isValidWindow(int[] sFreq, int[] targetFreq){
        for (int i = 0; i < sFreq.length; i++) {
            if (sFreq[i] < targetFreq[i]) {
                return false;
            }
        }
        return true;
    }

    private void setTargetFreq(String target, int[] targetFreq) {
        int n = target.length();
        for (int index = 0; index < n; index++) {
            char c = target.charAt(index);
            targetFreq[c - 'A']++;
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> h = new HashSet<>();
        Collections.addAll(h, 1, 2, 3);
        List<Integer> y = new ArrayList<>(h);
        Integer[] array = {1, 2, 3};
        // List<int> cannot be initialized directly from an int array
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2 , 3));
    }
}
