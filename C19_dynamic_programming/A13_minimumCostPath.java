package C19_dynamic_programming;

import java.util.Arrays;

public class A13_minimumCostPath {
    public static int minimumCost(int[][] path, int i, int j, int rows, int cols){
        if (i >= rows || j >= cols){
            return (int)1e6;
        }
        int right = minimumCost(path, i, j + 1, rows, cols);
        int down = minimumCost(path, i + 1, j, rows, cols);

        int remainingPathCost = Math.min(right, down);
        remainingPathCost = remainingPathCost == (int)1e6 ? 0 : remainingPathCost;
        return path[i][j] + remainingPathCost;
    }

//    top down
    public static int topDown(int[][] path, int i, int j, int rows, int cols,int[][] dp){
        if (i >= rows || j >= cols){
            return (int)1e6;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int right = topDown(path, i, j + 1, rows, cols, dp);
        int down = topDown(path, i + 1, j, rows, cols, dp);

        int remainingPathCost = Math.min(right, down);
        remainingPathCost = remainingPathCost == (int)1e6 ? 0 : remainingPathCost;
        return dp[i][j] = path[i][j] + remainingPathCost;
    }
//    bottom up dp
    public static int bottomUp(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                int topMinPathSum = Integer.MAX_VALUE;
                int leftMinPathSum = Integer.MAX_VALUE;
                if (row - 1 >= 0) topMinPathSum = dp[row - 1][col];
                if (col - 1 >= 0) leftMinPathSum = dp[row][col - 1];
                int minimumPathSoFar = Math.min(topMinPathSum, leftMinPathSum);
                minimumPathSoFar = (minimumPathSoFar == Integer.MAX_VALUE) ? 0 : minimumPathSoFar;
                dp[row][col] = minimumPathSoFar + grid[row][col];
            }
        }
        return dp[rows - 1][cols - 1];
    }
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 2},{3, 1, -1},{1, 2, 4},{1, 2, 4}, {1, 2, 4}};
        int rows = grid.length;
        int cols = grid[0].length;
        System.out.println(minimumCost(grid, 0, 0, rows, cols));
        int[][] dp = new int[rows][cols];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }
        System.out.println(topDown(grid, 0, 0, rows, cols, dp));
        System.out.println(bottomUp(grid));
    }
}
