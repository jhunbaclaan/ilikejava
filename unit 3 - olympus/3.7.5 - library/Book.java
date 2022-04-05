/*
 * Activity 3.7.5
 */

 /**
  * A Book class to define a Book in a library.
  */
public class Book
{
  private String title;
  private String author;
  private double rating;

  /**
   * The constructor for a Book. All Books require
   * a title, an author, and a rating. 
   */
  public Book(String title, String author, double rating)
  {
    this.title = title;
    this.author = author;
    this.rating = rating;
  }

  /** 
   * Sets the title of the Book
   * */
  public void setTitle(String title)
  {
    this.title = title;
  }

  /** 
   * Sets the aurthor of the Book
   * */
  public void setAuthor(String author)
  {
    this.author = author;
  }

  /** 
   * Sets the rating of the Book
   * */
  public void setRating(double rating)
  {
    this.rating = rating;
  }

  /** 
   * Gets the title of the Book
   * 
   * @return the Book's title
   * */
  public String getTitle()
  {
    return this.title;
  }

  /** 
   * Gets the aurthor of the Book
   * 
   * @return the Book's author
   * */
  public String getAuthor()
  {
    return this.author;
  }

  /** 
   * Gets the rating of the Book
   * 
   * @return the Book's rating
   * */
  public double getRating()
  {
    return this.rating;
  }

  
}