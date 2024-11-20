package C4_2D_arrays;
import java.util.*;

public class A7_2d_char_arrays {
    public static void main(String[] args) {
        char[][] input = {{'a', 'b', 'c'}, {'s', 'n', 'e', 'h','a'}};
        System.out.println(Arrays.deepToString(input));
        int [] nums = {2,3,4};
        System.out.println(Arrays.toString(nums));
        StringBuilder sb = new StringBuilder();
        for (char[] row : input){
            for (char ch : row){
                sb.append(ch);
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }
}
