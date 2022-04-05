/*
 * Activity 3.7.5
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

/**
 *  A class to prepare a library with books.
 */
public class Library
{
  private ArrayList<Book> childrensBooks = new ArrayList<Book>();

  /**
   * Constructor for the Library class. Loads data from the childrensbooksearly1900s.txt file
   * and populates the ArrayList childrensBooks.
   */
  public Library()
  {
    // a try is like an if statement, "throwing" an error if the body of the try fails
    try
    {
      Scanner sc = new Scanner(new File("childrensbooksearly1900s.txt"));
      while (sc.hasNextLine())
      {
        // String method trim removes whitepsace from the beginning
        // and end of strings
        String temp = sc.nextLine().trim();
        // String method split splits this string based on the
        // specified token and returns an array of individual substrings
        String[] tokens = temp.split(", ");
        String title = tokens[0];
        String author = tokens[1];
        double rating = Double.parseDouble(tokens[2]);

        // add the book to the array list
        childrensBooks.add(new Book(title, author, rating));
      }
    } catch (Exception e) { System.out.println("Error reading or parsing childrensbooksearly1900s.txt" + e); }
  }

  /**
   * Returns the current list of childrens books in the library.
   * 
   * @return the ArrayList of childrens books
   */
  public ArrayList<Book> getChildrensBooks()
  {
    return childrensBooks;
  }

  
}
