public class Penguin extends Animal
{
    public Penguin(String food, boolean nocturnal, double aveLifeSpan)
    {
        super(food, nocturnal, aveLifeSpan);
        System.out.println("a penguin has arrived.");
    }

    public void fish()
    {
        System.out.println("Penguin goes fishing!");
    }
    
}
