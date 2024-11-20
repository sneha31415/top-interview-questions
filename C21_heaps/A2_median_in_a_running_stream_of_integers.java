package C21_heaps;
import java.util.*;
public class A2_median_in_a_running_stream_of_integers {
    public static List<Double   > median_in_a_running_stream_of_integers(int[] nums) {
        List<Double> medians = new ArrayList<>();
//        maxheap
        PriorityQueue<Double> leftheap = new PriorityQueue<>((a, b) -> Double.compare(b , a));
//        min heap
        PriorityQueue<Double> rightheap = new PriorityQueue<>();

        double currMedian = Double.MAX_VALUE;
        for (int num : nums) {
//            num will go in left heap if its less than the currmedian
            if (num <= currMedian){
//                we cannot have (n + 2) elems in left and n elems in right
                if (leftheap.size() > rightheap.size()) {
                    rightheap.add(leftheap.poll());
                }
                leftheap.add((double)num);
            }
//            num will go in right heap if its grt than the currmedian
            else{
                if (rightheap.size() > leftheap.size()) {
                    leftheap.add(rightheap.poll());
                }
                rightheap.add((double)num);
            }

            // calculate the median after insertion
//            if left size is grt then number of elems are odd and the mid is the top of left heap
                if (leftheap.size() > rightheap.size()) {
                    currMedian = leftheap.peek();
                }
    //            if right size is grt then number of elems are odd and the mid is the top of right heap
                else if (leftheap.size() < rightheap.size()) {
                    currMedian = rightheap.peek();
                }else{
                    currMedian = (leftheap.peek() + rightheap.peek()) / 2;
                }
            medians.add(currMedian);
        }
        return medians;
    }
    public static void main(String[] args) {
        int[] nums = {1, 1, 5, 4, 3, 0};
        System.out.println(median_in_a_running_stream_of_integers(nums));
        int[] nums1 = {1, 2, 3};
        System.out.println(median_in_a_running_stream_of_integers(nums1));
    }
}
