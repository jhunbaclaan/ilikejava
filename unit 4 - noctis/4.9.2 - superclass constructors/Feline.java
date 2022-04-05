//step 5
public class Feline extends Animal
{
  // step 23
  public Feline(String food, boolean nocturnal, double aveLifeSpan)
  { 
    super(food, nocturnal, aveLifeSpan);
    System.out.println("A feline arrives.");
  }
  
  // step 24
  public Feline()
  {
    System.out.println("A feline arrives.");
  }
  
  public void roar()
  {
    System.out.println("The feline roars.");
  }
  
  public void growl()
  {
    System.out.println("The feline growls.");
  }

}