package C19_dynamic_programming;

import java.util.Arrays;

// find longest_common_subsubsequence
// given s1 and s2, find the lcs
// eg "abcd" , "abedg" have 'abd' as LCS
public class A8_LCS {
    public static int LCSLength(String s1, String s2, int s1Ptr, int s2Ptr){
        if (s1Ptr >= s1.length() || s2Ptr >= s2.length()){
            return 0;
        }
        if (s1.charAt(s1Ptr) == s2.charAt(s2Ptr)){
            return 1 + LCSLength(s1, s2, s1Ptr + 1, s2Ptr + 1);
        }
        else {
            return Math.max(LCSLength(s1, s2, s1Ptr + 1, s2Ptr),
                            LCSLength(s1, s2, s1Ptr, s2Ptr + 1));
        }
    }

//    --------------topDown--------------
    public static int topDown(String s1, String s2, int s1Ptr, int s2Ptr, int[][]dp){
    //        one of the string is finised then we cannot get any common
        if (s1Ptr >= s1.length() || s2Ptr >= s2.length()){
            return 0;
        }

        if (dp[s1Ptr][s2Ptr] != -1) return dp[s1Ptr][s2Ptr];

        if (s1.charAt(s1Ptr) == s2.charAt(s2Ptr)){
            return 1 + topDown(s1, s2, s1Ptr + 1, s2Ptr + 1, dp);
        }
        else {
            return Math.max(topDown(s1, s2, s1Ptr + 1, s2Ptr, dp),
                    topDown(s1, s2, s1Ptr, s2Ptr + 1, dp));
        }
    }

//    -----------------bottom up----------------------
//    The number of unique states = s1.length * s2.length
    public static int bottomUp(String s1, String s2){
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];

        for (int s1ptr = n1 - 1; s1ptr >= 0; s1ptr--) {
            for (int s2ptr = n2 - 1; s2ptr >= 0; s2ptr--) {
                if (s1.charAt(s1ptr) == s2.charAt(s2ptr)) {
                    dp[s1ptr][s2ptr] += 1;
                    if (s1ptr + 1 < n1 && s2ptr + 1 < n2) {
                        dp[s1ptr][s2ptr] += dp[s1ptr + 1][s2ptr + 1];
                    }
                }else {
                    int moveS1ptr  = 0;
                    if (s1ptr + 1 < n1) moveS1ptr = dp[s1ptr + 1][s2ptr];
                    int moveS2ptr = 0;
                    if (s2ptr + 1 < n2) moveS2ptr = dp[s1ptr][s2ptr + 1];
                    dp[s1ptr][s2ptr] = Math.max(moveS1ptr, moveS2ptr);
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abecd";
        System.out.println(LCSLength(s1, s2, 0, 0));

        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(topDown(s1, s2, 0, 0, dp));
        System.out.println(bottomUp(s1, s2));
    }
}
