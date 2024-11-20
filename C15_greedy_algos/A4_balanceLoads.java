package C15_greedy_algos;

public class A4_balanceLoads {
    public static int maximumRounds(int[] loads) {
        int loadPerCell = 0;
        int n = loads.length;
        for (int load : loads) {
            loadPerCell += load;
        }
//        equal load distribution is possible only if avg is an integer
        if (loadPerCell % n != 0) return -1;
        loadPerCell /= n;

        int rounds = 0;
        int runningLoadSum = 0;
        for (int i = 0; i < n; i++) {
//            make a boundry
            runningLoadSum += loads[i];
//            count the deficiency / extra. That will be the "atleast number of rounds" for that partition
            int atleastRounds = Math.abs(runningLoadSum - loadPerCell * (i + 1));
            rounds = Math.max(atleastRounds, rounds);
        }
        return rounds;
    }
    public static void main(String[] args) {
        int[] loads = {2, 4, 0, 6};
        System.out.println(maximumRounds(loads));
    }
    }
