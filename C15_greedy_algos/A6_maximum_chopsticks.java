package C15_greedy_algos;

import java.util.Arrays;

//problem statement : you are given an array of chopsticks length
// find the number of chopsticks pair you can make through these chopsticks such that the difference
// between the chopsticks length dont exceed maximumDifference in each pair
public class A6_maximum_chopsticks {
    public static int maximumChopstickPair(int[] chopsticksLength, int maximumDifference){
        Arrays.sort(chopsticksLength);
        int chopsticksPair = 0;
        for (int i = 0; i < chopsticksLength.length - 1; i++) {
            if (chopsticksLength[i + 1] - chopsticksLength[i] <= maximumDifference) {
                chopsticksPair++;
                i++;
            }
        }
        return chopsticksPair;
    }
    public static void main(String[] args) {
        int[] chopsticksLength = {1, 3, 3, 9, 4};
        System.out.println(maximumChopstickPair(chopsticksLength, 2));
    }
}
