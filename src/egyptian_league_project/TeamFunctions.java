package egyptian_league_project;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class TeamFunctions {
    public static void addTeam(Scanner scanner, AppData appData) {
    System.out.println("Enter team information:");
    System.out.print("Team Name: ");
    String teamName = scanner.nextLine();
    System.out.print("Team ID: ");
    int teamId = scanner.nextInt();
    System.out.print("Enter the captain: ");
    String captain = scanner.nextLine();
    System.out.print("Total score: ");
    int totalScore = scanner.nextInt();
    Teams team1 = new Teams(teamName, teamId, new ArrayList<>(), captain, new ArrayList<>(), totalScore);
    appData.teamsList.add(team1);
    System.out.println("Team added successfully.");
    
}
    public static void displayTeamsOrderedByAverageAge(AppData appData) {
       ArrayList<Teams> teams = appData.teamsList;
        teams.sort(Comparator.comparingDouble(team -> PlayerFunctions.calculateAveragePlayerAge(team.getPlayers())));
        System.out.println("Teams ordered by average player age in reverse order:");
        for (int i = teams.size() - 1; i >= 0; i--) {
            Teams team = teams.get(i);
            double averageAge =PlayerFunctions.calculateAveragePlayerAge(team.getPlayers());
            System.out.println(team.getName() + ": " + averageAge);
        }
    } 
    public static void displayTeamsOrderedByTotalScoreAsc(AppData appData) {
        ArrayList<Teams> teams = appData.teamsList;
        teams.sort(Comparator.comparingInt(Teams::getTotalScore));
        System.out.println("Teams ordered by no of scored goals:");
        for (int i = teams.size() - 1; i >= 0; i--) {
            Teams team = teams.get(i);
            System.out.println(team.getName() + ": " + team.getTotalScore());
        }
    }
    public static void displayTeamInfoByName(String teamName, AppData appData){
    Teams team = getTeamByName(teamName);
    if (team != null) {
        System.out.println("********** Team Information **********");
        System.out.println("Team Name: " + team.getName());
        System.out.println("Team ID: " + team.getId());
        System.out.println("Captain: " + team.getCaptain());
        ArrayList<Players> playersList = team.getPlayers();
        
        if (playersList.isEmpty()) {
            System.out.println("No players in this team.");
        } else {
            for (Players player : playersList) {
                System.out.println("Player Name: " + player.getName());
            }
        }
    } else {
        System.out.println("Team not found.");
    }
     System.out.println("\n********** Matches for Team **********");
        for (Matches match : MatcheFunctions.getMatchesByTeam(team)) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Date: " + match.getDate());
            System.out.println("Opponent: " + (match.getTeam1().equals(team) ? match.getTeam2().getName() : match.getTeam1().getName()));
           
    }
       System.out.println("\n********** Team Score **********");
       System.out.println("Total Score: " + team.getTotalScore());
}
    public static  void displayTeamInfoByID(int id, AppData appData){
    Teams team =getTeamById(id);
    if (team != null) {
        System.out.println("********** Team Information **********");
        System.out.println("Team Name: " + team.getName());
        System.out.println("Team ID: " + team.getId());
        System.out.println("Captain: " + team.getCaptain());
        ArrayList<Players> playersList = team.getPlayers();
        
        if (playersList.isEmpty()) {
            System.out.println("No players in this team.");
        } else {
            for (Players player : playersList) {
                System.out.println("Player Name: " + player.getName());
            }
        }
    } else {
        System.out.println("Team not found.");
    }
     System.out.println("\n********** Matches for Team **********");
        for (Matches match : MatcheFunctions.getMatchesByTeam(team)) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Date: " + match.getDate());
            System.out.println("Opponent: " + (match.getTeam1().equals(team) ? match.getTeam2().getName() : match.getTeam1().getName()));
           
    }
       System.out.println("\n********** Team Score **********");
        System.out.println("Total Score: " + team.getTotalScore());
}
    public static  void displayTeamScore(String teamName, AppData appData){
        Teams team = getTeamByName(teamName);
         if (team != null){
        System.out.println("\n********** Team Score **********");
        System.out.println("Total Score: " + team.getTotalScore());
    } else {
        System.out.println("Team not found.");
    }}
    public static void displayTeamMatches(String teamName, AppData appData){
        Teams team =getTeamByName(teamName);
         if (team != null){
        System.out.println("\n********** Matches for Team **********");
        for (Matches match : MatcheFunctions.getMatchesByTeam(team)) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Date: " + match.getDate());
            System.out.println("Opponent: " + (match.getTeam1().equals(team) ? match.getTeam2().getName() : match.getTeam1().getName()));
        }}}
    public static  void displayTeamPlayer(String teamName, AppData appData) {
    Teams team =getTeamByName(teamName);
    if (team != null) {
        System.out.println("\n********** Players in " + teamName + " **********");
        ArrayList<Players> playersList = team.getPlayers();
        
        if (playersList.isEmpty()) {
            System.out.println("No players in this team.");
        } else {
            for (Players player : playersList) {
                System.out.println("Player Name: " + player.getName());
            }
        }
    } else {
        System.out.println("Team not found.");
    }
}
    public static void displayTeamInfo(String teamName, AppData appData) {
    Teams team =getTeamByName(teamName);
    if (team != null) {
        System.out.println("********** Team Information **********");
        System.out.println("Team Name: " + team.getName());
        System.out.println("Team ID: " + team.getId());
        System.out.println("Captain: " + team.getCaptain());
    }
    }
    public static  Teams getTeamByName(String teamName) {
        for (Teams team :Egyptian_League_Project.appData.teamsList) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team;
                
            }
        }
        return null; 
    }
    public static  Teams getTeamById(int teamId){
      for(Teams team:Egyptian_League_Project.appData.teamsList){
          if(team.getId()==teamId){
              return team;
          }
      }
      return null;
  } 
    public static void updateTeamInformation(int teamId, Scanner scanner) {
    for (Teams team :Egyptian_League_Project.appData.teamsList) {
        if (team.getId()== teamId) {
            System.out.println("Enter the information you want to update:");
            System.out.println("1. Team Name");
            System.out.println("2. Captain");
            System.out.println("3. Total Score");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter new Team Name: ");
                    String newTeamName = scanner.nextLine();
                    team.setName(newTeamName);
                    break;
                case 2:
                    System.out.print("Enter new Captain: ");
                    String newCaptain = scanner.nextLine();
                    team.setCaptain(newCaptain);
                    break;
                case 3:
                    System.out.print("Enter new Total Score: ");
                    int newTotalScore = scanner.nextInt();
                    team.setTotalScore(newTotalScore);
                    break;
                default:
                    System.out.println("Invalid choice. No information updated.");
                    return;
            }
            System.out.println("Team information updated successfully.");
            return;
        }
    }
    System.out.println("Team with ID " + teamId + " not found. Update unsuccessful.");
}
    
   
}
