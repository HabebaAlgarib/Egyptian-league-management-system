package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class MatcheFunctions {
    public void addMatch(Scanner scanner, AppData appData) {
        System.out.print("Enter Match ID: ");
        int matchId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Match Date: ");
        String matchDate = scanner.nextLine();
        System.out.print("Enter Team 1 Name: ");
        String team1Name = scanner.nextLine();
        TeamModel team1 = Egyptian_League_Project.teamFunctions.getTeamByName(team1Name); 
        System.out.print("Enter Team 2 Name: ");
        String team2Name = scanner.nextLine();
        TeamModel team2 = Egyptian_League_Project.teamFunctions.getTeamByName(team2Name); 
        System.out.print("Enter Football Referee Name: ");
        String referee = scanner.nextLine();
        System.out.print("Enter Stadium Name: ");
        String stadium = scanner.nextLine();
        MatcheModel match = new MatcheModel(matchId, matchDate, team1, team2, referee, stadium); 
        appData.getMatchesList().add(match);
        System.out.println("Match added successfully.");
    }
     public MatcheModel getMatchById(int id) {
    for (MatcheModel match :Egyptian_League_Project.appData.getMatchesList()) {
        if (match.getId() == id) {
            return match;
        }
    }
    return null;
}
    public void displayAllMatches(AppData appData) {
    for (MatcheModel match : appData.getMatchesList()) {
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
    public void updateMatchById(int matchId, Scanner scanner) {
    boolean matchFound = false;
    for (MatcheModel match :Egyptian_League_Project.appData.getMatchesList()) {
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
    public ArrayList<MatcheModel> getMatchesByTeam(TeamModel team) {
        ArrayList<MatcheModel> teamMatches = new ArrayList<>();
        
        for (MatcheModel match :Egyptian_League_Project.appData.getMatchesList()) {
            if (match.getTeam1().equals(team) || match.getTeam2().equals(team)) {
                teamMatches.add(match);
            }
        }
        
        return teamMatches;
    }
    public void displayHeldMatches() {
    System.out.println("IDs of Held Matches:");
    for (MatcheModel match : Egyptian_League_Project.appData.getMatchesList()) {
        if (match.getStatus() != null && match.getStatus().equals("Held")) {
            System.out.println(match.getId()+"\n"+match.getTeam1().getName()+"    VS   "+match.getTeam2().getName());
        }
    }
}
}