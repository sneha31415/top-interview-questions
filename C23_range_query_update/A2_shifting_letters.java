// https://leetcode.com/problems/shifting-letters-ii/description/

public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diffArray = new int[n + 1];
        for (int[] shift : shifts) {
            int add = shift[2] == 0 ? -1 : 1;
            diffArray[shift[0]] += add;
            diffArray[shift[1] + 1] -= add;
        }

        // presum
        for (int i = 1; i - 1 < n; i++) {
            diffArray[i] += diffArray[i - 1]; 
        }
        // System.out.println(Arrays.toString(diffArray));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char)('a' + (s.charAt(i) - 'a' + diffArray[i] + 260000) % 26));
        }
        return sb.toString();
    }