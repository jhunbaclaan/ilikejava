import java.util.Random;

public class aaron extends Manul 
{
    Random wpm = new Random();
    int mostwpm = 55;
    int wpm_random = wpm.nextInt(mostwpm);
    public void slowTyper()
    {
        System.out.println(getName() + " did a typing test.");
        System.out.println(getName() + " typed a grand total of " + wpm_ random + " words per minute.");
    }
}
