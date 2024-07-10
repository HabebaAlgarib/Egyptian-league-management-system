package egyptian_league_project;
import java.util.Scanner;
public class Players {
   private String position;
   private String name;
   private int number;
   private Teams team;
   private int age;
   private int score;
   private int rank;
   AppData appData = new AppData();
   Scanner scanner = new Scanner(System.in);
   public Players(String position, String name, int number, int age, int score, int rank) {
        this.position = position;
        this.name = name;
        this.number = number;
        this.age = age;
        this.score = score;
        this.rank = rank;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public void setTeam(Teams team) {
        this.team = team;
        if(!team.getPlayers().contains(this)){
            team.addPlayer(this);
        }
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public Teams getTeam() {
        return team;
    }
    public int getAge() {
        return age;
    }
    public int getScore() {
        return score;
    }
    public int getRank() {
        return rank;
    }
    public void setPosition(String position) {
        this.position = position;
    }   
    public  void  displayInformation() {
       System.out.println("Player Information: ");
            System.out.println("Position: "+getPosition());
            System.out.println("Name: " + name);
            System.out.println("Number: " + number);
            System.out.println("Age: " + age);
            System.out.println("Score: " + score );
            System.out.println("Rank: " + rank);

    if (team != null) {
        System.out.println( "Team: " + team.getName());
    } else {
        System.out.println("Team is Not assigned");
    }
}
}