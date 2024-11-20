package C20_graphs;

import java.util.Arrays;

public class A9_dp_with_bitMasking_travelling_salesman_problem {

//    Tc = O(n!)
    public static int minimumDistancePath(int[][] adjMatrix, int mask, int currCity) {
        int n = adjMatrix.length;
        int VISITED_ALL = (1 << n) - 1;

        if (mask == VISITED_ALL){
//            cost to go back to src
            return adjMatrix[currCity][0];
        }
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++){
//            goto the city if its unvisited
            if ((mask & (1<<city)) == 0){
                int currAns = adjMatrix[currCity][city] + minimumDistancePath(adjMatrix, mask | (1<<city), city);
                ans = Math.min(ans, currAns);
            }
        }
        return ans;
    }

//    tc = O((2^n) * n)
//    Sc = O((2^n) * n)
    public static int topDown(int[][] adjMatrix, int mask, int currCity, int[][] dp) {
        int n = adjMatrix.length;
        int VISITED_ALL = (1 << n) - 1;

        if (dp[mask][currCity] != -1) return dp[mask][currCity];
        if (mask == VISITED_ALL){
//            cost to go back to src
            return adjMatrix[currCity][0];
        }
        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < n; city++){
//            goto the city if its unvisited
            if ((mask & (1<<city)) == 0){
                int currAns = adjMatrix[currCity][city] + topDown(adjMatrix, (mask | (1<<city)), city, dp);
                ans = Math.min(ans, currAns);
            }
        }
        return dp[mask][currCity] = ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] adjMatrix = {{0, 20, 42, 25}, {20, 0, 30, 34}, {42, 30, 0, 10}, {25, 34, 10, 0}};
        System.out.println(minimumDistancePath(adjMatrix, 1, 0));
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(topDown(adjMatrix, 1, 0, dp));
    }
}
