package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class AppData {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<PlayerModel> playersList;
    private ArrayList<TeamModel> teamsList;
    private ArrayList<MatcheModel> matchesList;
    public AppData() {
        playersList = new ArrayList<>();
        teamsList = new ArrayList<>();
        matchesList = new ArrayList<>();
    }
    public ArrayList<PlayerModel> getPlayersList() {
        return playersList;
    }
    public ArrayList<TeamModel> getTeamsList() {
        return teamsList;
    }
    public ArrayList<MatcheModel> getMatchesList() {
        return matchesList;
    }
    public void prepareData() {
  
    PlayerModel player1 = new PlayerModel("goalkeeper", "Mohamed_El_Shenawy", 8, 30, 8, 1);
    PlayerModel player2 = new PlayerModel("goalkeeper", "Allison", 10, 35, 0, 1);
    PlayerModel player3 = new PlayerModel("Forward", "Mohamed_Salah", 1, 32, 11, 2);
    PlayerModel player4 = new PlayerModel("Midfielder", "Mahmoud_Hassan_'Trezeguet'", 2, 29, 17, 3);
    PlayerModel player5 = new PlayerModel("Defender", "Ali_Gabr", 5, 24, 20, 4);
    PlayerModel player6 = new PlayerModel("Forward", "Ahmed_Ali", 7, 25, 15, 6);
    PlayerModel player7 = new PlayerModel("Midfielder", "Hussein_El-Shahat", 3, 32, 18, 5);
    PlayerModel player8 = new PlayerModel("Defender", "Ayman_Ashraf", 4, 33, 19, 7);
    PlayerModel player9 = new PlayerModel("Forward", "Ramadan_Sobhi", 6,27, 13, 8);
    PlayerModel player10 = new PlayerModel("Midfielder", "Tarek_Hamed", 9, 26, 14, 9);
    PlayerModel player11 = new PlayerModel("Defender", "Ahmed_Fathi", 11,39 , 22, 10);
    PlayerModel player12 = new PlayerModel("Forward", "Mohamed_Magdy", 12, 28, 16, 11);
    PlayerModel player13 = new PlayerModel("Midfielder", "Amr_Warda", 13, 30, 21, 12);
    
    playersList.add(player1);
    playersList.add(player2);
    playersList.add(player3);
    playersList.add(player4);
    playersList.add(player5);
    playersList.add(player6);
    playersList.add(player7);
    playersList.add(player8);
    playersList.add(player9);
    playersList.add(player10);
    playersList.add(player11);
    playersList.add(player12);
    playersList.add(player13);

    TeamModel team1 = new TeamModel("Al_Ahly", 1, new ArrayList<>(), "Pitso_Mosimane", new ArrayList<>(), 20);
    TeamModel team2 = new TeamModel("Zamalek", 2, new ArrayList<>(), "Jaime_Pacheco", new ArrayList<>(), 15);
    TeamModel team3 = new TeamModel("Pyramids", 3, new ArrayList<>(), "Rodolfo_Arruabarrena", new ArrayList<>(), 10);
    TeamModel team4 = new TeamModel("Ismaily", 4, new ArrayList<>(), "Ariel_Holan", new ArrayList<>(), 11);
    TeamModel team5 = new TeamModel("Wadi Degla", 5, new ArrayList<>(), "Ahmed Hossam 'Mido'", new ArrayList<>(), 18);
    TeamModel team6 = new TeamModel("Masry", 6, new ArrayList<>(), "Tarek Yehia", new ArrayList<>(), 0);

    teamsList.add(team1);
    teamsList.add(team2);
    teamsList.add(team3);
    teamsList.add(team4);
    teamsList.add(team5);
    teamsList.add(team6);
     
    player1.setTeam(team1);
    player2.setTeam(team2);
    player3.setTeam(team1);
    player4.setTeam(team3);
    player5.setTeam(team4);
    player6.setTeam(team2);
    player7.setTeam(team6);
    player8.setTeam(team6);
    player9.setTeam(team3);
    player10.setTeam(team4);
    player11.setTeam(team5);
    player12.setTeam(team5);
    player13.setTeam(team1);
    
    matchesList.add(new MatcheModel(1, "5/8/2024", team1, team2, "Hossam Ashour", "Cairo International Stadium"));
    matchesList.add(new MatcheModel(2, "4/1/2024", team3, team4, "Ali Maher", "30 June Stadium"));
    matchesList.add(new MatcheModel(3, "15/7/2024", team5, team6, "Ahmed Samy", "Petroleum Stadium"));
    matchesList.add(new MatcheModel(4, "20/5/2024", team1, team3, "Mohamed Farouk", "Suez Canal Stadium"));
    matchesList.add(new MatcheModel(5, "15/6/2024", team1, team3, "Mohamed Farouk", "Suez Canal Stadium"));
    matchesList.add(new MatcheModel(6, "10/1/2024", team2, team4, "Ahmed Samy", "Borg El Arab Stadium"));
    matchesList.add(new MatcheModel(7, "15/2/2024", team1, team4, "Hossam El Badry", "Petroleum Stadium"));
    matchesList.add(new MatcheModel(8, "9/4/2024" , team2, team3, "Mohamed Youssef", "Alexandria Stadium"));
    }
}