public class Tiger extends Feline
{
  // step 21
  public Tiger(String food, boolean nocturnal, double aveLifeSpan)
  { 
    super(food, nocturnal, aveLifeSpan);
    System.out.println("A tiger arrives.");
  }
  
  // step 24
  public Tiger()
  {
    System.out.println("A tiger arrives.");
  }
  
  public void huntAlone()
  {
    System.out.println("The tiger hunts alone.");
  }
  
  public void swim()
  {
    System.out.println("The tiger swims!");
  }
}