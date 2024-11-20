package C19_dynamic_programming;

import java.util.Scanner;

public class A11_count_binaryTress {
    public static int factorial(int n){
        int fact =  1;
        for (int i = 1; i <= n ; i++){
            fact *= i;
        }
        return fact;
    }
    public static int countBinaryTreesHelper(int n){
        if (n == 0){
            return 1;
        }
        int numBT = 0;
//        choose a root
        for (int i = 1; i <= n; i++){
            numBT +=  (countBinaryTreesHelper(i - 1) * countBinaryTreesHelper(n - i));
        }
        return numBT;
    }
    public static int countBinaryTrees(int n, int Nfactorial){
        return Nfactorial * countBinaryTreesHelper(n);
    }

    public static int bottomUp(int n){
        int[] dp = new int[n + 1];
        dp[0] = 1; //base

        for (int numNodes  = 1; numNodes <= n; numNodes++){
            for (int i = 1; i <= numNodes; i++){
                dp[numNodes] += ( dp[i - 1] * dp[numNodes - i] );
            }
        }

        for (int i = 0; i <= n; i++){
            dp[i] *= factorial(i);
        }

        return dp[n];
    }

    public static int countBT_catalanFormula(int n){
//        2nCn / (n + 1)
        int numerator = factorial(2 * n);
        int denominator = factorial(n);
        denominator *= denominator;
        int ncr = numerator / denominator;
        return (factorial(n) * ncr) / (n + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nFactorial = factorial(n);
        System.out.println(countBinaryTrees(n, nFactorial));
        System.out.println(bottomUp(n));
        System.out.println(countBT_catalanFormula(n));
    }
}
