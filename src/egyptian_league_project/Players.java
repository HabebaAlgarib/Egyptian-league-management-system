package egyptian_league_project;
import java.util.Scanner;
public class Players {
   private String position;
   private String name;
   private int number;
   private Teams team;
   private int age;
   private int score;
   private String rank;
   
    public Players(String position, String name, int number, int age, int score, String rank) {
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
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public void setRank(String rank) {
        this.rank = rank;
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
    public String getRank() {
        return rank;
    }
    public String displayInformation() {
        return "Player Information:\n" +
                "Position: " + position + "\n" +
                "Name: " + name + "\n" +
                "Number: " + number + "\n" +
                "Age: " + age + "\n" +
                "Score: " + score + "\n" +
                "Rank: " + rank + "\n" +
                "Team: " + (team != null ? team.getName() : "Not assigned");
    }
}

