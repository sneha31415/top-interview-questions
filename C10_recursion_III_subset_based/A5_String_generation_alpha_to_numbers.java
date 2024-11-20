package C10_recursion_IV_subset_based;


public class A5_String_generation_alpha_to_numbers {
//    input = "123". generate all possible charcter matches. example 1->a , 2->b, 3->c makes "abc". another way is 12->l, 3->c makes "lc"
    static char[] alpha = {'\0', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
//    no need to make alpha array, bcuz char can be generated as (num + 'a' - 1) where num is from ( 1 to 26)
    public static void string_generation(char[] input, char[] out, int i , int j){
        if(i == input.length){
            System.out.println(out);
            return;
        }
//        two options
//        choose one digit at a time
        int digit = input[i] - '0';
        if(digit != 0) {
            out[j] = alpha[digit];
            string_generation(input, out, i + 1, j + 1);
            out[j] = '\0'; // this step is important here as if abc => aw jana hai then last 'c' must be cleared
        }

//        choose two digit at a time
        if(i + 1 < input.length) {
            int num = (digit * 10) + (input[i + 1] - '0');
            if(digit != 0 && num <= 26 && num > 0) {
                out[j] = alpha[num];
                string_generation(input, out, i + 2, j + 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        string_generation("03".toCharArray(), new char[10], 0, 0);
        string_generation("203".toCharArray(), new char[10], 0, 0);
    }
}
