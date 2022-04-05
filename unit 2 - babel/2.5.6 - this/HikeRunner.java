/*
 * Activity 2.5.6
 */
public class HikeRunner
{
  public static void main(String[] args)
  {
    Hike hike1 = new Hike("Cliff Ridge", 3.6);
    Hike hike2 = new Hike("Apple Orchard", 4);

    hike1.setFavorite(hike2);

    Hike hike3 = new Hike("Chestnut Knob", 2.6);
    hike2.setFavorite(hike3);

    Hike hike4 = new Hike();
    System.out.println(hike4);

    Hike hike5 = new Hike("ice gulch", 2.2);
    hike5.setFavorite();
  }
}