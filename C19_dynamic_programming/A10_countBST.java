package C19_dynamic_programming;

import java.util.Scanner;

public class A10_countBST {
    public static int countBST(int n){
//        if there are zero nodes, 1 bst is possible
        if (n == 0){
            return 1;
        }
        int numBST = 0;
//        choose a root
        for (int i = 1; i <= n; i++) {
//        with the fixed root, count bst from left subtree and right subtree
            numBST += countBST(i - 1) * countBST(n - i);
        }
        return numBST;
    }

//    dp optimised
    public static int countBSTDP(int n, int[] dp){
    //        if there are zero nodes, 1 bst is possible
        if (n == 0){
            return 1;
        }

        if (dp[n] != 0) return dp[n];

        int numBST = 0;
    //        choose a root i.e i = 1 as root, then i= 2 as root
        for (int i = 1; i <= n; i++) {
    //        with the fixed root, count bst from left subtree and right subtree
            numBST += countBSTDP(i - 1, dp) * countBSTDP(n - i, dp);
        }
        return dp[n] = numBST;
    }

    public static int bottomUp(int n){
//        dp[i] contains the number of bst that can be made from nodes i number of nodes
        int[] dp = new int[n + 1];
        dp[0] = 1; //base

        for (int numNodes  = 1; numNodes <= n; numNodes++){
            for (int i = 1; i <= numNodes; i++){
                dp[numNodes] += ( dp[i - 1] * dp[numNodes - i] );
            }
        }

        return dp[n];
    }

    public static int factorial(int num){
        int fact = 1;
        for (int i = 1; i <= num; i++){
            fact *= i;
        }
        return fact;
    }
    public static int countBST_catalanFormula(int n){
//        2nCn / (n + 1)
        int numerator = factorial(2 * n);
        int denominator = factorial(n);
        denominator *= denominator;
        int ncr = numerator / denominator;
        return ncr / (n + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countBST(n));
        int[] dp = new int[n + 1];
        System.out.println(countBSTDP(n, dp));
        System.out.println(bottomUp(n));
        System.out.println(countBST_catalanFormula(n));
    }
}
