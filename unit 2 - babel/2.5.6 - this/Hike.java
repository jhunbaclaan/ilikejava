/*
 * Activity 2.5.6
 */
public class Hike
{
  private String name;
  private double miles;
  private Hike favorite;

  /**
   * The constructor for the Hike class
   */
  public Hike(String name, double miles)
  {
    this.name = name;
    this.miles = miles;
    favorite = null;
  }

  public Hike()
  {
    this("n/a", 0);
  }
  
  /**
   * Gets the favorite hike
   * 
   * @return the favorite hike
   */ 
  public Hike getFavorite()
  {
    this = favorite;
    return this;
  }

  
  /**
   * Sets and print out the longer hike as the favorite hike
   * 
   * @param h The hike to compare hike lengths to
   */
  public void setFavorite(Hike h)
  {
    if (h.miles > this.miles)
    {
      favorite = h;
    }
    else
    {
      favorite = this;
    }
    System.out.println("Favorite hike is " + favorite);
  }

  public void setFavorite()
  {
    setFavorite(this);
  }

  /**
   * Two hikes are equal if they have the same name and are length 
   * 
   * @param h The hike to compare this hike to
   */
  public boolean equals(Hike h)
  {
    // check that s is defined
    if (h != null)
    {
      if (h.name.equals(name) && h.miles == this.miles)
      {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Return the name and length of the hike
   * 
   * @return The hike's name and lenght in miles
   */
  public String toString() 
  {
    return name + " (" + this.miles + " miles)";
  }

}