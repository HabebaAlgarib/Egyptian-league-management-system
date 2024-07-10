package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class PlayerFunctions {
    public static void addPlayer(Scanner scanner, AppData appData) {
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
    Players player1 = new Players(position, name, number, age, score, rank);
    System.out.println("Available Teams:");
    for (int i = 0; i < appData.teamsList.size(); i++) {
        Teams team = appData.teamsList.get(i);
        System.out.println((i + 1) + ". " + team.getName());
    }
    System.out.print("Select Team (Enter team number): ");
    int teamNumber = scanner.nextInt();
    scanner.nextLine(); 
    if (teamNumber > 0 && teamNumber <= appData.teamsList.size()) {
        Teams selectedTeam = appData.teamsList.get(teamNumber - 1);
        player1.setTeam(selectedTeam);
        appData.playersList.add(player1);
        System.out.println("Player added successfully.");
    } else {
        System.out.println("Invalid team selection. Player not added.");
    }
    if (player1.getTeam() != null) {
        player1.getTeam().getPlayers().add(player1);
    }
}
    public static double calculateAveragePlayerAge(ArrayList<Players> players) {
        double totalAge = 0;
        for (Players player : players) {
            totalAge += player.getAge();
        }
        if (!players.isEmpty()) {
            return totalAge / players.size();
        } else {
            return 0;
        }
    }
    public static Players getPlayerByNumber(int playerNumber) {
    for (Players player :Egyptian_League_Project.appData.playersList) {
        if (player.getNumber() == playerNumber) {
            return player;
        }
    }
    return null; 
}
    public static Players getPlayerByName(String playerName) {
    for (Players player :Egyptian_League_Project.appData.playersList) {
        if (player.getName().equalsIgnoreCase(playerName)) {
            return player;
        }
    }
    return null; 
}
    public static ArrayList<Players> getPlayersByTeamName(String teamName) {
    ArrayList<Players> playersByTeam = new ArrayList<>();
    for (Players player : Egyptian_League_Project.appData.playersList) {
        if (player.getTeam().getName().equalsIgnoreCase(teamName)) {
            playersByTeam.add(player);
        }
    }
    return playersByTeam;
}
    public static void updatePlayerInformation(String playerName, Scanner scanner) {
    for (Players player :Egyptian_League_Project.appData.playersList) {
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
}