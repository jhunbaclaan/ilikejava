/*
* Activity 1.2.3
*
* Yet another CakeRunner class
*/
public class CakeRunner3
{
  public static void main(String[] args)
  {
    System.out.println("My cake:");
    Cake myCake = new Cake();
    myCake.twoTiers();
    myCake.show();

    System.out.println("Your cake:");
    Cake yangusCake = new Cake();
    yangusCake.threeTiers();
    yangusCake.addCandles();
    yangusCake.show();

    System.out.println("three:");
    Cake doomCake = new Cake();
    doomCake.twoTiers();
    doomCake.addCandles();
    doomCake.show();
  }
}