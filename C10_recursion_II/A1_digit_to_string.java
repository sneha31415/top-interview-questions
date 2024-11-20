    package C10_recursion_III;

    import java.util.HashMap;

    // 2048 = two zero four eight
    //approach -> first 204 ka answer recursion layega aur 8 ka hum
    public class A1_digit_to_string {
        public static String digit_to_string(int num){
    //        better approach is to make a string array where 0th index has value as "zero"
            HashMap<Integer, String> hmap = new HashMap<>();
            hmap.put(0, "zero");
            hmap.put(1, "one");
            hmap.put(2, "two");
            hmap.put(3, "three");
            hmap.put(4, "four");
            hmap.put(5, "five");
            hmap.put(6, "six");
            hmap.put(7, "seven");
            hmap.put(8, "eight");
            hmap.put(9, "nine");
            if(num <= 9){
                return hmap.get(num);
            }
    //        first divide the number into smaller part
            return digit_to_string(num / 10) + " " + hmap.get(num % 10);
        }

        public static void main(String[] args) {
            int num = 20670;
            System.out.println(digit_to_string(num));

        }
    }
