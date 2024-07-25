package egyptian_league_project;
import java.util.ArrayList;
public class TeamModel {
  private String name;
  private int id;  
  private ArrayList<PlayerModel> players;
  private String captain;
  private ArrayList<MatcheModel> matches;
  private int totalScore;
  public TeamModel(String name, int id, ArrayList<PlayerModel> players, String captain, ArrayList<MatcheModel> matches, int totalScore) {
        this.name = name;
        this.id = id;
        this.players = players;
        this.captain = captain;
        this.matches = matches;
        this.totalScore = totalScore;
    }
  public void addPlayer(PlayerModel player) {
        this.players.add(player);
        if (player.getTeam() != this) {
            player.setTeam(this);
        }
    }
    public void setPlayers(ArrayList<PlayerModel> players) {
        this.players = players;
    }
    public void setName(String name) {
        this.name = name;
    }   
    public void setCaptain(String captain) {
        this.captain = captain;
    }
    public void setMatches(ArrayList<MatcheModel> matches) {
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
    public ArrayList<PlayerModel> getPlayers() {
        return players;
    }
    public String getCaptain() {
        return captain;
    }
    public ArrayList<MatcheModel> getMatches() {
        return matches;
    }
    public int getTotalScore() {
        return totalScore;
    }
}