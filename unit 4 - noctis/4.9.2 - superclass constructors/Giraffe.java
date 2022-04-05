public class Giraffe extends Hooved
{
  // step 27
  public Giraffe(String food, boolean nocturnal, double aveLifeSpan)
  { 
    super(food, nocturnal, aveLifeSpan);
    System.out.println("A giraffe arrives.");
  }
  
  public void hum()
  {
    System.out.println("The giraffe hums.");
  }
  
}