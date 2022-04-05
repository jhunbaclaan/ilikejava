/*
 * Activity 4.9.3
 */
public class Bait extends LakeObject
{

    public Bait()
    {
        super();
        super.setCost(10);
    }
    
    @Override
    public String say()
    {
        return "you got a piece of bait.";
    }
}