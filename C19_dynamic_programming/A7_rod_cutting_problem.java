package C19_dynamic_programming;


// an array containing the prices of rod as per the length is given. Cut the rod into pieces such that the profit is maximised
public class A7_rod_cutting_problem {
    public static int rod_cutting_problem(int len, int[] lenPrices){
        if (len == 0){
            return 0;
        }

        int ans = Integer.MIN_VALUE;

        for (int cut = 1; cut <= len; cut++){
            ans = Math.max(ans, lenPrices[cut] + rod_cutting_problem(len - cut, lenPrices));
        }
        return ans;
    }

//    -------------top down---------------
    public static int topDown(int len, int[] lenPrices, int[] dp){
//        price of a zero length rod is 0
        if (len == 0){
            return 0;
        }

        if (dp[len] != 0) return dp[len];

        int ans = Integer.MIN_VALUE;
        for (int cut = 1; cut <= len; cut++){
            ans = Math.max(ans, lenPrices[cut] + topDown(len - cut, lenPrices, dp));
        }
        return dp[len] = ans;
    }

//    ---------------bottom up----------------
    public static int bottomUp(int len, int[] lenPrices){
        int[] dp = new int[len + 1];
        for (int i = 1; i <= len; i++){
//            the case that entire rod is cut(ie whole rod is retained) is handled where cut = i
            for (int cut = 1; cut <= i; cut++){
                dp[i] = Math.max(dp[i], dp[i - cut] + lenPrices[cut]);
            }
        }
        return dp[len];
    }
    public static void main(String[] args) {
        int len = 8;
//        price of 0 len rod is 0, 1 len is 1, 2 len is 5, 3 len is 8.....
        int[] lenPrices = {0, 1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rod_cutting_problem(len,lenPrices));

        int[] dp = new int[len + 1];
        System.out.println(topDown(len, lenPrices, dp));
        System.out.println(bottomUp(len, lenPrices));
    }
}
