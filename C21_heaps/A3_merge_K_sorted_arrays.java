package C21_heaps;
import java.util.*;

public class A3_merge_K_sorted_arrays {

    static class Node{
        int value;
        int arrayIndex;
        int elemIndex;
        public Node(int value, int arrayIndex, int elemIndex){
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elemIndex = elemIndex;
        }
    }
    public static List<Integer> merge_K_sorted_arrays(List<List<Integer>> sortedArrays) {
//        min heap to store the smallest k elems
        PriorityQueue<Node> smallest_K_elements = new PriorityQueue<>((a, b) -> a.value - b.value);
        int numArrays = sortedArrays.size();

//        add the first element of each list in the min heap
        for (int i = 0; i < numArrays; i++) {
//            if the arrays can be empty, add a check here
            int value = sortedArrays.get(i).get(0);
            smallest_K_elements.add(new Node(value, i, 0));
        }

        List<Integer> sortedArray = new ArrayList<>();
        while (!smallest_K_elements.isEmpty()) {
            Node smallest = smallest_K_elements.poll();
            sortedArray.add(smallest.value);

            int elemIdx = smallest.elemIndex;
            int arrayIndx = smallest.arrayIndex;

//            add the next element of the smallestNode from the list
            if (elemIdx + 1 < sortedArrays.get(arrayIndx).size()) {
                int value = sortedArrays.get(arrayIndx).get(elemIdx + 1);
                smallest_K_elements.add(new Node(value,  arrayIndx, elemIdx + 1));
            }
        }
        return sortedArray;
     }

    public static void main(String[] args) {
        List<List<Integer>> sortedArrays = new ArrayList<>(Arrays.asList(
                    Arrays.asList(1, 4, 6, 10),
                    Arrays.asList(-1, 0, 5, 9),
                    Arrays.asList(2, 3, 4, 5, 10, 11)
        ));
        System.out.println(merge_K_sorted_arrays(sortedArrays));

       


    }
}
