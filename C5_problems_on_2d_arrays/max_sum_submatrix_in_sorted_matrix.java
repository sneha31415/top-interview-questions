package C5_problems_on_2d_arrays;

import java.util.Arrays;
import java.util.Scanner;

import static C5_problems_on_2d_arrays.A0_2D_suffix_sum.get_2D_suffix_sum;

//problem statement - The given matrix is sorted row and column wise. Find the max sum submatrix and return the max sum
// approach = max element in suffix sum matrix.
// intuition : The max subarray is bound to contain the last element of the matrix. So we dont need to generate all subarrays
public class max_sum_submatrix_in_sorted_matrix {
    public static int max_sum(int[][] input){
        int max_sum = Integer.MIN_VALUE;
        int rows = input.length;
        int cols = input[0].length;
//        Here, we are changing the original matrix itself by adding the previous rows and cols into the curr rows and cols respectively
//        start from the last element and calculate the suffix matrix
//        suffix sum on cols i.e col wise addition
        for (int row = rows - 1; row >= 0; row--){
//         start from the 2nd last column. each cell will be the sum of its previous col
            for (int col = cols - 2; col >= 0; col--){
                input[row][col] += input[row][col + 1];
            }
        }
//        suffix sum on rows i.e row wise addition
        for (int col = cols - 1; col >= 0; col--){
            for (int row = rows - 2; row >= 0; row--){
                input[row][col] += input[row + 1][col];
            }
        }

        for (int[] suffix_row: input){
            for (int possible_ans : suffix_row){
                max_sum = Math.max(max_sum, possible_ans);
            }
        }
        return max_sum;
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
        System.out.println(max_sum(input));

    }
}
