package C6_binary_search;

public class A4_aggressive_cows {
//    this func tells if we can place the cows with min_sep = mid given the stalls placement
    private static boolean can_keep_cows(int[] stalls, int n, int cows, int min_sep){
//        to maximise minimum dist, place the first cow at first stall
        int last_cow_position = stalls[0];
        int cows_placed = 1;
        for (int i = 1; i < n; i++){
            if (stalls[i] - last_cow_position >= min_sep){
                last_cow_position = stalls[i];
                cows_placed++;
                if (cows_placed == cows)
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9}; //must be sorted
        int n = 5; //stallls.length
        int cows = 3;

//        binary search on the <hypothetical search space> (ie possible answers) and not on stalls[]
//        make hypothetical search space
        int s = 0;
        int e = stalls[n - 1] - stalls[0]; //search space is 0,1.....(stalls[n - 1] - stalls[0])

        int ans = 0;
        while (s <= e){
            int mid = (s + e) / 2;
//            check if mid can be an answer and move accordingly
            boolean cows_rakh_paye = can_keep_cows(stalls, n, cows, mid);
            if (cows_rakh_paye){
                ans = mid;
//                continue the search for maximising the minimum seperation
                s = mid + 1;
            }else{
                e = mid - 1;
            }
        }
        System.out.println("The minimum seperation is: " + ans);
    }
}
