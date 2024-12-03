package C5_problems_on_2d_arrays;

import java.util.Scanner;

public class A3_sum_of_all_submatrix3 {
//    Approach => PnC. Calculate the number of submatrices that a cell is part of
    public static int submatrices_sum(int[][] input){
        int all_submatrix_sum = 0;
        int row_length = input.length;
        int col_length = input[0].length;
        for (int row = 0; row < row_length; row++){
            for (int col = 0; col < col_length; col++){
//                contri of a cell = cell_value * no.of submatrices it is part of
//              contri of a cell = cell_value * [(no. of possible values of top left) * (no. of possible values of bottom right)]
//                no. of possible values of top left = (row + 1) * (col + 1)
//                no. of possible values of bottom right = (row_length - row) * (col_length - col)
                all_submatrix_sum += input[row][col] * ((row + 1) * (col + 1) * (row_length - row) * (col_length - col));
            }
        }
        return all_submatrix_sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_rows = sc.nextInt();
        int num_cols = sc.nextInt();
        int [][] input = new int[num_rows][num_cols];
//        iterate over all cells
        for (int row = 0; row < num_rows; row++){
            for (int col = 0; col < num_cols; col++){
                input[row][col] = sc.nextInt();
            }
        }
        System.out.println(submatrices_sum(input));
    }
}
