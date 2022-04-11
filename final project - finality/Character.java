import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Character extends Franchise {
  private String name;
  private String franchise;
  private int rarity;
  private boolean isClaimed;

  public Character(){
    super();
    this.franchise = franchise;
    this.name = name;
    this.rarity = rarity;
    isClaimed = false;
  }

  public boolean claimStatus()
  {
    if (isClaimed = true)
    {
      System.out.println("This character is already claimed.");
      return true;
    }
    else
    {
      System.out.println("This character has yet to be claimed.");
      return false;
    }
  }

  public int getRarity()
  {
    return rarity;
  }

  public String getFranchise()
  {
    return franchise;
  }

  public void add(String franchise, String name){
    System.out.println("Type a characters franchise then their name (EX: Franchise, Name)");
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    try {
      FileWriter fw = new FileWriter("gachaChars.txt");
      fw.write(input + " has been added to the roster");
      fw.close();
    } 
    catch (IOException e) {
      System.out.println("Could not write to file. " + e);
    }
  }

  public boolean contains(String name2) {
	return false;
  }
}