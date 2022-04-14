public class WishChar extends Character {
    public static boolean isWished(Player name, String character){
      for (WishChar c : name.getWishlist()) {
          if (c.contains(character)){
            return true;
          }
          else if (!c.contains(character)){
            return false;
          }
        }
      }
}