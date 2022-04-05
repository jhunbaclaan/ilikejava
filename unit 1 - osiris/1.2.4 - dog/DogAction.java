/*
* Activity 1.2.4
* DogAction
*
* V1.0
* 6/1/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/

/** 
* Determines the action the user wants to take with a dog.
*/
public class DogAction
{
  private String action;
  private String identifier;
  private String[] args;

  public DogAction() 
  {
  }
  
  /**
   * @return the identifier
   */
  public String getIdentifier()
  {
    return identifier;
  }

  /**
   * @return the args
   */
  public String[] getArgs()
  {
    return args;
  }

  /**
   * @param args the args to set
   */
  public void setArgs(String[] args)
  {
    this.args = args;
  }

  /**
   * @param identifier the dog identifier to set
   */
  public void setIdentifier(String identifier)
  {
    this.identifier = identifier;
  }

  public String toString()
  {
    return "Dog object: " + identifier + " method: " + action + " arguments:" + args;
  }

  public DogAction(String action, String identifier)
  {
    this.action = action;
    this.setIdentifier(identifier);
  }

  public DogAction(String action, String identifier, String[] args)
  {
    this.action = action;
    this.setIdentifier(identifier);
    this.setArgs(args);
  }

  /**
   * @return the action
   */
  public String getAction()
  {
    return action;
  }

  /**
   * @param action the action to set
   */
  public void setAction(String action)
  {
    this.action = action;
  }
}