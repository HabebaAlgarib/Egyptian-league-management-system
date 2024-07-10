package egyptian_league_project;
import java.util.ArrayList;
import java.util.Scanner;
public class Teams {
  private String name;
  private int id;  
  private ArrayList<Players> players;
  private String captain;
  private ArrayList<Matches> matches;
  private int totalScore;
  Scanner scanner = new Scanner(System.in);
  public Teams(String name, int id, ArrayList<Players> players, String captain, ArrayList<Matches> matches, int totalScore) {
        this.name = name;
        this.id = id;
        this.players = players;
        this.captain = captain;
        this.matches = matches;
        this.totalScore = totalScore;
    }
  public void addPlayer(Players player) {
        this.players.add(player);
        if (player.getTeam() != this) {
            player.setTeam(this);
        }
    }
    public void setPlayers(ArrayList<Players> players) {
        this.players = players;
    }
    public void setName(String name) {
        this.name = name;
    }   
    public void setCaptain(String captain) {
        this.captain = captain;
    }
    public void setMatches(ArrayList<Matches> matches) {
        this.matches = matches;
    }
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Players> getPlayers() {
        return players;
    }
    public String getCaptain() {
        return captain;
    }
    public ArrayList<Matches> getMatches() {
        return matches;
    }
    public int getTotalScore() {
        return totalScore;
    }
}