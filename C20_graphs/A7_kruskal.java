package C20_graphs;

import java.util.*;

public class A7_kruskal {
    public static int kruskal(List<List<Integer>> edgeList, int V) {
        DSU dsu = new DSU(V);
        int mstWeight = 0;
//        1) sort the edges on the basis of weights
        Collections.sort(edgeList, (a, b) -> a.get(2) - b.get(2));
//        2) pick (n - 1) edges greedily.
//        since at each step, we are checking that cycle is not formed, no need to explicity keep count of the edges joint
        for (List<Integer> edge : edgeList) {
            int v1 = edge.get(0), v2 = edge.get(1), wt = edge.get(2);
            int p1 = dsu.findParent(v1);
            int p2 = dsu.findParent(v2);
//            skip the edge if parent is same to avoid cycle
            if (p1 != p2) {
                dsu.makeUnion(v1, v2);
                mstWeight += wt;
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {

    }
}
