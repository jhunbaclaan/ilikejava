/*
 * Activity 1.3.5
 */
import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class compoundboolean
{
  public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in); 
    
    System.out.println("Enter the first number");
    int a = Integer.parseInt(sc.nextLine()); 

    System.out.println("Enter the second number");
    int b = Integer.parseInt(sc.nextLine()); 

    System.out.println("third number now");
    int c = Integer.parseInt(sc.nextLine());
    
    /* your code here */
    if (a > b)
    {
        System.out.println("a > b = true");
    }
    else 
    {
        System.out.println("a > b = false");
    }
    if (b > c)
    {
        System.out.println("b > c = true");
    }
    else
    {
        System.out.println("b > c = false");
    }
    if ((a > b) && (b > c))
    {
        System.out.println("a > b && b > c = true");
    }
    else
    {
        System.out.println("a > b && b > c = false");
    }
    if ((a > b) || (b > c))
    {
        System.out.println("a > b || b > c = true");
    }
    else
    {
        System.out.println("a > b || b > c = false");
    }
    if (!((a > b) && (b > c)))
    {
        System.out.println("!a > b && b > c = true");
    }
    else
    {
        System.out.println("!a > b && b > c = false");
    }
  }
}
