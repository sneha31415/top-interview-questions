package C13_stacks;

import java.util.Arrays;
import java.util.Stack;
// int[] prices = {100, 80, 60, 70, 60, 75, 85};
// for each day calculate the diff between the day
public class A3_stock_span_problem {
    public static void stock_span(int[] prices, int n, int[] span){
        Stack<Integer> s = new Stack<>(); //indices of days
        s.push(0);
//        first day
        span[0] = 1;
        for (int i = 1; i < n; i++){
            span[i] = getspan(s, i, prices);
        }
    }
    private static int getspan(Stack<Integer> s, int i, int[] prices){
//        find the topmost elem that is bigger than the curr price
        while (!s.isEmpty() && prices[s.peek()] <= prices[i]) {
            s.pop();
        }

        int span;
        if (s.isEmpty()) {   // edge case when the curr price is greater than all prv prices
            span = i + 1;
        } else {
            span = i - s.peek();
        }
        s.push(i);
        return span;
    }
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int n = prices.length;
        int[] span = new int[n];
        stock_span(prices, n, span);
        System.out.println(Arrays.toString(span));
    }
}

// 100 80 60 -> 60 will be stopped by 80 and not 100. So we won't remove 80 from stack as its a potent stop
// 100 40 60 -> 60 will be stopped by 100 and not 40. So we will remove 40 as any new coming elem will be stopped by either 60 or 100
