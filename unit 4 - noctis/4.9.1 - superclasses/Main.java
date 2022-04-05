/*
 * Activity 4.9.1
 */
public class Main //InheritedPet
{
  public static void main(String[] args)
  {
    System.out.println("my cat");
    Cat myCat = new Cat();
    myCat.setName("Romeo");
    myCat.purr();
    myCat.eat();
    myCat.sleep();
    
    System.out.println("my dog");
    Dog myDog = new Dog();
    myDog.setName("Juliette");
    myDog.walk();
    myDog.eat();
    myDog.sleep();

    System.out.println("\ni love my pallas's cat");
    Manul fatass = new Manul();
    fatass.setName("idiot fat cat");
    fatass.purr();
    fatass.hiss();
    fatass.hiss();
    fatass.hiss();
    fatass.eat();
    fatass.eat();
    fatass.eat();
    fatass.reallyFat();
    fatass.sleep();

    System.out.println("\nit's aaron");
    aaron aaron = new aaron();
    aaron.setName("Aaron");
    aaron.eat();
    aaron.eat();
    aaron.reallyFat();
    aaron.slowTyper();
    aaron.sleep();
    aaron.sleep();
    aaron.sleep();
    aaron.sleep();
  }
}