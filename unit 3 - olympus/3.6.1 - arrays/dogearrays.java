/*
 * Activity 3.6.1
 */
public class dogearrays
{
  public static void main(String[] args)
  {
    Dog[] myDogs = {new Dog("tylerNinjaBlevins"), new Dog("markiplier"), new Dog("johnShedletsky")};
    Dog[] neighborsDogs = new Dog[2];

    neighborsDogs[0] = new Dog();
    neighborsDogs[1] = new Dog();

    System.out.println(myDogs[0].getName()); // step 19
    System.out.println(myDogs[2].getName());

    neighborsDogs[0].setName("garfunkel");
    neighborsDogs[1].setName("123456789");

    System.out.println(neighborsDogs[0].getName());

    // neighborsDogs = {new Dog("j0941u2ty835u48941u2893rtgr"), new Dog("u2903rjsidj0909xfgu90hu23n")}; // err??

    // neighborsDogs[2] = new Dog("i1u305tuyer98fdhsrifgnbgkjrfcnbxgklt"); // err

    // neighborsDogs = new Dog[3];
    // System.out.println(neighborsDogs[0].getName()); // error
    // System.out.println(neighborsDogs[1].getName()); // error

    myDogs[2] = null;
    System.out.println(myDogs[2]);
  }
}