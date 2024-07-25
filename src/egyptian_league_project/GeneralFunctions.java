package egyptian_league_project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class GeneralFunctions {
   public void displayTop3PlayersByRank() {
    ArrayList<PlayerModel> sortedPlayers = new ArrayList<>(Egyptian_League_Project.appData.getPlayersList());
    Collections.sort(sortedPlayers, Comparator.comparingInt(PlayerModel::getRank).reversed());
    System.out.println("Top 3 Players by Rank:");
    int count = 1;
    for (PlayerModel player : sortedPlayers) {
        System.out.println("Rank " + player.getRank() + ": " + player.getName());
        count++;
        if (count > 3) {
            break;
        }
    }
}public void displayTop3PlayersByGoals() {
    ArrayList<PlayerModel> sortedPlayers = new ArrayList<>(Egyptian_League_Project.appData.getPlayersList());
    Collections.sort(sortedPlayers, Comparator.comparingInt(PlayerModel::getScore).reversed());
    System.out.println("Top 3 Players by Goals:");
    int count = 1;
    for (PlayerModel player : sortedPlayers) {
        System.out.println("Goal " + player.getScore()+ ": " + player.getName());
        count++;
        if (count > 3) {
            break;
        }
    }
}
   public void displayTopThreeGoalkeepers() {
    ArrayList<PlayerModel> goalkeeperPlayers = new ArrayList<>();
    for (PlayerModel player :Egyptian_League_Project.appData.getPlayersList()) {
        if (player.getPosition().equalsIgnoreCase("goalkeeper")) {
            goalkeeperPlayers.add(player);
        }
    }
    goalkeeperPlayers.sort(Comparator.comparingInt(PlayerModel::getScore));
    if (!goalkeeperPlayers.isEmpty()) {
        System.out.println("Top 3 Goalkeepers:");
        int count = 0;
        for (PlayerModel goalkeeper : goalkeeperPlayers) {
            System.out.println("Name: " + goalkeeper.getName() + " - Goals Scored: " + goalkeeper.getScore());
            count++;
            if (count == 3) {
                break;
            }
        }
    } else {
        System.out.println("No goalkeeper players found.");
    }
}
   public void displayGoalkeepersCleanSheet() {
    ArrayList<PlayerModel> cleanSheetGoalkeepers = new ArrayList<>();
    for (PlayerModel player :Egyptian_League_Project.appData.getPlayersList()) {
        if (player.getPosition().equalsIgnoreCase("goalkeeper") && player.getScore()== 0) {
            cleanSheetGoalkeepers.add(player);
        }
    }
    if (!cleanSheetGoalkeepers.isEmpty()) {
        System.out.println("Goalkeepers with Clean Sheet (Scored 0 goals):");
        for (PlayerModel goalkeeper : cleanSheetGoalkeepers) {
            System.out.println("Name: " + goalkeeper.getName());
        }
    } else {
        System.out.println("No goalkeepers found with a clean sheet (scored 0 goals).");
    }
}
   public void displayMatchScheduledOn(String date) {
    boolean matchFound = false;
    for (MatcheModel match :Egyptian_League_Project.appData.getMatchesList()) {
        if (match.getDate().equals(date)) {
            System.out.println("Match scheduled on " + date + ":");
            System.out.println("Team 1: " + match.getTeam1().getName() + "   -VS-   Team 2: " + match.getTeam2().getName());
            System.out.println("Football Referee: " + match.getFootballReferee());
            System.out.println("Stadium Name: " + match.getStadiunName());
            matchFound = true;
        }
    }
    if (!matchFound) {
        System.out.println("No matches scheduled on " + date + ".");
    }
}
}