package C11_more_sorting_techniques;

import java.util.Arrays;

public class A8_sort_strings {
    public static String get_key(String s, int key){
        String[] tokens = s.split(" ");
        return tokens[key - 1];
    }
    public static void sort_strings(String[] input, int key, boolean isLexo){
        if(isLexo) {
            Arrays.sort( input, (a, b) -> get_key(a, key).compareTo(get_key(b, key)) );
        }
        else{
            Arrays.sort( input, (a, b) -> Integer.valueOf(get_key(a, key)) - Integer.valueOf(get_key(b, key)) );
        }
    }
    public static void main(String[] args) {
        String[] input = {"51 22 31", "22 01 3", "44 342 01", "23 111 7", "23 12 21"};
        sort_strings(input, 2, false);
        System.out.println(Arrays.toString(input));

        String[] input_lexo_sort = {"51 22 31", "22 01 3", "44 342 01", "23 111 7", "23 12 21"};
        sort_strings(input_lexo_sort, 2, true);
        System.out.println(Arrays.toString(input_lexo_sort));
    }
}
