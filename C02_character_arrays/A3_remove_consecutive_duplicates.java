package C2_character_arrays;
//remove consecutive_duplicates from the given character array.
// cccoodding => coding
// Do this in place
public class A3_remove_consecutive_duplicates {
    public static void remove_duplicates(char[] input){
        int n = input.length;
        if (n == 1 || n == 0){
            return;
        }
        int prev = 0;
        int curr = 0;
        while (curr < n){
            if (input[prev] == input[curr]){
                curr++;
            }
            else{
                input[++prev] = input[curr];
            }
        }
    }
    public static void removeDuplicates(char[] input) {
        int prev = 0, n = input.length;
        for (int curr = 0; curr < n; curr++) {
            if (input[curr] != input[prev]) {
                input[++prev]  = input[curr];
            }
        }
    }
    public static void main(String[] args) {
        char[] input = {'a','a','a','d','z','z'};
        remove_duplicates(input);
        System.out.println(input);
        char[] input2 = {'a','a','a','d','z','z'};
        removeDuplicates(input2);
        System.out.println(input2);
    }
}
