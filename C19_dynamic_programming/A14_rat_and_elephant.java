package C19_dynamic_programming;

//find the number of ways to reach the end cell
// rat -> can move right or down by one step
// elephant -> can move right or down by k steps
public class A14_rat_and_elephant {
    public static int rat(int[][] path, int i, int j, int rows, int cols){
//        you reached the dest
        if (i == rows -1 && j == cols - 1){
            return 1;
        }
//        out of bounds
        if (i >= rows || j >= cols){
            return 0;
        }

        int right = rat(path, i, j + 1, rows, cols);
        int down = rat(path, i + 1, j, rows, cols);
        return right + down;
    }

    public static int bottomUpRat(int [][] path){
        int rows = path.length, cols = path[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int fromUpPaths = 0;
                if (row - 1 >= 0) fromUpPaths = dp[row - 1][col];
                int fromLeftPath = 0;
                if (col - 1 >=0 ) fromLeftPath = dp[row][col - 1];
                dp[row][col] += fromUpPaths + fromLeftPath;
            }
        }
        return dp[rows - 1][cols - 1];
    }

    public static int elephant(int[][] path, int i, int j, int rows, int cols){
//        you reached the dest
        if (i == rows -1 && j == cols - 1){
            return 1;
        }
//        out of bounds
        if (i >= rows || j >= cols){
            return 0;
        }
        int right = 0;
//        from i an elephant can jump by anynumber to get straight to a cell
        for (int verticalJump = 1; verticalJump < cols; verticalJump++){
            right += elephant(path, i, j + verticalJump, rows, cols);
        }
        int down = 0;
        for (int horizontalJump = 1; horizontalJump < rows; horizontalJump++){
            down += elephant(path, i + horizontalJump, j, rows, cols);
        }
        return right + down;
    }

//    elephant bottom up
    public static int bottomUpElephant(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = 1;

        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){

                for (int colIt = 0; colIt < col; colIt++){
                    dp[row][col] += dp[row][colIt];
                }
                for (int rowIt = 0; rowIt < row; rowIt++){
                    dp[row][col] += dp[rowIt][col];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 2},{3, 1, -1},{1, 2, 4},{1, 2, 4}, {1, 2, 4}};
        System.out.println(rat(grid, 0, 0, grid.length, grid[0].length));
        System.out.println(bottomUpRat(grid));
        System.out.println(elephant(grid, 0, 0, grid.length, grid[0].length));
        System.out.println(bottomUpElephant(grid));
    }
}
