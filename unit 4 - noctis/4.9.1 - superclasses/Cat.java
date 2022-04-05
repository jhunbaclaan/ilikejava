/*
 * Activity 4.9.1
 */
public class Cat extends Pet
{
  public void purr()
  {
    System.out.println(getName() + " says: purrrrrrrrrrr");
    
    // error (privagte variable) System.out.println(name + ": purrrrrrrrrrr");
    //System.out.println("purrrrrrrrrrr");
  }

 }