package C19_dynamic_programming;

public class A15_numPaths_with_obstacle {
    public static int numPaths(int[][] grid, int i, int j, int rows, int cols){
        if (i >= rows || j >= cols){
            return 0;
        }
//        obstacle
        if (grid[i][j] == -1){
            return 0;
        }
        if (i == rows - 1 && j == cols - 1){
            return 1;
        }
        int right = numPaths(grid, i, j + 1, rows, cols);
        int down = numPaths(grid, i + 1, j, rows, cols);
        return right + down;
    }

    public static int bottomUp(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
//                if a cell is blocked, it cannot be entered from left or above
                if (grid[row][col] == -1){
                    dp[row][col] = 0;
                    continue;
                }
                int topWays = 0;
                if (col - 1 >= 0) topWays = dp[row][col - 1];
                int leftWays = 0;
                if (row - 1 >= 0) leftWays = dp[row - 1][col];
                dp[row][col] += topWays + leftWays;
            }
        }
        return dp[rows - 1][cols - 1];
    }
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 2},{3, 1, -1},{1, 2, 4},{-1, 2, 4}, {1, 2, 4}};
        int rows = grid.length;
        int cols = grid[0].length;
        System.out.println(numPaths(grid,0, 0, rows, cols));
        System.out.println(bottomUp(grid));
    }
}
