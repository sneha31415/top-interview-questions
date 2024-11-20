package C18_problem_solving_using_hashmap;

public class A4_minimum_window_substring {
    public static String minimum_window_substring(String s, String pattern){
        int slen = s.length(); // len of string
        int plen = pattern.length(); // len of pattern
        if(slen < plen) return "pattern length exceeded ";

        int[] FP = new int[256]; // pattern frequency map
        int[] FS = new int[256]; // string frequency map

//        fill the pattern frequency map. this will be fixed
        for(char ch : pattern.toCharArray()){
            FP[ch]++;
        }
        int min_len_window = Integer.MAX_VALUE;
        int cnt = 0;
        int left = 0, startIdx = -1; // for shrinking the window

//        check for validity
        for(int right = 0; right < slen; right++){
            char ch = s.charAt(right);
            FS[ch]++;
//            FP[ch] != 0 --> increase cnt only when the char is present in pattern
                if(FP[ch] != 0 && FS[ch] <= FP[ch]){
                    cnt++; //cnt denotes the number of chars from s that are matched
                }

//              we have found a valid window if cnt = plen
                if(cnt == plen){
//                  shrink the window till it is valid
                    while(FP[s.charAt(left)] == 0 || FS[s.charAt(left)] > FP[s.charAt(left)]){
                        FS[s.charAt(left)]--;
                        left++;
                    }
//                   update window size
                    int windowSize = right - left + 1;
                    if(windowSize < min_len_window){
                        min_len_window = windowSize;
                        startIdx = left;
                    }
                }
            }
//        when there is no window len in s that matches all chars of pattern
        if(startIdx == -1){
            return "no window found";
        }
        return s.substring(startIdx, startIdx + min_len_window);
    }


    public static void main(String[] args) {
        String s = "hellaloaoo";
        String pattern =  "loo"; //  >>> op = loao
        System.out.println(minimum_window_substring(s, pattern));
    }
}
