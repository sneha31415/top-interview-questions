package C20_graphs;

import java.util.*;
public class A4_union_find {
    static class Pair{
        int vertex1;
        int vertex2;
        public Pair(int vertex1, int vertex2){
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
    }
    public static int findParent(int i, int parent[]){
        if(parent[i] == -1){
            return i;
        }
        return findParent(parent[i], parent);
    }

    public static void makeUnion(int s1, int s2, int[] parent){
//        get the ultimate parents
        int p1 = findParent(s1, parent);
        int p2 = findParent(s2, parent);

        if(p1 != p2){
            parent[p1] = p2;
        }
    }

    public static boolean containsCycle(List<Pair> edgeList, int V){
//        init the parent array
        int[] parent = new int[V];
        for (int vertex = 0; vertex < V; vertex++){
            parent[vertex] = -1;
        }
        for (Pair p : edgeList){
            int vertex1 = p.vertex1;
            int vertex2 = p.vertex2;

//            find their ultimate parents
            int parent1 = findParent(vertex1, parent);
            int parent2 = findParent(vertex2, parent);

            if (parent1 == parent2){
                return true;
            }
            makeUnion(parent1, parent2, parent);
        }
        return false;
    }
    public static void main(String[] args) {
//        input is an edge list
        List<Pair> edgeList = new ArrayList<>();
        edgeList.add(new Pair(0, 1));
        edgeList.add(new Pair(1, 2));
        edgeList.add(new Pair(2, 3));
        edgeList.add(new Pair(3, 0));
        System.out.println(containsCycle(edgeList, 4));
    }
}
