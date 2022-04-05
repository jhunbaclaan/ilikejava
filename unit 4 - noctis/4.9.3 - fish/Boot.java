/*
 * Activity 4.9.3
 */
public class Boot extends LakeObject
{
    private int cost;

    public Boot()
    {
        super();
        super.setCost(0);
    }

    @Override
    public String say()
    {
        return "you got... an old boot?";
    }
    @Override
    public boolean wasCaught(Hook h)
    {
        return true;
    }
}
