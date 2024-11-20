package C2_character_arrays;

import java.util.Scanner;

public class A1_intro {
    public static void main(String[] args) {
//        The default behaviour is that the address of the first elem should be printed
//        but for char arrays this is a special behaviour

//        The character array gets printed with sout
        char[] c = {'a', 'b', 'c'};
        System.out.println(c);
//        The "address" of the first elem of the integer array is printed if we directly print the array
        int[] i = {1, 2, 3};
        System.out.println(i);

        String[] s = {"hello", "i", "am", "sneha"};
        System.out.println(s);
        Scanner sc = new Scanner(System.in);

//        System.out.println("enter name: ");
//        String name = sc.next();
//        System.out.println(name);
        System.out.println("enter full name");
        String fullname = sc.nextLine();
        System.out.println(fullname);

    }
}
