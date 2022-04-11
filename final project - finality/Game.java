import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Game {

  //attributes
  private Player player;
  private Character character;
  private ArrayList<Character> characters;
  private int rolls;
  
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

  public void search(String name) {
      for (Character targetChar : characters)
      {
        if (targetChar.contains(name))
        {
          System.out.println(name + ", from the franchise " + character.getFranchise());
          System.out.println(character.claimStatus());
        }
        else
        {
          System.out.println(name + "does not exist. Try adding them with \"add\"!");
        }
      }
  }

  public String seriesSearch() {

  }

  public void trade(String char1, String char2) {

  }

  public String wish(Character character) {

  }

  public Character roll() { 
    rolls--;
    
    //picks random character from characters list
    int random = (int) Math.random() * characters.size();
    character = characters.get(random);
    
    return character;
  }

  public int getRolls() {
    
  }
}
