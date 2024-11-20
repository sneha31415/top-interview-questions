package C4_2D_arrays;

import java.util.Arrays;
import java.util.Scanner;

public class A5_rotate_image {
//    USING EXTRA SPACE
    public static int[][] rotate_image(int[][] image){
        int num_rows = image.length;
        int num_cols = image[0].length;
        int[][] rotated_image = new int[num_cols][num_rows];
        for (int row = 0; row < num_rows; row++){
            for (int col = 0; col < num_cols; col++){
                rotated_image[num_cols - 1 - col][row] = image[row][col];
            }
        }
        return rotated_image;
    }
//    USING CONSTANT SPACE(in place rotate)
//    considering n x n image
    public static void rotate_image_inplace(int [][] image){
        int dimension = image.length;
        for (int row = 0; row < dimension; row++){
            for (int col = 0; col < dimension; col++){
//                parallel swapping
                int temp = image[dimension - 1 - col][row];
                image[dimension - 1 - col][row] = image[row][col];
                image[row][col] = temp;
            }
        }
    }
//    2nd way is to first reverse each row and then Transpose matrix by swapping elements across the diagonal
    public static void reverse_row(int[] row){
        int left_ptr = 0;
        int right_ptr = row.length - 1;
        while (left_ptr < right_ptr){
            int temp = row[right_ptr];
            row[right_ptr] = row[left_ptr];
            row[left_ptr] = temp;
            left_ptr++ ;
            right_ptr--;
        }
    }

    public static void rotate_image_inplace2(int[][] image){
        int dimension = image.length;
        for (int[] row: image){
            reverse_row(row);
            }
        for (int row = 0; row < dimension; row++){
//      do swapping only on one triangle i.e either upper or lower
            for (int col = row + 1; col < dimension; col++){
                int temp = image[row][col];
                image[row][col] =  image[col][row];
                image[col][row] = temp;

            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_rows = sc.nextInt();
        int num_cols = sc.nextInt();
        int [][] image = new int[num_rows][num_cols];
        for (int row = 0; row < num_rows; row++){
            for (int col = 0; col < num_cols; col++){
                image[row][col] = sc.nextInt();
            }
        }
        int[][] rotated_image = rotate_image(image);
        for (int[] pixel_row : rotated_image){
            System.out.println(Arrays.toString(pixel_row));
        }

        System.out.println("_________________");
        rotate_image_inplace2(image);
        for (int[] pixel_row : image){
            System.out.println(Arrays.toString(pixel_row));
        }
    }
}
