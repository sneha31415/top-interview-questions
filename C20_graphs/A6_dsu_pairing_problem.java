package C20_graphs;
import java.util.*;

// question: given n cities and their connections, find the ways in which we can choose 2 cities such that
// both the cities are not directly connected
public class A6_dsu_pairing_problem {
    static class Pair {
        int vertex1;
        int vertex2;

        public Pair(int vertex1, int vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
    }

    private static int findParent(int vertex, int[] parent) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return parent[vertex] = findParent(parent[vertex], parent);
    }

    private static void makeUnion(int vertex1, int vertex2, int[] parent, int[] rank) {
        int p1 = findParent(vertex1, parent);
        int p2 = findParent(vertex2, parent);

        if (p1 != p2) {
            if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            } else {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            }
        }
    }

    public static int pairing(int V, List<Pair> edgeList) {
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int vertex = 0; vertex < V; vertex++) {
            parent[vertex] = -1;
            rank[vertex] = 1;
        }
//        make the rank matrix
        for (Pair edge : edgeList) {
            int v1 = edge.vertex1;
            int v2 = edge.vertex2;
            int p1 = findParent(v1, parent);
            int p2 = findParent(v2, parent);

            makeUnion(p1, p2, parent, rank);
        }

//        problem logic
        int totalPairs = 0;
        for (int vertex = 0; vertex < V; vertex++) {
//          every vertex can choose a city other than the cities in its own connected component
            totalPairs += (V - rank[findParent(vertex, parent)]);
        }
        return (totalPairs / 2);
    }

    public static void main(String[] args) {
        List<Pair> edgeList = new ArrayList<>();
        edgeList.add(new Pair(0, 1));
        edgeList.add(new Pair(2, 3));
        edgeList.add(new Pair(0, 4));
        System.out.println(pairing(5, edgeList));
    }
}
