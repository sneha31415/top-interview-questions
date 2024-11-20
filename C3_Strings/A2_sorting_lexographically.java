package C3_Strings;

import java.util.*;

public class A2_sorting_lexographically {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        int n = sc.nextInt();
        sc.nextLine(); //because enter is acting as an input to the for loop scanner, so we need to have this
//        The sc.nextLine() is used immediately after sc.nextInt() to consume the rest of the line that contains the integer input
        for (int i = 0; i < n; i++){
            input.add(sc.nextLine());
        }
        for (String e : input){
            System.out.println(e);
        }
        Collections.sort(input, (a,b) -> (a.length() - b.length()));
        for (String e : input){
            System.out.println(e);
        }

//      2 condition sorting , i.e first by length and the lexographically
        String[] input2 = {"sneha", "aarti", "shubham", "boy", "girli"};
        Arrays.sort(input2, (a,b) -> {
            if (a.length() != b.length()){
                return a.length() - b.length();
            }
            else{
                return a.compareTo(b);
            }
                });
        for (String e : input2){
            System.out.println(e);
        }
    }
}
