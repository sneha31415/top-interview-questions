package C20_graphs;

import java.util.Arrays;

// DSU data structure implementation
// with path compression + rank optimisation
public class DSU {
    int[] parent;
    int[] rank;
    public DSU(int V){
        parent = new int[V];
        rank = new int[V];
//        initialise parent with -1 and rank with 1
        Arrays.fill(parent, -1);
        Arrays.fill(rank, 1);
    }
    public int findParent(int vertex){
        if (parent[vertex] == -1){
            return vertex;
        }
        return parent[vertex] = findParent(parent[vertex]);
    }
    public void makeUnion(int vertex1, int vertex2){
        int p1 = findParent(vertex1);
        int p2 = findParent(vertex2);

        if (p1 != p2){
            if (rank[p1] < rank[p2]){
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }else{
                parent[p2] = p1;
                rank[p1] += rank[p2];
            }
        }
    }
}
