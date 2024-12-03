package C3_Strings;

import java.util.*;
//lexgraphically 091 < 11 but numerically 091 > 11
// Question -
// 12 13 32  12
// 23 023 111 11
// 21 4  3   2 key = 2 , reverse = false, lexo = true
//ans = 23  023  111 11
//      12  13   32  12
//      21  4    3   2

// key represents the columm number. Based on the elems in the column num, sort the values

public class A3_custom_sorting_imp {

//    this function will return the key^th column token from the string
//    example: key = 2 , str = "1 22 11 89 22" , then the function should return "22"
    public static String extractStringAtKey(String str, int key){
        return str.split(" ")[key - 1]; //key starts from 1 while indexing starts from 0
    }
    public static void custom_sort(List<String> input, int key, boolean reverse, boolean lexographically){
//
        if (lexographically){
            if(reverse){
                Collections.sort(input, (a, b) -> extractStringAtKey(b,key).compareTo(extractStringAtKey(a,key)));
            }
            else{
                Collections.sort(input, (a, b) -> extractStringAtKey(a,key).compareTo(extractStringAtKey(b,key)));
            }
        }
        else{
            if (reverse){
                Collections.sort(input, (a, b) -> Integer.valueOf(extractStringAtKey(b,key)) - Integer.valueOf((extractStringAtKey(a,key))));
            }
            else{
                Collections.sort(input, (a, b) -> Integer.valueOf(extractStringAtKey(a,key)) - Integer.valueOf((extractStringAtKey(b,key))));
            }

        }
    }
    public static void main(String[] args) {
//        input format =
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine(); //consume the new line
        List<String> input= new ArrayList<>();
        for (int i = 0; i < n; i++){
            input.add(sc.nextLine());
        }
//        int key = sc.nextInt();
//        sc.nextLine();
//        boolean reverse = sc.nextBoolean();
//        sc.nextLine();
//        boolean lexo = sc.nextBoolean();
        custom_sort(input, 3, true, false);
        for (var e : input){
            System.out.println(e);
        }

     }
}
