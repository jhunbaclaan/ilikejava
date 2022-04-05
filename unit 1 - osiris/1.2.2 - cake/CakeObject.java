/*
* Activity 1.2.2
* CakeObject
*
* V1.0
* 6/1/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/

/** 
 * This class is used by the ObjectMaker to keep track of additional attributes
 * and methods that are used for the graphical display of Cakes within the GUI
 * Many of the attributes, methods, and programming concepts used here are beyond
 * the scope of the activities in which ObjectMaker is used.
 * 
 * By the end of Activity 2.5.9 students should be able to read and understand
 * all of the contents of this file.
*/
public class CakeObject
{    
  private static final int DEFAULT_WIDTH = 100, DEFAULT_HEIGHT = 157, DEFAULT_TIERS = 1;
  public static final int MAX_NUMBER_OF_ARGS = 1;
  public static final int MIN_X_VALUE = 0, MIN_Y_VALUE = 0, MAX_X_VALUE = 432, MAX_Y_VALUE = 424;
  public static final int TABLE_HEIGHT = 250;

  private static int numberOfCakes = 0;

  private int x, y, width, height, tiers;
  private String cakeIdentifier;
  private String color;
  private boolean candles;

  public CakeObject(String cakeIdentifier)
  {
    this(cakeIdentifier, 0 + DEFAULT_WIDTH * getNumberOfCakes(), TABLE_HEIGHT, DEFAULT_WIDTH, DEFAULT_HEIGHT);
  }

  public CakeObject(String cakeIdentifier, int tiers)
  {
    this(cakeIdentifier, tiers, 0 + DEFAULT_WIDTH * getNumberOfCakes(), TABLE_HEIGHT, DEFAULT_WIDTH, DEFAULT_HEIGHT);
  }

  public CakeObject(String cakeIdentifier, int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.cakeIdentifier = cakeIdentifier;
    this.color = "Red";
    this.tiers = DEFAULT_TIERS;

    incrementNumberOfCakes();
  }


  public CakeObject(String cakeIdentifier, int tiers, int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.tiers = tiers;
    this.cakeIdentifier = cakeIdentifier;

    incrementNumberOfCakes();
  }

  public String toString()
  {
    return "CakeObject: " + cakeIdentifier + " Tiers: " + tiers + " at (" + x + ", " + y + ") - Size: " + width + " x " + height + ">>>";
  }

  /**
   * @return the cakeIdentifier
   */
  public String getCakeIdentifier()
  {
    return cakeIdentifier;
  }

  /**
   * @param cakeIdentifier the cakeIdentifier to set
   */
  public void setCakeIdentifier(String cakeIdentifier)
  {
    System.out.println("CakeObject: Setting cakeIndentifier" + cakeIdentifier);
    this.cakeIdentifier = cakeIdentifier;
  }

  /**
   * @return the numberOfCakes
   */
  public static int getNumberOfCakes()
  {
    return numberOfCakes;
  }

  /**
   * @param numberOfCakes increase the numberOfCakes by one
   */
  private static void incrementNumberOfCakes()
  {
    CakeObject.numberOfCakes += 1;
  }

  /**
   * @return the x
   */
  public int getX()
  {
    return x;
  }

  /**
   * @param x the x to set
   */
  public void setX(int x)
  {
    this.x = x;
  }

  /**
   * @return the y
   */
  public int getY()
  {
    return y;
  }

  /**
   * @param y the y to set
   */
  public void setY(int y)
  {
    this.y = y;
  }

  /**
   * @return the height
   */
  public int getHeight()
  {
    return height;
  }

  /**
   * @param height the height to set
   */
  public void setHeight(int height)
  {
    this.height = height;
  }

  /**
   * @return the width
   */
  public int getWidth()
  {
    return width;
  }

  /**
   * @param width the width to set
   */
  public void setWidth(int width)
  {
    this.width = width;
  }

  /**
   * @return the color
   */
  public String getColor()
  {
    return color;
  }

  /**
   * @param color the color to set
   */
  public void setColor(String color)
  {
    this.color = color;
  }

  /**
   * @return the number of tiers
   */
  public int getTiers()
  {
    return tiers;
  }

  /**
   * @param tiers the number of tiers to set
   */
  public void setTiers(int tiers)
  {
    this.tiers = tiers;
  }

  public void addCandles()
  {
    this.candles = true;
  }

  public boolean hasCandles()
  {
    return this.candles;
  }

  public void oneTier()       
  {
    this.tiers = 1;
  }

  public void twoTiers()
  {
    this.tiers = 2;
  }

  public void threeTiers()
  {
    this.tiers = 3;
  }
}