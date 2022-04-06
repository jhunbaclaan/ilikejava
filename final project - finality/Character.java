import java.util.ArrayList;
import java.util.Scanner;

public class Character extends Franchise
{
    private String name;
    private String franchise;
    private int rarity;
    protected boolean isClaimed;

    public Character(String franchise, String name, int rarity)
    {
        super();
        this.franchise = franchise;
        this.name = name;
        this.rarity = rarity;
        isClaimed = false;
    }

    public void add(String franchise, String name)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNextLine())
            {
                String creation = sc.next();
                if(creation.equals(""))
                {
                    characterList.add(null);
                }
            }
        }
    }
}
