/**
 * Activity 2.5.7
 * 
 * A MediaLib class for the MediaLibrary program
 */
public class MediaLib
{
  private Book book;
  private Movie movie;
  private Song song;

  public void addBook(Book b)
  {
    book = b;
    numEntries++;

    if (numEntries > 3)
    {
      book = null;
      System.out.println("maximum capacity reached, no more entries allowed");
    }
  }

  public void addMovie(Movie m)
  {
    movie = m;
    numEntries++;

    if(numEntries > 3)
    {
      movie = null;
      System.out.println("maximum capacity reached, no more entries allowed");
    }
  }

  public void addSong(Song s)
  {
    song = s;
    numEntries++;

    if(numEntries > 3)
    {
      movie = null;
      System.out.println("maximum capacity reached, no more entries allowed");
    }
  }

  public String toString() 
  {
    String info = "";
    int number = 1;
    int mNumber = 1;
    if (book != null)
    {
      info += ("Book " + number + ": " + book + "\n");
      number++;
    }
    if (movie != null)
    {
      info += ("Movie " + mNumber + ": " + movie +  "\n");
      mNumber++;
    }
    return info;
  }
 /* void testBook(Book tester)
  {
      tester.setTitle("slurpee cup");
      System.out.println("in test: " + tester.getTitle());
  } */

  public static String getOwner()
  {
    return owner;
  }

  public static String owner = "PLTW";

  public static String changeOwner(String o)
  {
    owner = o;
    return owner;
  }

  private static int numEntries = 0;

  public static int getNumEntries()
  {
    return numEntries;
  }
}