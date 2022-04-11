public class WishChar extends Character {
    boolean trulse = false;
    public boolean isWished(Player name){
      DataCollector dCollector = new DataCollector();
      String currentChar = dCollector.getNextPost();
  
      while (currentChar != "NONE"){
        if (name.getInventory().contains(currentChar)){
          trulse = true;
        }
        // System.out.println(currentChar + " is " + trulse);
      }
      return trulse;
    }
  }