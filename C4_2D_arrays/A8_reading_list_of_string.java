package C4_2D_arrays;
import java.util.*;

public class A8_reading_list_of_string {
    public static void main(String[] args) {
//        read a list of string as an input and store them in an array
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        for (int i = 0; i < n; i++){
            input[i] = sc.next();
        }
        System.out.println(Arrays.asList(input));
        System.out.println(Arrays.toString(input));
    }
}
