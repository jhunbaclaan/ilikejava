import java.util.ArrayList;

public class Franchise {
  public DataCollector dc;
  private String franchise;
  private ArrayList<String> franchiseList;

  // constructors
  public Franchise() {
    dc = new DataCollector();
    setFranchiseList();
    franchise = franchiseList.get(0);

  }

  public Franchise(int index) {
    dc = new DataCollector();
    setFranchiseList();
    franchise = franchiseList.get(index);

  }

  // accessors
  public String getFranchise() {
    return this.franchise;
  }

  public ArrayList<String> getFranchiseList() {
    return franchiseList;

  }

  // mutators
  public void setFranchise(int index) {
    franchise = franchiseList.get(index);
  }

  public void setFranchiseList() {

    ArrayList<String> tempList = dc.getList();
    franchiseList = new ArrayList<String>();
    // goes through data collector's list and grabs only the franchise name
    for (String str : tempList) {
      franchiseList.add(str.substring(str.indexOf("-") + 1));
    }

  }

  public String toString() {
    return getFranchise();
  }

}
