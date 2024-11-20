package C10_recursion_V_backtracking;

//given a matrix of nxn, with some cells blocked
// -> find all paths from src to dest
// -> count all the possible paths
// ** constraint - The rat can move only in the forward and downward direction

public class A1_rat_in_a_maze {
    public static boolean print_all_paths(int[][] maze, int[][] path, int i, int j, int m, int n){
//        rat must be inside the maze
        if(i >= m || j >= n){
            return false;
        }

//        path does not exist
        if(maze[i][j] == 0){
            return false;
        }
//          assume that current cell is a part of path
        path[i][j] = 1;

//        you found the path if you reach m-1 and n-1
        if(i == m - 1 && j == n - 1){
//        print the path
            for(int[] row : path){
                for(int col : row){
                    System.out.print(col + " ");
                }
                System.out.println();
            }
            System.out.println();
            return true;
        }




        boolean rightSuccess = print_all_paths(maze, path, i, j + 1, m, n);
        boolean leftSuccess = print_all_paths(maze, path, i + 1, j, m, n);

//        backtrack
            path[i][j] = 0;
        return rightSuccess || leftSuccess;
    }
    public static void main(String[] args) {
        int [][] maze = {{1,1,0},{1,1,0},{1,1,1}};
        int[][] path = new int[3][3];
        for (int[] row  : maze){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println("------------------");
        boolean ans = print_all_paths(maze, path, 0, 0, 3, 3);
        System.out.println(ans);
    }
}
