package C22_queue;

public class A1_firstNonRepeatingCharacterInRunningStream {
    public static void main(String[] args) {
        int ans = 0;
        for (int i = 1; i <= 20; i++) {
            ans ^= i;
            System.out.println(ans + " " + i);
        }
    }
}
