package C10_recursion_V_backtracking;

public class A5_sudoku_solver {
    public static boolean sudoku_solver(int[][] sudoku, int i, int j, int n){
//        if you reach the (n+1)th row, then sudoku is solved
        if(i == n){
//            print the sudoku
            for (int[] row : sudoku){
                for (int col : row){
                    System.out.print(col + " ");
                }
                System.out.println();
            }
            return true;
        }

//      you have reached the end of row, so call over the next row cell
        if(j == n){
//            move to the next row
            return sudoku_solver(sudoku, i + 1, 0, n);
//            note: you cant do i +=1 and j = 0 manually, it needs to be done recursively so that each cell has its copy of i, j
        }
//        if a number already exists, skip that cell
        if(sudoku[i][j] != 0){
            return sudoku_solver(sudoku, i, j + 1, n);
        }

//        try placing every number in the cell;
        for (int num = 1; num <= 9; num++){
            if(isValidNum(sudoku, i, j, n, num)){
                sudoku[i][j] = num;
                boolean nextNumRakhPaye = sudoku_solver(sudoku, i, j+1, n);
                if(nextNumRakhPaye){
                    return true;
                }
//                else backtrack
                sudoku[i][j] = 0;
            }
        }
        return false;
    }

    private static boolean isValidNum(int[][] sudoku, int i, int j, int n, int num){
//         check for the presence for that num in row / col simultaneously
        for (int idx = 0; idx < n; idx++){
            if(sudoku[idx][j] == num || sudoku[i][idx] == num){
                return false;
            }
        }
//        check for the submatrix
        int rootn = (int)Math.pow(n, 0.5);
        int sx = (i / rootn) * rootn;
        int sy = (j / rootn) * rootn;

//        subgrid is of size rootn *  rootn
        for (int row = sx; row < sx + rootn; row++){
            for(int col = sy; col < sy + rootn; col++){
                if(sudoku[row][col] == num){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };


        boolean solve =  sudoku_solver(board, 0,0, 9);
    }
}
