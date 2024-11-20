package C6_binary_search;
// problem statement : return the minimum time in which all the boards can be painted
// each painter takes one unit of time to paint 1 unit of board. so a board of length l is painted in "l" unit of time
// given a array of boards, find the minimum time in which the boards can be painted
// Note: 1) one board of length L can be painted by only one painter
//       2) a painter can paint only contiguous segments of board***

public class A8_painter_partition_problem {
//    is it possible to paint all the boards in time = mid? ; given num_painters = painters. The below func does thos==is
    private static boolean is_possible(int[] boards, int painters, int mid){
        int painted_boards = 0;
        int painters_used = 1;
        int n = boards.length;
        for (int i = 0; i < n; i++){
            if (painted_boards + boards[i] <= mid){
                painted_boards += boards[i];
            }else{
                painters_used++;
                painted_boards = boards[i];
                if (painted_boards > mid){
                    return false;
                }
                if (painters_used > painters) {
                    return false;
                }
            }
        }
//        return true if the work can be done in "mid" minutes by no. of painters <= 'painters'
        return true;
    }
    public static int minimum_time_to_paint(int[] boards, int painters){
        int min_time = 0;
//        define the subspace. The output is time so subspace is of time only
        int num_tiles = 0;
        for (int board: boards){
            num_tiles += board;
        }
        int n = boards.length;
        int s = boards[n - 1]; //minimum time is the largest board
        int e = num_tiles; //max time is when one painter paints all the boards alone
//        do binary search on time
        while (s <= e){
            int mid = (s + e) / 2;
            if (is_possible(boards, painters, mid)){
                min_time = mid;
                e = mid - 1;
            }else{
//                increase time if the number of painters required is more than that available
                s = mid + 1;
            }
        }
        return min_time;
    }

    public static void main(String[] args) {
        int[] boards = {5, 6, 4, 1};
        int painters = 2;
        System.out.println(minimum_time_to_paint(boards, painters));

    }
}
