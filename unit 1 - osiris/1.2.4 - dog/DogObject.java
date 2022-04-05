/*
* Activity 1.2.4
* DogObject
*
* V1.0
* 6/1/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/

/** 
* Represents a simple Dog class in the GUI
*/
public class DogObject
{    
  private static final int DEFAULT_WIDTH = 144, DEFAULT_HEIGHT = 137;
  private static int numDogs = 0;
  public static final int MAX_NUM_ARGS = 1;
  public static final int MIN_X_VALUE = 0, MIN_Y_VALUE = 0, MAX_X_VALUE = 432, MAX_Y_VALUE = 424;

  private int x, y, width, height;
  private String identifier;
  private String color;

  private boolean eat, sit, speak, walk;

  public DogObject(String identifier)
  {
    this(identifier, DEFAULT_WIDTH * getNumDogs(), DEFAULT_HEIGHT * getNumDogs(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
    x = 300;
    y = 280;
  }

  public DogObject(String identifier, int x, int y, int width, int height)
  {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.identifier = identifier;
    this.color = "Red";
 
    incrementNumDogs();
  }

  public String toString()
  {
    return "<<<DogObject: " + identifier + " at (" + x + ", " + y + ") - Size: " + width + " x " + height + ">>>";
  }

  /**
   * @return the identifier
   */
  public String getIdentifier()
  {
    return identifier;
  }

  /**
   * @param identifier the identifier to set
   */
  public void setIdentifier(String identifier)
  {
    this.identifier = identifier;
  }

  /**
   * @return the numDogs
   */
  public static int getNumDogs()
  {
    return numDogs;
  }

  /**
   * Increment nubmer of dogs 
   */
  private static void incrementNumDogs()
  {
    numDogs += 1;
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
   * Set the dog state to eat
   */
  public void eat() 
  {
    eat = true;
    sit = false;
    speak = false;
    walk = false;
  }
  /**
   * Set the dog state to sit
   */
  public void sit() 
  {
    eat = false;
    sit = true;
    speak = false;
    walk = false;
  }

  /**
   * Set the dog state to speak
   */
  public void speak()
  {
    eat = false;
    sit = false;
    speak = true;
    walk = false;
  }

  /**
   * Set the dog state to walk
   */
  public void walk()
  {
    eat = false;
    sit = false;
    speak = false;
    walk = true;
  }

  /**
   * Determine if the dog is eating
   * 
   * @return true if dog is in eat state, false otherwise
   */
  public boolean isEating() 
  {
    return eat;
  }
 
  /**
   * Determine if the dog is sitting
   * 
   * @return true if dog is in sit state, false otherwise
   */
  public boolean isSitting() 
  {
    return sit;
  }
  
  /**
   * Determine if the dog is speaking
   * 
   * @return true if dog is in speak state, false otherwise
   */
  public boolean isSpeaking()
  {
    return speak;
  }
  
  /**
   * Determine if the dog is walking
   * 
   * @return true if dog is in walk state, false otherwise
   */
  public boolean isWalking()
  {
    return walk;
  }

}