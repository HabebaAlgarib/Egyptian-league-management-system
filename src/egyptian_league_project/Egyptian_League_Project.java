package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class Egyptian_League_Project {
    public static void main(String[] args) {
     AppData appData = new AppData();
     Scanner scanner = new Scanner(System.in);
        System.out.println("***********************Welcome In Egyptian League************************\n");
        boolean exit = false;
        while (!exit){
                System.out.println("If You Want To Deal With");
                System.out.println("*************************************");
                System.out.println("Player        Enter 1");
                System.out.println("Match         Enter 2");
                System.out.println("Team          Enter 3");
                System.out.println("*************************************");
                int answer = scanner.nextInt();
                scanner.nextLine();
       switch(answer){
           case 1:
              System.out.println("Enter Player information  Enter 1");
              System.out.println("Display Player information  Enter 2");
              System.out.println("Display Player role with description  Enter 3");
              System.out.println("Update Player information  Enter 4");
              System.out.println("Search for player using (Number ,Name ,Team) 5");
              System.out.println();
              int answer2 = scanner.nextInt();
              if(answer2==1){
              addPlayer(scanner,appData);
              System.out.println();
              }else if(answer2==2){
                  int i=1;
              for (Players player : appData.playersList) {
                  System.out.println("Player "+i);
                  player.displayInformation();
                  System.out.println();
                  i++;
        }
                  System.out.println();
              }
              break;
           case 2:
            System.out.println("Enter Matches information  Enter 1");
            System.out.println("Display All Matches with details  Enter 2");
            System.out.println("Display held matches and to be held matches 3");
            System.out.println("Update a certain match using ID 4");
               System.out.println();
            int answer3=scanner.nextInt();
            if(answer3==1){
                addMatch(scanner,appData);
                System.out.println();       
            }
            break;
           case 3:
            System.out.println("Enter Team information  Enter 1");
            System.out.println("Display Team information  Enter 2");  
            System.out.println("Update team information  Enter 3");
            System.out.println("Search for team using ID  Enter 4");
            System.out.println("Search for team using name  Enter 5");
            System.out.println("Display team players  Enter 6");
            System.out.println("Display team detailed scores Enter 7");
            System.out.println("Display team matches with all details  Enter 8");
            System.out.println("Display as held matches and to be held matches (by Date)  Enter 9");
               System.out.println();
            int answer4=scanner.nextInt();
            if(answer4==1){
                addTeam(scanner,appData);
                System.out.println();
                
            }
       }
      
    }}
    private static void addPlayer(Scanner scanner, AppData appData) {
    System.out.println("Enter player information:");
    System.out.print("Position: ");
    String position = scanner.next();
    System.out.print("Name: ");
    String name = scanner.next();
    System.out.print("Number: ");
    int number = scanner.nextInt();
    System.out.print("Age: ");
    int age = scanner.nextInt();
    System.out.print("Score: ");
    int score = scanner.nextInt();
    System.out.print("Rank: ");
    String rank = scanner.next();
    
    Players player1 = new Players(position, name, number, age, score, rank);
    
    System.out.println("Available Teams:");
    for (int i = 0; i < appData.teamsList.size(); i++) {
        Teams team = appData.teamsList.get(i);
        System.out.println((i + 1) + ". " + team.getName());
    }

    System.out.print("Select Team (Enter team number): ");
    int teamNumber = scanner.nextInt();
    scanner.nextLine(); // Consume newline character

    if (teamNumber > 0 && teamNumber <= appData.teamsList.size()) {
        Teams selectedTeam = appData.teamsList.get(teamNumber - 1);
        player1.setTeam(selectedTeam);
        appData.addPlayer(player1);
        System.out.println("Player added successfully.");
    } else {
        System.out.println("Invalid team selection. Player not added.");
    }
}
   
private static void addTeam(Scanner scanner, AppData appData) {
    System.out.println("Enter team information:");
    System.out.print("Team Name: ");
    String teamName = scanner.next();
    System.out.print("Team ID: ");
    int teamId = scanner.nextInt();
    System.out.print("Enter the captain: ");
    String captain = scanner.next();
    System.out.print("Total score: ");
    int totalScore = scanner.nextInt();

    Teams team1 = new Teams(teamName, teamId, new ArrayList<>(), captain, new ArrayList<>(), totalScore);
    appData.addTeam(team1);
}
   private static void addMatch(Scanner scanner, AppData appData) {
        System.out.print("Enter Match ID: ");
        int matchId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter Match Date: ");
        String matchDate = scanner.nextLine();
        System.out.print("Enter Team 1 Name: ");
        String team1Name = scanner.nextLine();
        Teams team1 = appData.getTeamByName(team1Name); // Retrieve the team object from the team name
        System.out.print("Enter Team 2 Name: ");
        String team2Name = scanner.nextLine();
        Teams team2 = appData.getTeamByName(team2Name); // Retrieve the team object from the team name
        System.out.print("Enter Football Referee Name: ");
        String referee = scanner.nextLine();
        System.out.print("Enter Stadium Name: ");
        String stadium = scanner.nextLine();
        Matches match = new Matches(matchId, matchDate, team1, team2, referee, stadium); // Assume initial score is 0-0
        appData.addMatch(match);
        System.out.println("Match added successfully.");
    }
}
