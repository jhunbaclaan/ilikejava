import java.util.ArrayList;
import java.util.Scanner;

public class Player {
  //attributes
  private String name;
  private ArrayList<Character> charInventory;
  private ArrayList<WishChar> wishlist;
  private int inventorySize;

  //constructor
  public Player() {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter your name:");
    name = in.nextLine();
    System.out.println("Welcome " + name + "!");

    inventorySize = 25;
  }

  //accessors
  public ArrayList<Character> getInventory() {
    return charInventory;
  }

  public ArrayList<WishChar> getWishlist() {
    return wishlist;
  }

  //other methods
  public boolean isFull() {
    if (charInventory.size() == inventorySize) {
      return true;
    }
    return false;
  }


}
