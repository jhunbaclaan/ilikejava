import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Character extends Franchise {
  private ArrayList<String> characterList;
  private String name;
  private String franchise;
  private int rarity;
  private boolean isClaimed;

  // constructors
  public Character() {
    super();
    setCharacterList();
    name = characterList.get(0);
    isClaimed = false;
  }

  public Character(int index) {
    super(index);
    setCharacterList();
    name = characterList.get(index);
    isClaimed = false;
  }
  
  // accessors
  public String getCharacter() {
    return this.name;
  }

  public ArrayList<String> getCharacterList() {
    return characterList;

  }

  // mutators
  public void setCharacter(int index) {
    name = characterList.get(index);
  }

  public void setCharacterList() {

    ArrayList<String> tempList = dc.getList();
    characterList = new ArrayList<String>();
    // goes through data collector's list and grabs only the character name
    for (String str : tempList) {
      characterList.add(str.substring(0, str.indexOf("-")));
    }

  }

  public String toString() {
    return name;
  }
  
  public String claimStatus()
  {
    if (isClaimed = true)
    {
      return "This character is already claimed.";
    }
    else
    {
      return "This character has yet to be claimed.";
    }
  }

  public int getRarity()
  {
    return rarity;
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
  public boolean contains(String name2) // vsc quick fix solution for searching chars :p
  {
	return false;
  }

  public int indexOf(String string) {
    return 0;
  }

  public Collection<? extends String> substring(int i) {
    return null;
  }
}