package C5_problems_on_2d_arrays;

public class A0_2D_suffix_sum {
    public static int[][] get_2D_suffix_sum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] suffixSum = new int[rows][cols];

        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col --) {
                int down = row + 1 < rows ? suffixSum[row+1][col] : 0;
                int right = col + 1 < cols ? suffixSum[row][col + 1] : 0;
                int downRight  = row + 1 < rows && col + 1 < cols ?  suffixSum[row+1][col + 1] : 0;

                suffixSum[row][col] = matrix[row][col] + down + right - downRight;
            }
        }
        return suffixSum;
    }
    public static void main(String[] args) {

    }
}
