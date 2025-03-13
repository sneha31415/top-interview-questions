public class A1_build_tree {
//    int[] a = new int[100005];
    static int[] a = {0, 1,-1, 4, 5, 6, 6,  10, 12, 19};
    static int[]seg = new int[4 * 100005];
    public static void build(int nodeNumber, int low, int high) {
        if (high == low) {
            seg[nodeNumber] = a[high];
            return;
        }
        int mid = (low + high) / 2;
        build(nodeNumber * 2 + 1, low, mid);
        build(nodeNumber * 2 + 2, mid + 1, high);

        //        backtrack
        seg[nodeNumber] = Math.max(seg[nodeNumber * 2 + 1], seg[nodeNumber * 2 + 2]);
    }
    public static int query(int nodeNumber, int low, int high, int query_l, int query_r) {
//      case 1 : complete subset
        if (query_l <= low && query_r >= high) return seg[nodeNumber];

//        case 2 : doesnt lie at all
        if (query_r < low || query_l > high) return Integer.MIN_VALUE;

//        case 3 : overlap (explore both sides)
        int mid = (low + high) / 2;
        int exploreLeft = query(nodeNumber * 2 + 1, low, mid, query_l, query_r);
        int exploreRight = query(nodeNumber * 2 + 2, mid + 1, high, query_l, query_r);
        return Math.max(exploreLeft, exploreRight);
    }
//    given q queries as [l, r] find the max among this range [l, r]
    public static void main(String[] args) {
        int n = a.length;
        build(0, 0, n - 1);
        int[][] queries = {{0, 4}, {2, 3}, {5, 5}, {2, 5}};
        for (int[] q : queries) {
            int query_l = q[0], query_r = q[1];
//            first node in segment tree is node num 0 and its range is (0, n - 1)
            System.out.println(query(0, 0, n - 1, query_l, query_r));
        }
    }
}
