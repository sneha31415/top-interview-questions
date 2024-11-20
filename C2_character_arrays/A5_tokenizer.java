package C2_character_arrays;

public class A5_tokenizer {
    public static void main(String[] args) {
        String s = "i m having   a mango shake";
        String[] tokens = s.split(" ");
        for (String token : tokens){
            System.out.print(token + ",");
        }
    }
}
