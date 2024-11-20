package C5_problems_on_2d_arrays;

public class A0_2D_prefix_sum {
    public static int[][] get_2Dprefix_sum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] prefix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int top = row > 0 ? prefix[row - 1][col] : 0;
                int left = col > 0 ? prefix[row][col - 1] : 0;
                int topleft =  col > 0 && row > 0 ? prefix[row - 1][col - 1] : 0;

                prefix[row][col] = matrix[row][col] + left + top - topleft;
            }
        }
        return prefix;
    }
    public static void main(String[] args) {

    }
}
