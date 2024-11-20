package C10_recursion_II_implementation_based;

public class lastOccurance {

//    start searching from back
    public static int lastOccurance(int[] input, int currIdx, int target) {
        if (currIdx < 0) {
            System.out.println("elem not found");
            return -1;
        }
        if (input[currIdx] == target) {
            return currIdx;
        }
        return lastOccurance(input, currIdx - 1, target);
    }
    public static void main(String[] args) {
        int[] input = {2, 1, 0, 10, 5, 6, 9,-1, 1, 0, 0};
        System.out.println(lastOccurance(input, input.length - 1,  1));
    }
}
