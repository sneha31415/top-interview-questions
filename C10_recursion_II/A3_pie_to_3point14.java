package C10_recursion_III;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

//given an array containing chars as xyzpitypi >> convert it to xyz3.14ty3.14
// do this inplace
public class A3_pie_to_3point14 {

//    type 1: using string as input
    public static void pi_to_3point14(StringBuilder s, int i){
        if (i + 1 > s.length()){
            return;
        }

        if (s.charAt(i) == 'p' && s.charAt(i + 1) == 'i'){
            s.replace(i,i+2, "3.14");
            pi_to_3point14(s, i + 2);
        }else{
//            just goto the next position
            pi_to_3point14(s, i + 1);
        }

    }

//    using character array as input
    public static void replacepi(char[] input, int i){
        if(input[i] == '\0' || input[i + 1] == '\0'){
            return;
        }
        if(input[i] == 'p' && input[i + 1] == 'i'){
            int j = i + 2;
            while (input[j + 1] != '\0'){
                j++;
            }
            while (j >= i + 2){
                input[j + 2] = input[j];
                j--;
            }
            input[i] = '3';
            input[i + 1] = '.';
            input[i + 2] = '1';
            input[i + 3] = '4';

            replacepi(input, i + 4);
        }else{
            replacepi(input, i + 1);
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("piscjepipind");
        pi_to_3point14(sb, 0);
        System.out.println(sb);
        char[] input = new char[100];
        String s = "piscjepipind";
        for(int i = 0; i < s.length(); i++){
            input[i] = s.charAt(i);
        }
        replacepi(input, 0);
        System.out.println(Arrays.toString(input));
    }
}
