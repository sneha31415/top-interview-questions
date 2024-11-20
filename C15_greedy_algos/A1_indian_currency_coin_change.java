package C15_greedy_algos;

public class A1_indian_currency_coin_change {
    public static int coinChange (int money, int[] changes) {
        int coinChanges = 0;
        while (money > 0) {
            int nearestChange = findNearestChange(money, changes);
            coinChanges++;
            money -= nearestChange;
        }
        return coinChanges;
    }

//    binary search on changes[] array to find the nearest change smaller than money
    private static int findNearestChange(int money, int[] changes) {
        int n = changes.length;
        int start = 0;
        int end = n - 1;
        int nearestChange = 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (changes[mid] <= money) {
                nearestChange = Math.max(nearestChange, changes[mid]);
//                search for a bigger possible value
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return nearestChange;
    }
    public static void main(String[] args) {
        int[] indianCurrency = {1, 2, 3, 5, 10, 20, 50, 100, 200, 500, 1000, 2000};
        int money = 19;
        System.out.println(coinChange(money, indianCurrency));
    }
}
