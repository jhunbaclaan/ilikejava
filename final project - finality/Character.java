// FIX ALL OF THIS
// THERE ARE LIKE 12 ASSIGNMENT OR SYNTAX ERRORS PLEASE
// HELP ME FIX THIS LATER


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

    public void add() // most of method taken from horsebarn.java
    {
        try
        {
            System.out.println("add a character by the name of their franchise, then their name.");
            System.out.println("e.g. \"Adventure Time, Jake.\"");
            Scanner sc = new Scanner(System.in); // does NOT use a file this time, instead uses user input
            while (sc.hasNextLine())
            {
                String creation = sc.next();
                if(creation.equals("")) // no input = null
                {
                    characterList.add(null);
                }
                else
                {
                    String[] tokens = temp.split(","); // any commas will therefore be used to separate name and franchise respectively
                    String franchName = tokens[0]; // first word(s) before comma is considered the franchise
                    String charName = tokens[1]; // first word(s) after comma is considered the character name

                    characterList.add(franchName, charName).as(); // add character to list
                }
            }
        } catch (Exception e) {System.out.println("error reading add request; could not add character."); }
    }

    public static T as(Character a, Class<T> tClass)
    {
        return tClass.isInstance(a) ? (T) a : null;
    }
}
