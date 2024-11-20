package C5_problems_on_2d_arrays;

import java.util.Scanner;

//given a matrix, give the total sum of all the submatrices sum
// Approach1 : BRUTE FORCE - TC = O(n^6)
// "extract" all the possible submatrix, get their sum
// to extract a submatrix, we need to get all the top-left and the bottom-right
public class A1_sum_of_all_submatrix {
    public static int subarray_sum(int [][] input){
        int all_submatrix_sum = 0;
        int row_length = input.length;
        int col_length = input[0].length;
//        extract all the possible top left
//        li => top left start and lj => top left end ie (li, lj)
        for (int li = 0; li < row_length; li++){
            for (int lj = 0; lj < col_length; lj++) {
//        extract all possible bottom right
                for (int ri = li; ri < row_length; ri++) {
                    for (int rj = lj; rj < col_length; rj++) {
//                        get the sum for elements from (ls, rs) to (le, re)
                        int submatrix_sum = 0;
                        for (int i = li; i <= ri; i++) {
                            for (int j = lj; j <= rj; j++) {
                                submatrix_sum += input[i][j];
                            }
                        }
                        all_submatrix_sum += submatrix_sum;
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
        System.out.println(subarray_sum(input));

    }
}
