package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class PlayerFunctions {
    public void addPlayer(Scanner scanner, AppData appData) {
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
    int rank = scanner.nextInt();
    PlayerModel player1 = new PlayerModel(position, name, number, age, score, rank);
    System.out.println("Available Teams:");
    for (int i = 0; i < appData.getTeamsList().size(); i++) {
        TeamModel team = appData.getTeamsList().get(i);
        System.out.println((i + 1) + ". " + team.getName());
    }
    System.out.print("Select Team (Enter team number): ");
    int teamNumber = scanner.nextInt();
    scanner.nextLine(); 
    if (teamNumber > 0 && teamNumber <= appData.getTeamsList().size()) {
        TeamModel selectedTeam = appData.getTeamsList().get(teamNumber - 1);
        player1.setTeam(selectedTeam);
        appData.getPlayersList().add(player1);
        System.out.println("Player added successfully.");
    } else {
        System.out.println("Invalid team selection. Player not added.");
    }
    if (player1.getTeam() != null) {
        player1.getTeam().getPlayers().add(player1);
    }
}
      public PlayerModel getPlayerByNumber(int playerNumber) {
    for (PlayerModel player :Egyptian_League_Project.appData.getPlayersList()) {
        if (player.getNumber() == playerNumber) {
            return player;
        }
    }
    return null; 
}
    public PlayerModel getPlayerByName(String playerName) {
    for (PlayerModel player :Egyptian_League_Project.appData.getPlayersList()) {
        if (player.getName().equalsIgnoreCase(playerName)) {
            return player;
        }
    }
    return null; 
}
    public ArrayList<PlayerModel> getPlayersByTeamName(String teamName) {
    ArrayList<PlayerModel> playersByTeam = new ArrayList<>();
    for (PlayerModel player : Egyptian_League_Project.appData.getPlayersList()) {
        if (player.getTeam().getName().equalsIgnoreCase(teamName)) {
            playersByTeam.add(player);
        }
    }
    return playersByTeam;
}
    public void updatePlayerInformation(String playerName, Scanner scanner) {
    for (PlayerModel player :Egyptian_League_Project.appData.getPlayersList()) {
        if (player.getName().equalsIgnoreCase(playerName)) {
            System.out.println("Enter the information you want to update:");
            System.out.println("1. Position");
            System.out.println("2. Number");
            System.out.println("3. Age");
            System.out.println("4. Score");
            System.out.println("5. Rank");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter new player position: ");
                    String newPlayerPosition = scanner.nextLine();
                    player.setPosition(newPlayerPosition);
                    break;
                case 2:
                    System.out.print("Enter new player number: ");
                    int newNumber = scanner.nextInt();
                    player.setNumber(newNumber);
                    break;
                case 3:
                    System.out.print("Enter new player age: ");
                    int newAge = scanner.nextInt();
                    player.setAge(newAge);
                    break;
                case 4:
                    System.out.print("Enter new player score: ");
                    int newScore = scanner.nextInt();
                    player.setScore(newScore);
                    break;
                case 5:
                    System.out.print("Enter new player rank: ");
                    int newRank = scanner.nextInt();
                    player.setRank(newRank);
                    break;   
                default:
                    System.out.println("Invalid choice. No information updated.");
                    return;
            }
            System.out.println("Player information updated successfully.");
            return;
        }
    }
    System.out.println("player with name " + playerName + " not found. Update unsuccessful.");
}
    public double calculateAveragePlayerAge(ArrayList<PlayerModel> players) {
        double totalAge = 0;
        for (PlayerModel player : players) {
            totalAge += player.getAge();
        }
        if (!players.isEmpty()) {
            return totalAge / players.size();
        } else {
            return 0;
        }
    } 
}