package C10_recursion_V_backtracking;

public class A4_n_queen {
//    i denotes the row we are on, and j denotes the total number of rows in a board
    public static boolean n_queen(int[][] board, int i, int n){
//        if you reach i == n , the you have filled i = 0 to n - 1 safely, so print the board
        if(i == n){
//            print the board
            for (int[] row : board){
                for(int col : row){
                    if(col == 1){
                        System.out.print('Q');
                    }else{
                        System.out.print('_');
                    }
                }
                System.out.println();
            }
            System.out.println("-------------");
//            return true;
//            if we return false then it will check for all possible positions of queen and not just stop after one valid configuration
            return false;
        }
        for (int col = 0; col < n; col++){
//            assume it is a safe place
            if(isSafe(board, i, col, n)) {
                board[i][col] = 1;
                boolean nextQueenRakhPaye = n_queen(board, i + 1, n);
//                if i, col pe queen rakhne se next row mei queen rkhan possible hai to thik else backtrack
                if(nextQueenRakhPaye){
                    return true;
                    }
//         else back track from the wrong filled place cuz we cant place a queen here
            board[i][col] = 0;
            }
        }
//        if we reach here then is row mei hum queen kahi nah rkh paye so pichle row mei jake try next position
        return false;
    }

    private static boolean isSafe(int[][] board, int i, int j, int n){
//        this function checks if it is safe to place a queen at i, j
//        check for rows
        for (int row = i ; row >=0; row--){
            if(board[row][j] == 1){
                return false;
            }
        }
//        check for left above diagonal
        int x = i ;
        int y =j;
        while(x >= 0 && y >= 0){
            if(board[x][y] == 1){
                return false;
            }
            x--;
            y--;
        }
//        check for right above diagonal
        x = i ;
        y = j ;
        while (x >= 0 && y < n){
            if(board[x][y] == 1){
                return false;
            }
            x--;
            y++;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean ans = n_queen(new int[5][5], 0, 5);
    }
}
