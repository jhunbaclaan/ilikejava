import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Game {

  //attributes
  private Player player;
  private Character character;
  private ArrayList<Character> characters;
  private int rolls;

  DataCollector pool = new DataCollector(); // datacollector for datacollector things

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

      if (input.toLowerCase().equals("s")){
        System.out.println("Enter the name of a character.");
        search(sc.nextLine());
      }

      if (input.toLowerCase().equals("ss")){
        System.out.println("Enter the name of a series.");
        seriesSearch(sc.nextLine());
      }

      if (input.toLowerCase().equals("t")){

      }

      if (input.toLowerCase().equals("w")){

      }

      if (input.toLowerCase().equals("r")){
        roll();
      }

      if (input.toLowerCase().equals("rl")){
        System.out.println("You have " + getRolls() + " left");
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

  public void seriesSearch(String series) {
    for (Character f : characters)
    {
      ArrayList <String> seriesList = new ArrayList<String>(f.substring(f.indexOf("-") + 1));
      for (String s : seriesList)
      {
        if (s == series)
        {
          System.out.println(series + " exists.");
        }
        else
        {
          System.out.println(series + " does not exist. Add a franchise by adding a character with \"add\"!");
        }
      }
    }
  }

  public void trade(String char1, String char2)  // i still dont know how trading is going to work so
  {
    
  }

  public String wish(Character character) {

  }

  public Character roll() { 
    rolls--;
  
    int randIndex = (int) Math.random() * characters.size();
    Character gacha = characters.get(randIndex);
    characters.remove(randIndex); 
    // note: characters list will eventually run out and throw exception when rolling
    System.out.println(gacha);
    
    return gacha;

  }

  public int getRolls() 
  {
    return rolls;
  }
}
