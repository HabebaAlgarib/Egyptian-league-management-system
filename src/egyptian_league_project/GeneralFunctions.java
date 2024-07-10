package egyptian_league_project;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class GeneralFunctions {
   public static void displayTop3PlayersByRank() {
    ArrayList<Players> sortedPlayers = new ArrayList<>(Egyptian_League_Project.appData.playersList);
    Collections.sort(sortedPlayers, Comparator.comparingInt(Players::getRank).reversed());
    System.out.println("Top 3 Players by Rank:");
    int count = 1;
    for (Players player : sortedPlayers) {
        System.out.println("Rank " + player.getRank() + ": " + player.getName());
        count++;
        if (count > 3) {
            break;
        }
    }
}public static void displayTop3PlayersByGoals() {
    ArrayList<Players> sortedPlayers = new ArrayList<>(Egyptian_League_Project.appData.playersList);
    Collections.sort(sortedPlayers, Comparator.comparingInt(Players::getScore).reversed());
    System.out.println("Top 3 Players by Rank:");
    int count = 1;
    for (Players player : sortedPlayers) {
        System.out.println("Goal " + player.getScore()+ ": " + player.getName());
        count++;
        if (count > 3) {
            break;
        }
    }
}
   public static void displayTopThreeGoalkeepers() {
    ArrayList<Players> goalkeeperPlayers = new ArrayList<>();
    for (Players player :Egyptian_League_Project.appData.playersList) {
        if (player.getPosition().equalsIgnoreCase("goalkeeper")) {
            goalkeeperPlayers.add(player);
        }
    }
    goalkeeperPlayers.sort(Comparator.comparingInt(Players::getScore));
    if (!goalkeeperPlayers.isEmpty()) {
        System.out.println("Top 3 Goalkeepers:");
        int count = 0;
        for (Players goalkeeper : goalkeeperPlayers) {
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
   public static void displayGoalkeepersCleanSheet() {
    ArrayList<Players> cleanSheetGoalkeepers = new ArrayList<>();
    for (Players player :Egyptian_League_Project.appData.playersList) {
        if (player.getPosition().equalsIgnoreCase("goalkeeper") && player.getScore()== 0) {
            cleanSheetGoalkeepers.add(player);
        }
    }
    if (!cleanSheetGoalkeepers.isEmpty()) {
        System.out.println("Goalkeepers with Clean Sheet (Scored 0 goals):");
        for (Players goalkeeper : cleanSheetGoalkeepers) {
            System.out.println("Name: " + goalkeeper.getName());
        }
    } else {
        System.out.println("No goalkeepers found with a clean sheet (scored 0 goals).");
    }
}
   public static void displayMatchScheduledOn(String date) {
    boolean matchFound = false;
    for (Matches match :Egyptian_League_Project.appData.matchesList) {
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