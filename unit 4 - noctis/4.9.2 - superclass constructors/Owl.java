public class Owl extends Animal 
{
    public Owl(String food, boolean nocturnal, double aveLifeSpan)
    {
        super(food, nocturnal, aveLifeSpan);
        System.out.println("an owl is here.");
    }

    public Owl()
    {
        System.out.println("an owl is here.");
    }

    public void hunt()
    {
        System.out.println("Owl goes hunting!");
    }
    
}
