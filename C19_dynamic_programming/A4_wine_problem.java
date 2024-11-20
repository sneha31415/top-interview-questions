package C19_dynamic_programming;

public class A4_wine_problem {
//    -------------------recursive -------------------
    public static int maxProfit(int i, int j, int[] winesPrices, int year){
        if (i > j){
            return 0; // dont return int.MIN_VALUE else way1 / way2 = some positive + (minus infinity)
        }

//        consider taking wine from both sides ie front and back
        int way1 = (winesPrices[i] * year) + maxProfit(i + 1, j, winesPrices, year + 1);
        int way2 = (winesPrices[j] * year) + maxProfit(i, j - 1, winesPrices, year + 1);
        return Math.max(way1, way2);
    }
    
// ----------------top down approach----------------
    public static int topdown(int i, int j, int[] winesPrices, int year, int[][] dp){
//        base case : no bottles are left
        if (i > j){
            return 0;
        }
        if (dp[i][j] != 0) return dp[i][j];

//        consider taking wine from both sides
        int way1 = (winesPrices[i] * year) + topdown(i + 1, j, winesPrices, year + 1, dp);
        int way2 = (winesPrices[j] * year) + topdown(i, j - 1, winesPrices, year + 1, dp);
//        year can also be calculated as (n - (j - i))
        return dp[i][j] = Math.max(way1, way2);
    }


//    --------------------bottom up-----------------------
    public static int bottomUp(int[] winesPrices){
        int n = winesPrices.length;
        int [][] dp = new int[n][n];

//        traverse diagonally
        int i = 0, j = 0;
        while (dp[0][n - 1] == 0){
            int year = n - (j - i);
            if (i == j){
//                when i == j, we are in the last year, i.e one bottle left
                dp[i][j] = winesPrices[i] * year;
            }else{
//                consider selling the extreme first wine
                int way1 = winesPrices[i] * year + dp[i + 1][j];
//               consider selling the extreme last wine
                int way2 = winesPrices[j] * year + dp[i][j - 1];
//                get the max profit
                dp[i][j] = Math.max(way1, way2);
            }

//            move to next elem in diagonal
            i++;
            j++;

//          you have reached the end while traversing diagonally, goto a new diagonal
            if (j >= n){
                j = n - i + 1;
                i = 0;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        int[] winePrice = {2, 3, 5, 1, 4};
        int end = winePrice.length;
        System.out.println(maxProfit(0, end - 1 , winePrice, 1));

        int[][] dp = new int[end][end];
        System.out.println(topdown(0, end - 1 , winePrice, 1, dp));
        System.out.println(bottomUp(winePrice));

    }
}
