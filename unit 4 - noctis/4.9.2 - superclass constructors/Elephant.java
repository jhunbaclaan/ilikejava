//step 5
public class Elephant extends Animal
{
  // step 13
  public Elephant(String food, boolean nocturnal, double aveLifeSpan)
  { 
    // step 16: System.out.println("Elephant arrives.");
    super(food, nocturnal, aveLifeSpan);
    // step 18:
    System.out.println("An elephant arrives.");
  }
  
  // step 24
  public Elephant()
  {
    System.out.println("An elephant arrives.");
  }
  
  public void trumpet()
  {
    System.out.println("The elephant trumpets loudly!");
  }
  
  public void forage()
  {
    System.out.println("The elephant forages for food.");
  }
}