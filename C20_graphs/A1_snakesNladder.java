package C20_graphs;

import java.util.*;

public class A1_snakesNladder{
//    find the minimum number of moves and the shortest path to reach the destination cell
    public static int snakesNLadder(int[] board){
//        build the graph
        genericGraph<Integer> g = new genericGraph<>();
        for(int src_number = 1; src_number < 36; src_number++){
            for(int dice = 1; dice <= 6; dice++){
           //   board[src_number + dice] indicates jump
                if(src_number + dice <= 36) {
                    int dest = src_number + dice + board[src_number + dice];
                    if(dest <= 36) g.addEdge(src_number, dest);
                }
            }
        }
        g.addEdge(36, 36);
        return single_source_shortest_path(1, 36, g.adjList);
    }

    public static int single_source_shortest_path(int src, int dest,  HashMap<Integer, List<Integer>> adjList){
        Queue<Integer> pending = new LinkedList<>();
        HashMap<Integer, Integer> distances = new HashMap<>();
        HashMap<Integer, Integer> parent = new HashMap<>();

//        initialise all shortest distances with infinity
        for(int node : adjList.keySet()){
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(src, 0);
        pending.add(src);
        parent.put(src, src);
        while(!pending.isEmpty()){
            int currNode = pending.poll();
//          the shortest dist of a neighbour is when it is visited for the "FIRSint intIME" in "BFS"
            for(int neighbour : adjList.get(currNode)){

//              this means the neighbour is being visited for the first time
                if(distances.get(neighbour) == Integer.MAX_VALUE){
                    pending.add(neighbour);
                    distances.put(neighbour, distances.get(currNode) + 1);
                    parent.put(neighbour, currNode);
                }
            }
        }

//        print the path
        int path = dest;
        while(parent.get(path) != path){
            System.out.print(path + "<-");
            path = parent.get(path);
        }
        System.out.println(path);

//        print the shortest distance
        return distances.get(dest);
    }

    public static void main(String[] args) {
        int[] board = new int[37];
//        ladders
        board[2] = 15;
        board[5] = 7;
        board[9] = 27;
        board[18] = 29;
        board[25] = 35;
//        snakes
        board[17] = 4 - 17;
        board[20] = 6 - 20;
        board[24] = 16 - 24;
        board[32] = 30 - 32;
        board[34] = 12 - 34;

        System.out.println(snakesNLadder(board));
    }
}
