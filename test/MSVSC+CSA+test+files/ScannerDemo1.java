// Java program to read data of various types using Scanner class. 
import java.util.Scanner; 
public class ScannerDemo1 
{ 
    public static void main(String[] args) 
    { 
        // Declare the object and initialize with 
        // predefined standard input object 
        Scanner sc = new Scanner(System.in); 
  
        // String input
        System.out.print("What's your name? "); 
        String name = sc.nextLine(); 
  
        // Print the values to check if input was correctly obtained. 
        System.out.println("Name: " + name); 

        // Close the Scanner
        sc.close();
    } 
} 