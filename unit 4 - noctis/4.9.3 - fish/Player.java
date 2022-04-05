/*
 * Activity 4.9.3 and 4.9.4
 * A Player class for the Fishing Game
 * 
 * V1.0
 * 10/10/2019
 * Copyright(c) 2019 PLTW to present. All rights reserved
 */
import java.util.ArrayList;

/**
* A player for a fishing game to simulate updating an inventory.
*/
public class Player
{
  // attributes for the player's inventory
  private ArrayList<LakeObject> inventory;
  private int maxInventory;
  private int cash;
  private String currentLocation;

  /*---------- constructor ----------*/
  public Player()
  {
    cash = 50; // starting cash
    inventory = new ArrayList<LakeObject>(); // 16 spaces for inventory
    inventory.add(new Wallet()); // Wallet must be first item
    inventory.get(0).setCost(cash);
    inventory.add(new Hook());
    inventory.add(new Bait());
    maxInventory = 16;
    currentLocation = "forest";
  }

  /*---------- accessors ----------*/
  public int getWallet()
  {
    return cash;
  }
  public ArrayList<LakeObject> getInventory()
  {
    return inventory;
  }
  public String getCurrentLocation()
  {
    return currentLocation;
  }

  /*---------- mutators ----------*/
  public void updateWallet(int cash)
  {
    this.cash += cash;
    // Wallet is item 0
    inventory.get(0).setCost(this.cash);

  }

  public void setCurrentLocation(String location)
  {
    currentLocation = location;
  }

  /*---------- additional methods ----------*/
  /**
   * Checks the player's inventory to see if player has a hook
   */
  public boolean hasHook()
  { 
    boolean hasHook = false;
    for (LakeObject item : inventory)
    {
      if (item == null)
        hasHook = false;
      // Object methods getClass().getName() return the name of the subclassed item
      else if (item.getClass().getName().equals("Hook"))
        return true;
    }
    return hasHook;
  }

  /**
   * Checks the player's inventory to see if player has bait
   */
  public boolean hasBait()
  {
    boolean hasBait = false;
    for(LakeObject item : inventory)
    {
      if (item == null)
        hasBait = false;
      // Object methods getClass().getName() return the name of the subclassed item
      else if (item.getClass().getName().equals("Bait"))
        return true;
    }
    return hasBait;
  }

  /**
   * Searches the player's inventory for the strongest hook
   * 
   * @return the players strongest hook
   */
  public Hook getStrongestHook()
  { 
    Hook strongestHook = null;

    if (hasHook())
    {
      for (LakeObject item : inventory)
      {
      // Object methods getClass().getName() return the name of the subclassed item
      if (item.getClass().getName().equals("Hook"))
          strongestHook = (Hook)item;
      }
    }
    return strongestHook;
  }
  
  /**
   * Get the inventory items in a 2D array
   * 
   * @return 2D array of lake objects
   */
  public LakeObject[][] getInventoryItems2D()
  {
    LakeObject[][] inventoryItems2D = new LakeObject[maxInventory/(maxInventory/2)][maxInventory/2];
    int inventoryIndex = 0;
    for (int r = 0; r < inventoryItems2D.length; r++)
    {
      for (int c = 0; c < inventoryItems2D[r].length; c++)
      {
        if (inventoryIndex >= inventory.size())
          inventoryItems2D[r][c] = null;
        else
          inventoryItems2D[r][c] = inventory.get(inventoryIndex);

        inventoryIndex++;
      }
    }
    return inventoryItems2D;
  }

  /**
   * Get the the names of the inventory items in a 2D array
   */
  public String[][] getInventory2D()
  {
    String[][] inventory2D = new String[maxInventory/(maxInventory/2)][maxInventory/2];
    int inventoryIndex = 0;
    for (int r = 0; r < inventory2D.length; r++)
    {
      for (int c = 0; c < inventory2D[r].length; c++)
      {
        if (inventoryIndex >= inventory.size())
          inventory2D[r][c] = "empty";
        else
        {
          // Object methods getClass().getName() return the name of the subclassed item
          String item = inventory.get(inventoryIndex).getClass().getName();
          inventory2D[r][c] = item;
        }
        inventoryIndex++;
      }
    }
    return inventory2D;
  }

  /** 
   * Add or remove and item from the inventory
   */
  public void updateInventory(LakeObject newItem, boolean toAdd)
  {
    if (inventory.size() <= maxInventory && toAdd)
    {
      if (inventory.size() < maxInventory)
      {
        inventory.add(newItem);
        // Object methods getClass().getName() return the name of the subclassed item
        if (newItem.getClass().getName().equals("Fish"))
        {
          loseItem("Bait");
        }
      }
    }
    else
    {
      loseItem("Hook");
    }
  }


  /** 
   * Remove an item from inventory
   */
  public void loseItem(String itemType)
  {
    for (int i = 0; i < inventory.size(); i++)
    {
      // Object methods getClass().getName() return the name of the subclassed item
      if (inventory.get(i).getClass().getName().equals(itemType))
      {
        inventory.remove(i); 
        break;
      }
    }
  }


  /** 
   * Remove a sold item from inventory and update player's wallet
   */
  public boolean loseItem(String itemType, int location, boolean sold) 
  {
      // Object methods getClass().getName() return the name of the subclassed item  
    if (sold && (location > 0) && inventory.get(location-1).getClass().getName().equals(itemType))
    {
      updateWallet(inventory.get(location-1).getCost());
      inventory.remove(location-1);
      return true;
    }
    return false;
  
  }

  /**
   * Returns true if there is room in inventory for another item, false otherwise
   */
  public boolean roomInInventory() {
    if (inventory.size() < maxInventory) {
      return true;
    }
    return false;
  }
}