package C10_recursion_II_implementation_based;
import java.util.*;

// recursive way to write linear search
public class A1_linear_search {
//    i denotes at what index we are currently working at
    public static int firstoccurance(int[] input, int target, int i){
        if (i >= input.length){
            return -1;
        }
        if (input[i] == target){
            return i;
        }
        return firstoccurance(input, target, i + 1);
    }

    public static int lastOccurance(int[] input, int target, int i){
        if (i >= input.length){
            return -1;

        }
//        first make a call
        int pos =  lastOccurance(input, target, i + 1);

//      if pos != -1, then stop updating it
        if (pos == -1 && input[i] == target){
            pos =  i;
        }
        return pos;
    }

//    print all occurances
    public static void printAllOccurances(int[] input, int target, int i){
        if(i == input.length){
            return;
        }
        if (input[i] == target){
            System.out.print(i + " ");
        }
        printAllOccurances(input, target, i + 1);
    }

    public static int storeAllOccurances(int[] input, int target, int i, List<Integer> output){
        int n = input.length;
        if (i == n){
            return 0;
        }
        if (input[i] == target){
            output.add(i);
             return 1 + storeAllOccurances(input, target, i + 1, output);
        }
        return storeAllOccurances(input, target, i + 1, output);
    }
    public static void main(String[] args) {
        int[] input = {2, 1, 0, 10, 5, 6, 9,-1, 0, 0};
        System.out.println(firstoccurance(input, 0,0));
        System.out.println(lastOccurance(input, 0,0));
        printAllOccurances(input, 0,0);

        List<Integer> output = new ArrayList<>();
        int count = storeAllOccurances(input, 0, 0, output);
        System.out.println(output);
        System.out.println("the count is " + count);
    }
}
