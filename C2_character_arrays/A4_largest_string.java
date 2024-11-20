package C2_character_arrays;

import java.util.Scanner;

public class A4_largest_string {
    public static void main(String[] args) {
        String s;
        String largest_s = "";
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++){
            s = sc.nextLine();
            if(s.length() > largest_s.length()){
                    largest_s = s;
            }
        }
        System.out.println("the largest string is " + largest_s);
    }
}
