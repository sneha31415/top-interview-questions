package C4_2D_arrays;

import java.util.Scanner;

public class A2_waveprint {
//    Logic => col is even then go top down'
//              if col is odd then go bottom up
    public static void wavePrint(int [][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
//        outer loop will be a col loop and inner is a row loop
        for (int i = 0; i < cols; i++){ //iterate on cols first
            for (int j = 0; j < rows; j++){
                if (i % 2 == 0){
                    System.out.print(arr[j][i] + " ");
                }
                else{
                    System.out.print(arr[rows - 1 - j][i] + " ");
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr[][] = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        wavePrint(arr);
     }
}
