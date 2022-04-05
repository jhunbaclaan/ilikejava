public class saiyan // parent class
{
    private String name;
    private int powerLevel;
    private boolean hasPlotArmor; // had to make protected so override could work

    public saiyan(String name, int powerLevel, boolean hasPlotArmor) //consgructort
    {
        this.name = name;
        this.powerLevel = powerLevel;
        this.hasPlotArmor = hasPlotArmor;

        System.out.println("The saiyan " + name + " is here!");
    }

    public void chargeKi()
    {
        System.out.println(name + " is powering up!");
    }

    public void sayName()
    {
        System.out.println("Hey! It's me! " + name + "!");
    }

    public void ssj()
    {
        System.out.println(name + " went Super Saiyan!");
    }

    public void eat()
    {
        System.out.println("yummy");
    }

    public void scouter()
    {
        if(powerLevel > 9000)
        {
            System.out.println("Their power level is OVER 9000!!!!!!!"); // bad reference to the old dbz meme
        }
    }

    public boolean getArmorStatus()
    {
        return hasPlotArmor;
    }

    public void cannotDie()
    {
        if(hasPlotArmor)
        {
            System.out.println(name + " has some plot bs so they get to live no matter what.");
        }
        else
        {
            System.out.println(name + " is unfortunately a side character, so they'll die when the audience wants them to.");
        }
    }
}
