/**
 * Activity 4.9.3
 */
public class Hook extends LakeObject
{
  private int strength;

  public Hook()
  {
    super();
    strength = 55;
    super.setCost(15);

  }

  /*---------- accessor ----------*/
  public int getStrength() 
  {
    return strength; // This return will be updated in the next activity
    //return strength;
  }
  @Override
  public String say()
  {
    return "you have a hook now.";
  }
}