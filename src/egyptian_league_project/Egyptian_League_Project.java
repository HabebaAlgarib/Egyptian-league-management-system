package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class Egyptian_League_Project {
    static AppData appData = new AppData();
    static TeamFunctions teamFunctions =new  TeamFunctions ();
    static MatcheFunctions matcheFunctions =new MatcheFunctions();
    static PlayerFunctions playerFunctions=new PlayerFunctions();
    static GeneralFunctions generalFunctions=new GeneralFunctions();
    public static void main(String[] args) {
        appData.prepareData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("********Welcome In Egyptian League Management System*********\n");
        boolean exit = false;
        while (!exit) {
            System.out.println("If You Want To Deal With");
            System.out.println("*****************************************");
            System.out.println("Player        Enter 1");
            System.out.println("Match         Enter 2");
            System.out.println("Team          Enter 3");
            System.out.println("General Functions    Enter 4");
            System.out.println("Exiting program      Enter 5");
            System.out.println("*****************************************");
            System.out.println();
            String answer0 = scanner.next();
            if (answer0.equalsIgnoreCase("back")) continue;
            switch (answer0) {
                case "1":
                    boolean backFromPlayerMenu = false;
                    while (!backFromPlayerMenu) {
                        System.out.println();
                        System.out.println("1-Enter Player information  Enter 1");
                        System.out.println("2-Display Player information  Enter 2");
                        System.out.println("3-Update Player information  Enter 3");
                        System.out.println("4-Search for player using (Number, Name, Team) Enter 4");
                        System.out.println("*Type 'back' to go back to the main menu.");
                        System.out.println();
                        String answer1 = scanner.next();
                        if (answer1.equalsIgnoreCase("back")) {
                            backFromPlayerMenu = true;
                            continue;
                        }
                        handlePlayerOptions(answer1, scanner, appData);
                    }
                    break;
                case "2":
                    boolean backFromMatchMenu = false;
                    while (!backFromMatchMenu) {
                        System.out.println();
                        System.out.println("1-Enter Matches information  Enter 1");
                        System.out.println("2-Display All Matches with details  Enter 2");
                        System.out.println("3-Update a certain match using ID Enter 3");
                        System.out.println("4-Display held matches Enter 4");
                        System.out.println("*Type 'back' to go back to the main menu.");
                        System.out.println();
                        String answer2 = scanner.next();
                        if (answer2.equalsIgnoreCase("back")) {
                            backFromMatchMenu = true;
                            continue;
                        }
                        handleMatchOptions(answer2, scanner, appData);
                    }
                    break;
                case "3":
                    boolean backFromTeamMenu = false;
                    while (!backFromTeamMenu) {
                        System.out.println();
                        System.out.println("1-Enter Team information  Enter 1");
                        System.out.println("2-Display Team information  Enter 2");
                        System.out.println("3-Update team information  Enter 3");
                        System.out.println("4-Search for team using ID  Enter 4");
                        System.out.println("5-Search for team using name  Enter 5");
                        System.out.println("6-Display team players  Enter 6");
                        System.out.println("7-Display team detailed scores Enter 7");
                        System.out.println("8-Display team matches with all details  Enter 8");
                        System.out.println("*Type 'back' to go back to the main menu.");
                        System.out.println();
                        String answer3 = scanner.next();
                        if (answer3.equalsIgnoreCase("back")) {
                            backFromTeamMenu = true;
                            continue;
                        }
                        handleTeamOptions(answer3, scanner, appData);
                    }
                    break;
              case "4":
                boolean backFromGeneralFunctionMenu = false;
                    while (!backFromGeneralFunctionMenu) {
                        System.out.println();
                        System.out.println("1-Disply Top3 Players by Rank    Enter 1");
                        System.out.println("2-Disply Top3 who score the greatest no of goals    Enter 2");
                        System.out.println("3-Display Top3 Goalkeeper With Fewest Goals     Enter 3");
                        System.out.println("4-Display Goalkeeper With cleanSheet   Enter 4");
                        System.out.println("5-Display a match in a certain date   Enter 5");
                        System.out.println("6-Display teams ordered by the average ages of its players   Enter 6 ");
                        System.out.println("7-Display teams ordered by no of scored goals   Enter 7 ");
                        System.out.println("*Type 'back' to go back to the main menu.");
                        System.out.println();
                        String answer4 = scanner.next();
                        if (answer4.equalsIgnoreCase("back")) {
                            backFromGeneralFunctionMenu = true;
                            continue;
                        }
                    handleGeneralFunctionsOptions(answer4,scanner,appData);
                        
                    }
                    break;
              case "5":
                System.out.println("Exiting program...");
                System.exit(0);
                default:
                    System.out.println("Invalid input. Please enter 1, 2, 3, 4 or 5");
            }
        }
    }
    private static void handlePlayerOptions(String answer1, Scanner scanner, AppData appData) {
        switch (answer1) {
            case "1":
                playerFunctions.addPlayer(scanner, appData);
                break;
            case "2":
                int i = 1;
                for (PlayerModel player : appData.getPlayersList()) {
                    System.out.println("Player " + i);
                    player.displayInformation();
                    System.out.println();
                    i++;
                }
                break;
            case "3":
                System.out.print("Enter the player name to update information: ");
                String playerNameToUpdate = scanner.next();
                scanner.nextLine();
                playerFunctions.updatePlayerInformation(playerNameToUpdate, scanner);
                break;
            case "4":
                System.out.println("Enter the search way (number/name/team):");
                String searchWay = scanner.next();
                handlePlayerSearch(searchWay, scanner, appData);
                break;
            default:
                System.out.println("Invalid input. Please enter 1, 2, 3, or  4.");
        }
    }
    private static void handlePlayerSearch(String searchWay, Scanner scanner, AppData appData) {
    switch (searchWay) {
        case "number":
            System.out.println("Enter the player number:");
            int playerNumber = scanner.nextInt();
            PlayerModel searchedPlayerByNumber = playerFunctions.getPlayerByNumber(playerNumber);
            if (searchedPlayerByNumber != null) {
                searchedPlayerByNumber.displayInformation();
            } else {
                System.out.println("No player found with the number '" + playerNumber + "'.");
            }
            break;
        case "name":
            System.out.println("Enter the player name:");
            String playerName = scanner.next();
            PlayerModel searchedPlayerByName = playerFunctions.getPlayerByName(playerName);
            if (searchedPlayerByName != null) {
                searchedPlayerByName.displayInformation();
            } else {
                System.out.println("No player found with the name '" + playerName + "'.");
            }
            break;
        case "team":
            System.out.println("Enter the team name to search for players:");
            String teamName = scanner.next();
            ArrayList<PlayerModel> playersInTeam = playerFunctions.getPlayersByTeamName(teamName);
            if (!playersInTeam.isEmpty()) {
                System.out.println("Players found in team '" + teamName + "':");
                for (PlayerModel player : playersInTeam) {
                    player.displayInformation();
                    System.out.println();
                }
            } else {
                System.out.println("No players found in team '" + teamName + "'.");
            }
            break;
        default:
            System.out.println("Invalid search way. Please enter 'number', 'name', or 'team'.");
    }
}
    private static void handleMatchOptions(String answer2, Scanner scanner, AppData appData) {
        switch (answer2) {
            case "1":
                matcheFunctions.addMatch(scanner, appData);
                break;
            case "2":
                matcheFunctions.displayAllMatches(appData);
                break;
            case "3":
                System.out.println("Please enter Id of Match");
                int id = scanner.nextInt();
                matcheFunctions.updateMatchById(id, scanner);
                break;   
            case "4":
                matcheFunctions.displayHeldMatches();
                break;
            default:
                System.out.println("Invalid input. Please enter 1, 2, 3, or 4.");
        }
    }
    private static void handleTeamOptions(String answer3, Scanner scanner, AppData appData) {
        switch (answer3) {
            case "1":
                teamFunctions.addTeam(scanner, appData);
                break;
            case "2":
                System.out.println("Enter the team name:");
                String teamName = scanner.next();
                teamFunctions.displayTeamInfo(teamName, appData);
                break;
            case "3":
                System.out.print("Enter the team ID to update information: ");
                int teamIdToUpdate = scanner.nextInt();
                scanner.nextLine();
                teamFunctions.updateTeamInformation(teamIdToUpdate, scanner);
                break;
            case "4":
                System.out.println("Enter the team ID:");
                int teamId = scanner.nextInt();
                teamFunctions.displayTeamInfoByID(teamId, appData);
                break;
            case "5":
                System.out.println("Enter the team Name:");
                String teamName2 = scanner.next();
                teamFunctions.displayTeamInfoByName(teamName2, appData);
                break;
            case "6":
                System.out.println("Enter the team name:");
                String teamName3 = scanner.next();
                teamFunctions.displayTeamPlayer(teamName3, appData);
                break;
            case "7":
                System.out.println("Enter the team name:");
                String teamName4 = scanner.next();
                teamFunctions.displayTeamScore(teamName4, appData);
                break;
            case "8":
                System.out.println("Enter the team name:");
                String teamName5 = scanner.next();
                teamFunctions.displayTeamMatches(teamName5, appData);
                break;
            default:
                System.out.println("Invalid input. Please enter 1, 2, 3, 4, 5, 6, 7, or 8.");
        }
    }
    private static void handleGeneralFunctionsOptions(String answer4, Scanner scanner, AppData appData){
        switch(answer4){
                    case "1":
                    generalFunctions.displayTop3PlayersByRank();
                    break;
                    case "2":
                    generalFunctions.displayTop3PlayersByGoals();
                    break;
                    case "3":
                    generalFunctions.displayTopThreeGoalkeepers();
                    break;
                    case "4":
                    generalFunctions.displayGoalkeepersCleanSheet();
                    break;
                    case "5":
                    System.out.println("Enter the date ");
                    String date = scanner.next();
                    generalFunctions.displayMatchScheduledOn(date);
                    break;
                    case "6":
                    teamFunctions.displayTeamsOrderedByAverageAge(appData);
                    break;
                    case "7":
                    teamFunctions.displayTeamsOrderedByTotalScoreAsc(appData);
                    break;
                    default:
                    System.out.println("Invalid input. Please enter 1, 2, 3, 4, 5, 6, or 7.");
                    }
    }}