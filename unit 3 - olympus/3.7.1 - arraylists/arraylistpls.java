import java.util.ArrayList;

public class arraylistpls 
{
    public static void main(String[] args)
    {
        ArrayList people = new ArrayList();
        people.add(new Person("figglebottom", 2, "barely"));
        people.add(new Person("changery", 3, "mildly"));
        people.add(new Person("tyrael", 128, "very"));

        System.out.println(people);
    }
}
