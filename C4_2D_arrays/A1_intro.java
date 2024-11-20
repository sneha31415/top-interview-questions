package C4_2D_arrays;

import java.util.*;

public class A1_intro {
    public static void main(String[] args) {
        Set<int[]> subs = new HashSet<>();
        subs.add(new int[]{1, 2,2});
        subs.add(new int[]{1, 2,2});
        for (int[] sunset : subs) {
            System.out.println(Arrays.toString(sunset));
        }
        System.out.println(subs.contains(new int[]{1, 2,2}));

        int [][] input = new int[100][100];
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int val = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                input[i][j] = ++val;
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }


    }
}
