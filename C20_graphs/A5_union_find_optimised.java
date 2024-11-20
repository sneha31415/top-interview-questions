package C20_graphs;

import java.util.*;
public class A5_union_find_optimised {
    static class Pair {
        int vertex1;
        int vertex2;

        public Pair(int vertex1, int vertex2) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
        }
    }

        public static int findParent(int i, int[] parent) {
            if (parent[i] == -1) {
                return i;
            }
//        path compression
            return parent[i] = findParent(parent[i], parent);
        }

        public static void makeUnion(int vertex1, int vertex2, int[] parent, int[] rank) {
            int parent1 = findParent(vertex1, parent);
            int parent2 = findParent(vertex2, parent);

//        make union if there isnt a cycle formation
            if (parent1 != parent2) {
//            make larger chain/tree as the parent
                if (rank[parent1] < rank[parent2]) {
                    parent[parent1] = parent2;
//                update the rank
                    rank[parent2] += rank[parent1];
                } else {
                    parent[parent2] = parent1;
                    rank[parent1] += rank[parent2];
                }
            }
        }

        public static boolean containsCycle(int V, List<Pair> edgeList) {
            int[] parent = new int[V];
            int[] rank = new int[V];
            for (int vtx = 0; vtx < V; vtx++) {
                parent[vtx] = -1;
//            initially each element is a disjoint set
                rank[vtx] = 1;
            }

            for (Pair edge : edgeList) {
                int v1 = edge.vertex1;
                int v2 = edge.vertex2;
                int p1 = findParent(v1, parent);
                int p2 = findParent(v2, parent);

                if (p1 == p2) return true;
                makeUnion(p1, p2, parent, rank);
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
            System.out.println(containsCycle(4, edgeList));
        }
    }
