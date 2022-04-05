public class Person {
    private String name = new String();
    private int age;
    private String annoyingLevel;

// constructor
    public Person(String name, int age, String annoyingLevel)
    {
        this.name = name;
        this.age = age;
        this.annoyingLevel = annoyingLevel;
    }

// tostring method
    public String toString()
    {
        String info = name + " is " + age + " years old, and is " + annoyingLevel + " annoying.";
        return info;
    }
// set
    public void setName(String n)
    {
        this.name = n;
    }

    public void setAge(int a)
    {
        this.age = a;
    }

    public void setAnnoyance(String u)
    {
        this.annoyingLevel = u;
    }
}
