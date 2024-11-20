package C20_graphs;
import java.util.*;

public class A2_floodFill {
//    here, (row, col) donote the correct position of cell in that dfs call
//    replaceChar tells which char(eg '.') has to be replaced to newColor

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void floodFill(int[][] matrix, int row, int col, int replaceChar, int newColor){
//        matrix out of bound condition
        if (row < 0 || col < 0 || col >= matrix.length || row >= matrix.length){
            return;
        }
//        figure boundry conditions
        if (matrix[row][col] != replaceChar){
            return;
        }

//        explore all paths recursively and fill the new color
        matrix[row][col] = newColor;
        for (int i = 0; i < 4; i++){
            floodFill(matrix, row + dx[i], col + dy[i], replaceChar, newColor);
        }

    }
    public static void main(String[] args) {
        String[] s = {"a"};
        List<String> sl = new ArrayList<>(Arrays.asList(s));
    }
}
