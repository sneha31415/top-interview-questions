package C21_heaps;

import java.util.*;

public class A1_minimiseCostToJoinAllRopes {
    public static int minimiseCostToJoinAllRopes(List<Integer> lengthOfRopes) {
        if (lengthOfRopes.size() == 0) return -1;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.addAll(lengthOfRopes);

//        if there is just one rope, no need to join it, thus cost is 0
        int totalCost = 0;
        while (heap.size() > 1) {
            int smallestRope = heap.poll();
            int secondSmallestRope = heap.poll();
//            join the two smallestrope
            int cost = smallestRope + secondSmallestRope;
            totalCost += cost;
//            add the newly created rope in minheap
            heap.add(cost);
        }
        return totalCost;
    }
    public static void main(String[] args) {
        List<Integer> lengths = new ArrayList<>();
        Collections.addAll(lengths, 4, 3, 2, 6);
        System.out.println(minimiseCostToJoinAllRopes(lengths));

//        heap-> 2 3 4 6 totalcost = 0
//        heap -> 4 5 6 totalcost = 4
//        heap => 9 6 totalcost => 4 + 9
//        heap => 15 totalcost => 4 + 9 + 15
    }
}
