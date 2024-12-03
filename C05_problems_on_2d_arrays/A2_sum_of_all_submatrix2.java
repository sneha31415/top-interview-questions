package C5_problems_on_2d_arrays;

import java.util.Scanner;

//approach : PREFIX SUM
// TC = O(N^4), SC = O(N^2)
// first perform row prefix sum and then column prefix sum
public class A2_sum_of_all_submatrix2 {
    public static int submatrices_sum(int[][] input){
        int all_submatrix_sum = 0;
        int m = input.length;
        int n = input[0].length;
        int[][] prefix_sum = new int[m][n];
//        row prefix
        for (int row = 0; row < m; row++){
            int row_sum = 0;
            for (int col = 0; col < n; col++) {
                row_sum += input[row][col];
                prefix_sum[row][col] = row_sum;
            }
        }
//        column prefix
        for (int col = 0; col < n; col++){
            int col_sum = 0;
//            iterate faster over rows
            for (int row = 0; row < m; row++){
                col_sum += prefix_sum[row][col];
                prefix_sum[row][col] = col_sum;
            }
        }

//        prefix sum is ready
//        now generate submatrices
//        first 2 loops generate the top left point
        for (int li = 0; li < m; li++){
            for (int lj = 0; lj < n; lj++){
//                now bottom right point
                for (int bi = li; bi < m; bi++){
                    for (int bj = 0; bj < n; bj++){
                        int topsum = 0;
                        int leftsum = 0;
                        int intersection = 0;
                        if (li > 0){
                            topsum = prefix_sum[li - 1][bj];
                        }
                        if (lj > 0){
                            leftsum = prefix_sum[bi][lj - 1];
                        }
                        if (li > 0 && lj > 0){
                            intersection = prefix_sum[li - 1][lj - 1];
                        }
                        all_submatrix_sum += prefix_sum[bi][bj] - topsum - leftsum + intersection;
                    }
                }
            }
        }
        return all_submatrix_sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_rows = sc.nextInt();
        int num_cols = sc.nextInt();
        int [][] input = new int[num_rows][num_cols];
        for (int row = 0; row < num_rows; row++){
            for (int col = 0; col < num_cols; col++){
                input[row][col] = sc.nextInt();
            }
        }
        System.out.println(submatrices_sum(input));
    }
}
