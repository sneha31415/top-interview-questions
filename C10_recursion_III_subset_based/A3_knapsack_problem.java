package C10_recursion_IV_subset_based;

public class A3_knapsack_problem {
    public static int knapsack(int capacity, int i , int[] weights, int[] prices){
        if(capacity == 0 || i == weights.length){
            return 0;
        }
//        two options
//        either include the curr weight
        int profit1 = Integer.MIN_VALUE;
        if (capacity - weights[i] >= 0) {
            profit1 = prices[i] + knapsack(capacity - weights[i], i + 1, weights, prices);
        }
//        don't include the curr weight
        int profit2 = knapsack(capacity, i + 1, weights, prices);
        return Math.max(profit1, profit2);
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30, 50};
        int[] prices = {100, 10, 20, 40};
        System.out.println(knapsack(40, 0, weights, prices));
    }
}
