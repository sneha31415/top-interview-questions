package C6_binary_search;

import java.util.Arrays;
//Learing = while condition of (time < min_time) will fail at edge cases where time == min_time
//so use time + time_per_prata < min_time
public class A6_min_time_to_cook_P_pratas {
//    this is giving wrong ans
//    private static boolean is_possible(int p, int[] rank, int n, int min_time){
//        int total_pratas = 0;
//        for (int i = 0; i < n; i++){
////            num_prata indicates the pratas made by chef of rank[i] in time = min_time
//            int num_prata = 0;
//            int time = 0;
////            given time = min_time, calculate the number of pratas that the chef with a rank can make
//            while (time < min_time){
//                time += ++num_prata * rank[i];
//            }
////            due to one overflow(THIS IS THE SOURCE OF ERROR)
//            num_prata -= 1;
//            total_pratas += num_prata;
//        }
//        return total_pratas >= p;
//    }
private static boolean is_possible(int p, int[] rank, int n, int min_time){
    int total_pratas = 0;
    for (int i = 0; i < n; i++){
//   num_prata indicates the pratas made by chef of rank[i] in time = min_time
        int num_prata = 0;
        int time = 0;
        int time_per_prata = rank[i];
//            given time = min_time, calculate the number of pratas that the chef with a rank can make
        while (time + time_per_prata <= min_time){
            num_prata ++;
            time += time_per_prata;
            time_per_prata = rank[i] * (num_prata + 1);
        }
        total_pratas += num_prata;
    }
    return total_pratas >= p;
}
    public static int min_time(int p, int[] rank, int n){ //n =  rank.length
        int min_time = 0;
        Arrays.sort(rank);
        int s = 0;
        int e = rank[0] * ((p) * (p + 1)) / 2; // the maximum time will be when the fastest/ slowest cook makes all pratas alone
        while (s <= e){
            int mid = (s + e) / 2;
            if (is_possible(p, rank, n, mid)){
                min_time = mid;
//           dont stop, search for a even smaller min_time to finish making the pratas
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return min_time;
    }
    public static void main(String[] args) {
        int[] rank = {1,2,3,4};
        int p = 10;
        System.out.println(min_time(p,rank, rank.length));
    }
}
