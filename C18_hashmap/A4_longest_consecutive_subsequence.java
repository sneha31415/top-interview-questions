package C18_problem_solving_using_hashmap;

import java.util.*;

public class A4_longest_consecutive_subsequence {
    public static int longest_consecutive_subsequenc(int[] input_nums){
        HashMap<Integer, Integer> streaks = new HashMap<>();
        int maxstreak = 0;

        for (int idx = 0; idx < input_nums.length; idx++) {
            int num = input_nums[idx];

//            case 1: both sides of curr num are not in hashmap. So streak = 1
            if(!streaks.containsKey(num - 1) && !streaks.containsKey(num + 1)){
                streaks.put(num, 1);
                maxstreak = Math.max(maxstreak, 1);
            }

//            case2 : both sides are there, so update the leftmost and rightmost streak
//            eg 3 is to be added and curr hashmap is 1 2 _ 4 5 6
            else if(streaks.containsKey(num - 1) && streaks.containsKey(num + 1)){
                int leftstreak = streaks.get(num - 1);
                int rightstreak = streaks.get(num + 1);
                int streak = leftstreak + 1 + rightstreak;

//                update the streaks of the extremes
                streaks.put(num - leftstreak, streak);
                streaks.put(num + rightstreak, streak);
                maxstreak = Math.max(maxstreak, streak);
            }

            else if(streaks.containsKey(num - 1)){ // 4 is added to 2(2) 3(2) ---> 2(3) 3 4(3)
                int prev_streak = streaks.get(num - 1);
                streaks.put(num, prev_streak + 1);
                streaks.put(num - prev_streak , prev_streak + 1);
                maxstreak = Math.max(maxstreak, prev_streak + 1);
            }

            else{ // 4 is added to 5(3) 6 7(3) ---> 4(4) 5 6 7(4)
                int prev_streak = streaks.get(num + 1);
                streaks.put(num, prev_streak + 1);
                streaks.put(num + prev_streak, prev_streak + 1);
                maxstreak = Math.max(maxstreak, prev_streak + 1);
            }
        }

        return maxstreak;
    }
//    approach 2 very imp
    public static int longest_cons_sub_better(int[] input){
        HashSet<Integer> input_set = new HashSet<>();
        for(int num : input){
            input_set.add(num);
        }
        int longestStreak = 0;

        for (int num : input) {
//            check if num is a potential start of a streak
            if (!input_set.contains(num - 1)) {
                int curr_num = num;
                int currstreak = 1;

                // Extend the streak while the next consecutive number exists
                while (input_set.contains(curr_num + 1)) {
                    currstreak++;
                    curr_num++;
                }

                longestStreak = Math.max(longestStreak, currstreak);
            }
        }

        return longestStreak;
    }

//   VVVIMP: TC : the while loop runs for only O(n) time for all the elements across all iteration
//    TC = O(3N), N for set iteration, N for streak iteration and N for while loop
    public static void main(String[] args) {
            int[] input =  {14, 15, 1, 2,  9, 4, 3,0};
        System.out.println(longest_consecutive_subsequenc(input));
        System.out.println(longest_cons_sub_better(input));
    }
}
