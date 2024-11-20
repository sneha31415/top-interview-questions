package C10_recursion_V_backtracking;

public class A2_count_all_paths_rat_maze {
    public static int count_rat_maze_paths(int[][] maze, int[][] path, int i, int j, int m, int n){
        if(i >= m || i >= n){
            return 0;
        }
        if(maze[i][j] == 0){
            return 0;
        }

//      include in curr path
//        path[i][j] = 1;

        if(i == m - 1 && j == n - 1){
            return 1;
        }
        int rights = count_rat_maze_paths(maze, path, i, j + 1, m, n);
        int downs = count_rat_maze_paths(maze, path, i + 1, j , m, n);
//        backtrack
//        path[i][j] = 0;
        return rights + downs;
    }

    public static void main(String[] args) {
        int [][] maze = {{1,1,0},{1,1,0},{1,1,1}};
        int[][] path = new int[3][3];
        System.out.println(count_rat_maze_paths(maze, path, 0, 0, 3, 3));
    }
}
