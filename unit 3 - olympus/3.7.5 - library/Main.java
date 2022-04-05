/*
 * Activity 3.7.5
 */
 
import java.util.ArrayList;

public class Main //LibraryRunner
{
  public static void main(String[] args)
  {
    Library library = new Library();
    ArrayList<Book> childrensBooks = library.getChildrensBooks();

    /* First, get all the books by the author L. Frank Baum */
    // Step 6
    System.out.println("\nStep 6");
    String authorToFind = "L. Frank Baum";
    // Step 7
    System.out.println("\nStep 7");
    for(Book book : childrensBooks)
    {
      if (book.getAuthor().equals(authorToFind))
      {
        System.out.println(book.getTitle());
      }
    }

    /* Second, get the rating of Sky Island */
    // Step 8
    System.out.println("\nStep 8");
    String bookToFind = "Sky Island";
    double minimumRating = 0.0;
    // Step 9
    System.out.println("\nStep 9");
    for(Book book : childrensBooks)
    {
      if (book.getTitle().equals(bookToFind))
      {
        minimumRating = book.getRating();
      }
    }

    /* Test print to check the value of minimumRating */
    // Step 10
    System.out.println("\nStep 10");
    System.out.println(minimumRating);

    /* Third, get all the books with a rating of at least that of Sky Island */
    // Step 11
    System.out.println("\nStep11");
    for(Book book : childrensBooks)
    {
      if (book.getRating() >= minimumRating)
      {
        System.out.println("Book: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor() +"\n");
      }
    }

  }
}