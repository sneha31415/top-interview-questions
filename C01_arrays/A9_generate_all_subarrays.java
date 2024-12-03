package C1_arrays;

import java.util.*;

public class A9_generate_all_subarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++){
            array.add(sc.nextInt());
        }

//        generating the subarrays
//        this requires 3 loops
        for(int i = 0; i < array.size(); i++){
            for(int j = i; j < array.size(); j++){
                for(int k = i; k <= j; k++){
                    System.out.print(array.get(k) + ",");
                }
                System.out.println();
            }
        }
    }
}
