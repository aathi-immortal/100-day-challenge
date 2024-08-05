import java.util.ArrayList;
import java.util.List;

public class CourtSchedulingAlgo {
    public static void listMatches(int numTeams) {
        List<String> listTeam = new ArrayList<>();

        // Populate teams list
        for (int i = 1; i <= numTeams; i++) {
            listTeam.add("Team " + i);
        }

        // If odd number of teams, add a dummy
        if (numTeams % 2 != 0) {
            listTeam.add("Bye");
            numTeams++; // Increment numTeams to reflect the addition of the dummy team
        }

        int numDays = numTeams - 1; // Days needed to complete tournament
        int halfSize = numTeams / 2;

        List<String> teams = new ArrayList<>(listTeam);

        teams.remove(0); // Remove the first team

        int teamsSize = teams.size();

        for (int day = 0; day < numDays; day++) {
            System.out.println("Day " + (day + 1));

            int teamIdx = day % teamsSize;

            System.out.println(teams.get(teamIdx) + " vs " + listTeam.get(0));

            for (int idx = 1; idx < halfSize; idx++) {
                int firstTeam = (day + idx) % teamsSize;
                int secondTeam = (day + teamsSize - idx) % teamsSize;
                System.out.println(teams.get(firstTeam) + " vs " + teams.get(secondTeam));
            }
        }
    }

    public static void main(String[] args) {
        int numTeams = 5; // Change this to the desired number of teams
        listMatches(numTeams);
    }
}
