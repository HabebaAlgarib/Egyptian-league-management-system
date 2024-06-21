package egyptian_league_project;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Teams {
  private String name;
  private int id;  
  private ArrayList<Players> players;
  private String captain;
  private ArrayList<Matches> matches;
  private int totalScore;
  private int points;

    public Teams(String name, int id, ArrayList<Players> players, String captain, ArrayList<Matches> matches, int totalScore) {
        this.name = name;
        this.id = id;
        this.players = players;
        this.captain = captain;
        this.matches = matches;
        this.totalScore = totalScore;
    }
    public void setPlayers(ArrayList<Players> players) {
        this.players = players;
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
    public void setPoints(int points) {
        this.points = points;
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
    public int getPoints() {
        return points;
    }
}
