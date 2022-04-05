public class broly extends saiyan // child class
{
    public broly(String name, int powerLevel, boolean hasPlotArmor)
    {
        super(name, powerLevel, hasPlotArmor); // super method
    }

    public void present() // unique broly method
    {
        System.out.println("BROLY IS GIVING YOU PRESENT: BIG KILL ORB!!!"); // imagine broly is saying this. it's not narration.
    }

    /* overrides */  
    @Override
    public void sayName()
    {
        System.out.println("MY NAME IS BROLY. YOUR NAME NOT BROLY!"); // again, broly is saying this. i thinjk it's just funny to imagine broly talking like a caveman
    }

    @Override
    public void cannotDie()
    {   
        if(super.getArmorStatus()) // super keyword
        {
            System.out.println("BROLY IS IMMUNE TO THE PLOT. BROLY NEVER DIES.");
        }
        else
        {
            System.out.println("IMPOSSIBLE! BROLY IS TOO STRONG TO DIE TO THE WILL OF THE AUDIENCE!");
        }
    }
}