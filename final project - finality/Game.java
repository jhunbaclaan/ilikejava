import java.util.ArrayList;
import java.util.Scanner;

public class Game {

  //attributes
  private Player player;
  private Character character;
  private ArrayList<Character> characters;
  private int rolls;
  
  String characters = "";
  DataCollector characterPool = new DataCollector();
  characterPool.setData("gachaCahrs.txt");
  
  public Game() {
    player = new Player();
    rolls = 25;
    Scanner sc = new Scanner(System.in);

    // character array + population
    characters = new ArrayList<Character>();
    
    boolean play = true;
    while (play) {
      System.out.println("enter r to roll or h for help:");
      String input = sc.nextLine(); 

      //if statements for user input
      if (input.toLowerCase().equals("h")) {
          help();
        }

      if (input.toLowerCase().equals("q")) {
          System.out.println("thanks for playing!");
          play = false;
        }
    }
  }

  public void help() {
    System.out.print("list of commands: ");
    System.out.println("r - roll, t - trade, w - wish, rl - rolls left, s - search, ss - series search, h - help");
  }  

  public String search(String name) {
    
  }

  public String seriesSearch() {

  }

  public void trade(String char1, String char2) {

  }

  public String wish(Character character) {

  }

  public Character roll() { 

  }

  public int getRolls() {
    
  }
}
