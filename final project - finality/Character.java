public class Character extends Franchise
{
    private String name;
    private String franchise;
    private int rarity;
    protected boolean isClaimed;

    public Character(franchise, name, rarity)
    {
        super(franchise, name, rarity);
        this.franchise = franchise;
        this.name = name;
        this.rarity = rarity;
        isClaimed = false;
    }

    public void add(franchise, name)
    {

    }
}
