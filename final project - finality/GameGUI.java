import java.util.ArrayList;
import java.util.Scanner;

public class GameGUI 
{
    public ArrayList<Character> characterList = new ArrayList<Character>(); // creation of characterlist array

    public void setList(ArrayList characterList)
    {
        this.characterList = characterList;
    }

    public ArrayList<Character> getList()
    {
        return characterList;
    }
}
