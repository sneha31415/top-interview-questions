package C4_2D_arrays;

import java.util.Scanner;

public class A6_staircase_search {
    public static void staircase_search(int[][] input, int target){
//        set two pointers to keep track of the current index in the 2d array
        int row_length = input.length;
        int col_length = input[0].length;
        int row = 0;
        int col = col_length - 1;
        while (row < row_length && col >= 0){
            if (input[row][col] == target){
                System.out.println("target found at row: " + row + " & col: " + col);
                break;
            }
            else if(input[row][col] > target){
                col--;
            }
            else{
                row++;
            }
        }
        if(row == row_length || col < 0){
            System.out.println("target not found");
        }
        System.out.println();
    }
    public static void main(String[] args) {
//        taking array input
        Scanner sc = new Scanner(System.in);
        int num_rows = sc.nextInt();
        int num_cols = sc.nextInt();
        int [][] input = new int[num_rows][num_cols];
        for (int row = 0; row < num_rows; row++){
            for (int col = 0; col < num_cols; col++){
                input[row][col] = sc.nextInt();
            }
        }
        staircase_search(input, 17);
    }
}
