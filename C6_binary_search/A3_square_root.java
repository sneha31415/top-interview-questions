package C6_binary_search;
import java.util.*;
//problem statement : return the square root (floor value) of the input number using BINARY search
// expected Tc = O(logn)
public class A3_square_root {
    public static float sqr_root(int n, int p){
        float sqr_root = -1;
//        left and right pointers
        int l = 0;
        int r = n;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (mid * mid == n){
                sqr_root = mid;
                break;
            }
            if (mid * mid < n){
                sqr_root =  mid;
//                dont stop the search
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
//        floating part
//        Brute force
//        p = precision
//        for 2.34 we go as 2.0 -> 2.1 -> 2.2 -> 2.3 now is p = 2 then we goto next step where :
//        2.3 -> 2.31 -> 2.32 -> 2.33 -> 2.34
        float inc = 0.1f;
        for (int precisionUpto = 1; precisionUpto <= p; precisionUpto++){
            while (sqr_root * sqr_root <= n){
                sqr_root += inc;
            }
//           since we overshoot the value
            sqr_root -= inc;
            inc /= 10;
        }
        return sqr_root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        System.out.println(sqr_root(n, p));
    }
}
