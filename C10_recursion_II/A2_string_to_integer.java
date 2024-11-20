package C10_recursion_III;

//given "1045" , convert that to 1045
// approach =(BREAK THE PROBLEM INTO TWO PARTS)- let recursion bring smallans = 104, then you do (smallans * 10) + 5
public class A2_string_to_integer {
    public static int str_to_int(String s){
        if(s.length() == 0){
            return 0;
        }
        int last_digit = s.charAt(s.length() - 1) - '0';
        return (str_to_int(s.substring(0, s.length() - 1)) * 10) + last_digit;
    }
    public static void main(String[] args) {
        System.out.println(str_to_int("2344"));
    }
}
