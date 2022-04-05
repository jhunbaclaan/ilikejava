/*
 * Activity 3.7.2
 */
import java.util.ArrayList;

public class ArrayListExample
{  
   public static void main(String args[])
   {  
      ArrayList<String> animalList = new ArrayList<String>();  
      animalList.add("Dog");
      animalList.add("Cat");
      animalList.add("Rabbit");
      animalList.add("Frog");
      animalList.add("Horse");
      animalList.add("snake");
      animalList.add("Cow");
      animalList.add("bird");
      
      // isplaying elements
      System.out.println(animalList);
      
      /* your code here */ 
      System.out.println(animalList.get(1));
      System.out.println(animalList.get(2));
      System.out.println(animalList.get(4));
      animalList.remove(3);
      System.out.println(animalList.size());
      // display elements
      System.out.println(animalList);
   }  
}