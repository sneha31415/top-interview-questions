package C11_more_sorting_techniques;

// given an  array of prices of houses and a budget b, find the maximum number of houses you can buy
// price of houses lies between (1 to 1000) dollar

// approach 1: sort the array of house prices and keep on buying the houses untill the budget is exhausted
// tc = O(nlogn) , Sc = O(1)
// approach 2: use bucket sort, maintain an freq array of house prices
// tc = O(n) , Sc = O(1000) = O(1)
public class A9_maximise_house {
    public static int maximum_houses(int[] prices, int budget){
        int[] freq = new int[1001];
        for (int i = 0; i < prices.length; i++){
            freq[prices[i]] ++;
        }

        int max_houses = 0;
        for (int i = 0; i < freq.length; i++){
            while(freq[i] > 0 && budget - i >= 0){
                max_houses++;
                budget -= i;
                freq[i] --;
            }
        }
        return max_houses;
    }

    public static void main(String[] args) {
        int[] prices = {20, 222, 11, 111, 200, 220, 200, 200, 20, 90};
        System.out.println(maximum_houses(prices, 31));
    }

}
