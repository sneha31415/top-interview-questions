package C15_greedy_algos;
import java.util.*;
public class A3_baised {
    static class Team{
        String name;
        int desiredRank;

        public Team(String name, int desiredRank) {
            this.name = name;
            this.desiredRank = desiredRank;
        }
    }

//    task is to assign the available rank closest to desired rank to each team
    public static int minimiseBadness(List<Team> teams) {
//        sort on the basis of ranks
        Collections.sort(teams, (teamA, teamB) -> teamA.desiredRank - teamB.desiredRank);
        int totalBadness = 0;
        int currRank = 1;
        for (Team team : teams) {
            int actualRank = team.desiredRank;
            int badness = Math.abs(actualRank - currRank);
            totalBadness += badness;
            currRank++;
        }
        return totalBadness;
    }

//    bucket / counting sort
    public static int minimiseBadness2(List<Team> teams) {
        int maxRank = teams.size();
        int[] bucket = new int[maxRank + 1];
//        create the bucket array
        for (Team team : teams) {
            int desiredRank = team.desiredRank;
            bucket[desiredRank]++;
        }
        int actualRank = 1;
        int totalBadness = 0;
        for (int rank = 1; rank <= maxRank; rank++) {
            while (bucket[rank] > 0) {
                int badness = Math.abs(rank - actualRank);
                totalBadness += badness;
                bucket[rank]--;
                actualRank++;
            }
        }
        return totalBadness;
    }

    public static void main(String[] args) {
        int[] desiredRanks = {1, 2, 2, 1, 5, 7, 7};
        int Numteams = desiredRanks.length;
        List<Team> teams = new ArrayList<>();
        for (int team = 0; team < Numteams; team++) {
            teams.add(new Team("A" + team, desiredRanks[team]));
        }
        System.out.println(minimiseBadness(teams));
        System.out.println(minimiseBadness2(teams));
    }
}

