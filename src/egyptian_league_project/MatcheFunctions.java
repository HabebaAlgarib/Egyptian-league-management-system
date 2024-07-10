package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class MatcheFunctions {
    public static void addMatch(Scanner scanner, AppData appData) {
        System.out.print("Enter Match ID: ");
        int matchId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Match Date: ");
        String matchDate = scanner.nextLine();
        System.out.print("Enter Team 1 Name: ");
        String team1Name = scanner.nextLine();
        Teams team1 = TeamFunctions.getTeamByName(team1Name); 
        System.out.print("Enter Team 2 Name: ");
        String team2Name = scanner.nextLine();
        Teams team2 = TeamFunctions.getTeamByName(team2Name); 
        System.out.print("Enter Football Referee Name: ");
        String referee = scanner.nextLine();
        System.out.print("Enter Stadium Name: ");
        String stadium = scanner.nextLine();
        Matches match = new Matches(matchId, matchDate, team1, team2, referee, stadium); 
        appData.matchesList.add(match);
        System.out.println("Match added successfully.");
    }
    public static void displayAllMatches(AppData appData) {
    for (Matches match : appData.matchesList) {
            System.out.println();
            System.out.println("Match ID: " + match.getId());
            System.out.println("Date: " + match.getDate());
            System.out.println("Team 1: " + match.getTeam1().getName());
            System.out.println("Team 2: " + match.getTeam2().getName());
            System.out.println("Referee: " + match.getFootballReferee());
            System.out.println("Stadium: " + match.getStadiunName());
            System.out.println();
            
        }
    }
    public static Matches getMatchById(int id) {
    for (Matches match :Egyptian_League_Project.appData.matchesList) {
        if (match.getId() == id) {
            return match;
        }
    }
    return null;
}
    public static void updateMatchById(int matchId, Scanner scanner) {
    boolean matchFound = false;
    for (Matches match :Egyptian_League_Project.appData.matchesList) {
        if (match.getId()== matchId) {
            System.out.println("Match found with ID: " + matchId);
            System.out.println("Enter new match date: ");
            String newDate = scanner.next();
            if (!match.getDate().equals(newDate)) {
                match.setDate(newDate);
                match.setStatus("Held"); 
                System.out.println("Match date updated. Status changed to 'Held'.");
            } else {
                System.out.println("Match date remains the same. No need to update status.");
            }
            matchFound = true;
            break;
        }
    }
    if (!matchFound) {
        System.out.println("No match found with ID: " + matchId);
    }
}
    public static ArrayList<Matches> getMatchesByTeam(Teams team) {
        ArrayList<Matches> teamMatches = new ArrayList<>();
        
        for (Matches match :Egyptian_League_Project.appData.matchesList) {
            if (match.getTeam1().equals(team) || match.getTeam2().equals(team)) {
                teamMatches.add(match);
            }
        }
        
        return teamMatches;
    }
    public static void displayHeldMatches() {
    System.out.println("IDs of Held Matches:");
    for (Matches match : Egyptian_League_Project.appData.matchesList) {
        if (match.getStatus() != null && match.getStatus().equals("Held")) {
            System.out.println(match.getId()+"\n"+match.getTeam1().getName()+"    VS   "+match.getTeam2().getName());
        }
    }
}
}