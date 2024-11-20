package C15_greedy_algos;
import java.util.*;
public class A2_busyMan {
//    problem : Given n activities with start and end time, find the max number of activites you can do
//    note : you cannot do more than one activity at a given time

//    greedy approach : The faster an activity finishes, the more time we will get for the upcoming activities
//    so do the least endTime wali activities first
    public static int maximumActivites(List<List<Integer>> startAndEndTimes){
//        sort as per "end times"
        Collections.sort(startAndEndTimes, (a, b) -> a.get(1) - b.get(1));
        int lastActivityEndTime = 0;
        int activities = 0;
        for (List<Integer> startAndEndTime : startAndEndTimes) {
            int startTime = startAndEndTime.get(0);
            int endTime = startAndEndTime.get(1);
            if (startTime >= lastActivityEndTime){
                activities++;
                lastActivityEndTime = endTime;
            }
        }
        return activities;
    }
    public static void main(String[] args) {

    }
}
