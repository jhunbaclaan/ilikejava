import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.io.*;

// sam made her own datacollector bc she is insane
public class DataCollector {
  private ArrayList<String> gachaChars;
  private Scanner sc;

  public DataCollector() {
    gachaChars = new ArrayList<String>();
    //testing:
    setData("GachaChars.txt");
    for (String c : gachaChars) {
      System.out.println(c.substring(c.indexOf("-")+1)); //returns franchise
      System.out.println(c.substring(0, c.indexOf("-"))); //returns character
  }

  }

  public void setData(String filename) {
      // reads list of characters and franchises found in GachaChars.txt
      // a try is like an if statement, "throwing" an error if the body of the try fails
      try {
          sc = new Scanner(new File(filename));
          while (sc.hasNextLine()) {
          // String method trim removes whitespace before and after a string
          String temp = sc.nextLine().trim();
          // DEBUG: System.out.println(temp);
          this.gachaChars.add(temp);
          }
      } 
  
      catch (Exception e) { System.out.println("Error reading or parsing" + gachaChars + "\n" + e); }

  }

  public ArrayList<String> getList()
  {
    return gachaChars;
  }


}
