package egyptian_league_project;
import java.util.ArrayList;
public class AppData {
    public ArrayList<Players> playersList;
    public ArrayList<Teams> teamsList;
    public ArrayList<Matches> matchesList;
    
     public AppData() {
        playersList = new ArrayList<>();
        teamsList = new ArrayList<>();
        matchesList = new ArrayList<>();
    }
    public void addPlayer(Players player) {
        playersList.add(player);
    }

    public void addTeam(Teams team) {
        teamsList.add(team);
    }

    public void addMatch(Matches match) {
        matchesList.add(match);
    }
     public Teams getTeamByName(String teamName) {
        for (Teams team : teamsList) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null; // Return null if team with specified name is not found
    }
}
