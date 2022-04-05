/*
 * Activity 2.5.7
 * 
 * The runner for the MediaLibrary program
 */
public class MediaLibRunner
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to your Media Library");
    MediaLib myLib = new MediaLib();
    Book read = new Book("The Lord of the Rings", "Tolkien");
    
    System.out.println("new book: " + read);
    myLib.addBook(read);

    System.out.println("liberaluary: \n" + myLib);

    int deezRates = 5;
    read.adjustRating(deezRates);
    System.out.println(read);

    read.setTitle("OVERLORD");
    read.setAuthor("Kugane Maruyama");
    System.out.println("book: " + read);
    System.out.println("liberaluary: \n" + myLib);

    System.out.println("You have a NEW Library");
    MediaLib myLib2 = new MediaLib();

    Book newBook = new Book("To Kill a Mockingbird", "Lee");
    myLib2.addBook(newBook);
    System.out.println(myLib2);
    newBook = new Book("1984", "Orwell");
    System.out.println(myLib2);

   /* System.out.println("before test: " + newBook);
    myLib.testBook(newBook);
    System.out.println("after test: " + newBook);
    */

    Book comparable = new Book("1984" , "Orwell");
    System.out.println(comparable + " vs. " + newBook);
    System.out.println(comparable.equals(newBook));

    newBook.setAuthor("Lee");
    newBook.setTitle("To Kill a Mockingbird");
    System.out.println(comparable + " vs. " + newBook);
    System.out.println(comparable.equals(newBook));

   // System.out.println(comparable.title); error stuff

   Movie ip = new Movie("Ip Man" , 1.75);
   System.out.println(ip);
   System.out.println(ip + " vs. " + ip);
   System.out.println(ip.equals(ip));
  }
}