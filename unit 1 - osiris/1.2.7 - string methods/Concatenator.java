public class Concatenator
{
    public static void main (String [] args)
    {
    /* Your code here. */
    // strings
    String statement1 = 
        "drake the type of old god to ressurect the fnaf 2 toy animatronics ";
    String statement2 = 
        "while eminem is the type of old god to ressurect the venom";

    // length reminders
    System.out.println("the length of statement 1 is " + statement1.length());
    System.out.println("the length of statement 2 is " + statement2.length());
    // start concatenating
    System.out.println(statement1.substring(0, 29) + statement2.substring(39, 58));
    }
}