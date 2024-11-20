package C1_arrays;

import java.util.ArrayList;
import java.util.List;

public class A8_functions_as_params {

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        temp.add(13);
        temp.add(14);
        temp.forEach(e -> System.out.print(e) );
        System.out.println();
        temp.forEach(System.out::print);
    }
}
