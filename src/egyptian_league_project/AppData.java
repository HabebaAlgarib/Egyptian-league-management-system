package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class AppData {
    Scanner scanner = new Scanner(System.in);
    public ArrayList<Players> playersList;
    public ArrayList<Teams> teamsList;
    public ArrayList<Matches> matchesList;
    public AppData() {
        playersList = new ArrayList<>();
        teamsList = new ArrayList<>();
        matchesList = new ArrayList<>();
    }
    
    public void prepareData() {
  
    Players player1 = new Players("goalkeeper", "Mohamed_El_Shenawy", 8, 30, 8, 1);
    Players player2 = new Players("goalkeeper", "Allison", 10, 35, 0, 1);
    Players player3 = new Players("Forward", "Mohamed_Salah", 29, 32, 11, 2);
    Players player4 = new Players("Midfielder", "Mahmoud_Hassan_'Trezeguet'", 27, 29, 17, 3);
    Players player5 = new Players("Defender", "Ali_Gabr", 32, 24, 20, 4);
    Players player6 = new Players("Forward", "Ahmed_Ali", 25, 25, 15, 6);
    Players player7 = new Players("Midfielder", "Hussein_El-Shahat", 28, 32, 18, 5);
    Players player8 = new Players("Defender", "Ayman_Ashraf", 30, 33, 19, 7);
    Players player9 = new Players("Forward", "Ramadan_Sobhi", 26,27, 13, 8);
    Players player10 = new Players("Midfielder", "Tarek_Hamed", 29, 26, 14, 9);
    Players player11 = new Players("Defender", "Ahmed_Fathi", 35,39 , 22, 10);
    Players player12 = new Players("Forward", "Mohamed_Magdy", 24, 28, 16, 11);
    Players player13 = new Players("Midfielder", "Amr_Warda", 27, 30, 21, 12);
    
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

    Teams team1 = new Teams("Al_Ahly", 1, new ArrayList<>(), "Pitso_Mosimane", new ArrayList<>(), 0);
    Teams team2 = new Teams("Zamalek", 2, new ArrayList<>(), "Jaime_Pacheco", new ArrayList<>(), 0);
    Teams team3 = new Teams("Pyramids", 3, new ArrayList<>(), "Rodolfo_Arruabarrena", new ArrayList<>(), 0);
    Teams team4 = new Teams("Ismaily", 4, new ArrayList<>(), "Ariel_Holan", new ArrayList<>(), 0);
    Teams team5 = new Teams("Wadi Degla", 5, new ArrayList<>(), "Ahmed Hossam 'Mido'", new ArrayList<>(), 0);
    Teams team6 = new Teams("Masry", 6, new ArrayList<>(), "Tarek Yehia", new ArrayList<>(), 0);

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
    
    matchesList.add(new Matches(1, "5/8/2024", team1, team2, "Hossam Ashour", "Cairo International Stadium"));
    matchesList.add(new Matches(2, "4/1/2024", team3, team4, "Ali Maher", "30 June Stadium"));
    matchesList.add(new Matches(3, "15/7/2024", team5, team6, "Ahmed Samy", "Petroleum Stadium"));
    matchesList.add(new Matches(4, "20/5/2024", team1, team3, "Mohamed Farouk", "Suez Canal Stadium"));
    matchesList.add(new Matches(5, "15/6/2024", team1, team3, "Mohamed Farouk", "Suez Canal Stadium"));
    matchesList.add(new Matches(6, "10/1/2024", team2, team4, "Ahmed Samy", "Borg El Arab Stadium"));
    matchesList.add(new Matches(7, "15/2/2024", team1, team4, "Hossam El Badry", "Petroleum Stadium"));
    matchesList.add(new Matches(8, "9/4/2024" , team2, team3, "Mohamed Youssef", "Alexandria Stadium"));
    }
}