package egyptian_league_project;
public class MatcheModel {
    private int id;
    private String date;
    private TeamModel team1;
    private TeamModel team2;
    private String footballReferee;
    private int firstTeamScore;
    private int secondTeamScore;
    private String stadiunName;
    private String status;
    public MatcheModel(int id, String date, TeamModel team1, TeamModel team2, String footballReferee, String stadiunName) {
        this.id = id;
        this.date = date;
        this.team1 = team1;
        this.team2 = team2;
        this.footballReferee = footballReferee;
        this.stadiunName = stadiunName;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setFootballReferee(String footballReferee) {
        this.footballReferee = footballReferee;
    }
    public void setTeam1(TeamModel team1) {
        this.team1 = team1;
    }
    public void setTeam2(TeamModel team2) {
        this.team2 = team2;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setFirstTeamScore(int firstTeamScore) {
        this.firstTeamScore = firstTeamScore;
    }
    public void setSecondTeamScore(int secondTeamScore) {
        this.secondTeamScore = secondTeamScore;
    }
    public void setStadiunName(String stadiunName) {
        this.stadiunName = stadiunName;
    }
    public int getId() {
        return id;
    }
    public String getDate() {
        return date;
    }
    public TeamModel getTeam1() {
        return team1;
    }
    public TeamModel getTeam2() {
        return team2;
    }
    public String getFootballReferee() {
        return footballReferee;
    }
    public int getFirstTeamScore() {
        return firstTeamScore;
    }
    public int getSecondTeamScore() {
        return secondTeamScore;
    }
    public String getStadiunName() {
        return stadiunName;
    }
   }