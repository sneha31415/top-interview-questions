package C4_2D_arrays;

import java.util.Scanner;
//Question - traverse the matrix in spiral
public class A3_spiral_print {
    public static void spiral_print(int [][] arr){
//        maintain 4 pointers
        int sr = 0; //denotes the start row
        int er = arr.length - 1; //end row
        int sc = 0;         //start column
        int ec = arr[0].length - 1; //end column

        while (sr <= er && sc <= ec) {
//            print the start row
            for (int i = sc; i <= ec; i++) {
                System.out.print(arr[sr][i] + " ");
            }
//            the start row is printed so point sr to the next row
            sr++;

//          print the end column
            for (int i = sr; i <= er; i++) {
                System.out.print(arr[i][ec] + " ");
            }
//          the end col is printed so point ec to the prev end column
            ec--;

//          print the end row
            if(sr <= er) {
                for (int i = ec; i >= sc; i--) {
                    System.out.print(arr[er][i] + " ");
                }
                er--;
            }

//          print the start columm
            if (sc <= ec) {
                for (int i = er; i >= sr; i--) {
                    System.out.print(arr[i][sc] + " ");
                }
                sc++;
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
//                System.out.println(arr[i][j] + " ");
            }
//            System.out.println();
        }
        spiral_print(arr);
    }
}
