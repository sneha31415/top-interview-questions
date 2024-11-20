package C20_graphs;
import java.util.*;
public class A10_isBipartite {
    public static boolean isBipartite(int[][] graph) {
        int nodes = graph.length;
        int[] color = new int[nodes];
        for (int node = 0; node < nodes; node++){
            if (color[node] == 0){
                color[node] = 1;
                boolean isBipartite = dfsHelper(graph, node, color);
                if (!isBipartite){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfsHelper(int[][] graph, int node, int[] color){
        for (int nbr : graph[node]) {
            if (color[nbr] == 0) {
                color[nbr] = -color[node];
                boolean isBipartite = dfsHelper(graph, nbr, color);
                if (!isBipartite) return false;
            }else if (color[nbr] == color[node]) {
                return false;
            }
        }
        return true;
    }

//    -------------BFS-----------------
public boolean isBipartiteBFS(int[][] graph) {
    int nodes = graph.length;
    // color is basically also acting as visited[]
    // color = 0 means unvisited, 1 and -1 are colors indicating visitedness
    int[] color = new int[nodes];
    Queue<Integer> pending = new LinkedList<>();

// check for all connected components
    for (int src = 0; src < nodes; src++){
        if (color[src] == 0){
            color[src] = 1;
            pending.add(src);

            while (!pending.isEmpty()) {
                int parent = pending.poll();
                int parentColor = color[parent];

                for (int child : graph[parent]){
                    // child is not visited, color it and add it to queue
                    if (color[child] == 0){
                        pending.add(child);
                        color[child] = -parentColor;
                    }
                    // child is visited and has the same color as parent
                    else if (color[child] == parentColor){
                        return false;
                    }
                }
            }
        }
    }
    return true;
}
}
