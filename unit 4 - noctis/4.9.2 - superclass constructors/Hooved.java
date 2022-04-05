public class Hooved extends Animal
{
  // step 27
  public Hooved(String food, boolean nocturnal, double aveLifeSpan)
  { 
    super(food, nocturnal, aveLifeSpan);
    System.out.println("A hooved animal arrives.");
  }
  
  // step 29
  public Hooved()
  {
    System.out.println("A hooved animal arrives.");
  }
  
  public void forage()
  {
    System.out.println("The hooved animal forages for food.");
  }
}