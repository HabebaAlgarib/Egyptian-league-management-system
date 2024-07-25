package egyptian_league_project;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
public class TeamFunctions {
    public void addTeam(Scanner scanner, AppData appData) {
    System.out.println("Enter team information:");
    System.out.print("Team Name: ");
    String teamName = scanner.nextLine();
    System.out.print("Team ID: ");
    int teamId = scanner.nextInt();
    System.out.print("Enter the captain: ");
    String captain = scanner.nextLine();
    System.out.print("Total score: ");
    int totalScore = scanner.nextInt();
    TeamModel team1 = new TeamModel(teamName, teamId, new ArrayList<>(), captain, new ArrayList<>(), totalScore);
    appData.getTeamsList().add(team1);
    System.out.println("Team added successfully.");
    
}
     public TeamModel getTeamByName(String teamName) {
        for (TeamModel team :Egyptian_League_Project.appData.getTeamsList()) {
            if (team.getName().equalsIgnoreCase(teamName)) {
                return team;
                
            }
        }
        return null; 
    }
    public TeamModel getTeamById(int teamId){
      for(TeamModel team:Egyptian_League_Project.appData.getTeamsList()){
          if(team.getId()==teamId){
              return team;
          }
      }
      return null;
  } 
    public void displayTeamInfo(String teamName, AppData appData) {
    TeamModel team =getTeamByName(teamName);
    if (team != null) {
        System.out.println("********** Team Information **********");
        System.out.println("Team Name: " + team.getName());
        System.out.println("Team ID: " + team.getId());
        System.out.println("Captain: " + team.getCaptain());
    }
    }
     public void displayTeamInfoByName(String teamName, AppData appData){
    TeamModel team = getTeamByName(teamName);
    if (team != null) {
        System.out.println("********** Team Information **********");
        System.out.println("Team Name: " + team.getName());
        System.out.println("Team ID: " + team.getId());
        System.out.println("Captain: " + team.getCaptain());
        ArrayList<PlayerModel> playersList = team.getPlayers();
        
        if (playersList.isEmpty()) {
            System.out.println("No players in this team.");
        } else {
            for (PlayerModel player : playersList) {
                System.out.println("Player Name: " + player.getName());
            }
        }
    } else {
        System.out.println("Team not found.");
    }
     System.out.println("\n********** Matches for Team **********");
        for (MatcheModel match :Egyptian_League_Project.matcheFunctions.getMatchesByTeam(team)) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Date: " + match.getDate());
            System.out.println("Opponent: " + (match.getTeam1().equals(team) ? match.getTeam2().getName() : match.getTeam1().getName()));
           
    }
       System.out.println("\n********** Team Score **********");
       System.out.println("Total Score: " + team.getTotalScore());
}
    public void displayTeamInfoByID(int id, AppData appData){
    TeamModel team =getTeamById(id);
    if (team != null) {
        System.out.println("********** Team Information **********");
        System.out.println("Team Name: " + team.getName());
        System.out.println("Team ID: " + team.getId());
        System.out.println("Captain: " + team.getCaptain());
        ArrayList<PlayerModel> playersList = team.getPlayers();
        
        if (playersList.isEmpty()) {
            System.out.println("No players in this team.");
        } else {
            for (PlayerModel player : playersList) {
                System.out.println("Player Name: " + player.getName());
            }
        }
    } else {
        System.out.println("Team not found.");
    }
     System.out.println("\n********** Matches for Team **********");
        for (MatcheModel match :Egyptian_League_Project.matcheFunctions.getMatchesByTeam(team)) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Date: " + match.getDate());
            System.out.println("Opponent: " + (match.getTeam1().equals(team) ? match.getTeam2().getName() : match.getTeam1().getName()));
           
    }
       System.out.println("\n********** Team Score **********");
        System.out.println("Total Score: " + team.getTotalScore());
}
    public void displayTeamScore(String teamName, AppData appData){
        TeamModel team = getTeamByName(teamName);
         if (team != null){
        System.out.println("\n********** Team Score **********");
        System.out.println("Total Score: " + team.getTotalScore());
    } else {
        System.out.println("Team not found.");
    }}
    public void displayTeamMatches(String teamName, AppData appData){
        TeamModel team =getTeamByName(teamName);
         if (team != null){
        System.out.println("\n********** Matches for Team **********");
        for (MatcheModel match :Egyptian_League_Project.matcheFunctions.getMatchesByTeam(team)) {
            System.out.println("Match ID: " + match.getId());
            System.out.println("Date: " + match.getDate());
            System.out.println("Opponent: " + (match.getTeam1().equals(team) ? match.getTeam2().getName() : match.getTeam1().getName()));
            System.out.println();
        }}}
    public  void displayTeamPlayer(String teamName, AppData appData) {
    TeamModel team =getTeamByName(teamName);
    if (team != null) {
        System.out.println("\n********** Players in " + teamName + " **********");
        ArrayList<PlayerModel> playersList = team.getPlayers();
        
        if (playersList.isEmpty()) {
            System.out.println("No players in this team.");
        } else {
            for (PlayerModel player : playersList) {
                System.out.println("Player Name: " + player.getName());
            }
        }
    } else {
        System.out.println("Team not found.");
    }
}    
    public void displayTeamsOrderedByAverageAge(AppData appData) {
       ArrayList<TeamModel> teams = appData.getTeamsList();
        teams.sort(Comparator.comparingDouble(team -> Egyptian_League_Project.playerFunctions.calculateAveragePlayerAge(team.getPlayers())));
        System.out.println("Teams ordered by average players age :");
        for (int i = teams.size() - 1; i >= 0; i--) {
            TeamModel team = teams.get(i);
            double averageAge =Egyptian_League_Project.playerFunctions.calculateAveragePlayerAge(team.getPlayers());
            System.out.println(team.getName() + ": " + averageAge);
        }
    } 
    public void displayTeamsOrderedByTotalScoreAsc(AppData appData) {
        ArrayList<TeamModel> teams = appData.getTeamsList();
        teams.sort(Comparator.comparingInt(TeamModel::getTotalScore));
        System.out.println("Teams ordered by no of scored goals:");
        for (int i = teams.size() - 1; i >= 0; i--) {
            TeamModel team = teams.get(i);
            System.out.println(team.getName() + ": " + team.getTotalScore());
        }
    }
   
   
    public void updateTeamInformation(int teamId, Scanner scanner) {
    for (TeamModel team :Egyptian_League_Project.appData.getTeamsList()) {
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