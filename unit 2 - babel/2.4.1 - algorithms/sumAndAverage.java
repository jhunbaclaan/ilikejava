import java.util.Scanner;
import java.util.stream.*; // a required input to make array sums work properly

public class sumAndAverage
{
    public static void main(String[] args)
    {
        /* 
        cool trick i found on google: put all input into an array, then add them all into a sum
        makes things a lot easier and makes the overall code wayy shorter
        plus its arrays so its always fun :^) 
        */
        int array[] = new int[5];
        // set up numbers and a variable that will be used for average
        Scanner sc = new Scanner(System.in);
        System.out.println("you will be entering five numbers. enter your numbers here, ONE BY ONE: "); // first prompt for input
        for (int j = 0; j < 6; j++) // loop needed 
        {
            array[j] = sc.nextInt(); // parseint not particularly required, nextint is the same in function but directly parses from input, no need for extraneous parse after input
        } 

        // sum
        for (int i = 0; i<array.length; i++);
        {
            int sum = IntStream.of(array).sum(); // takes values of array and sums them
            System.out.println("the sum of your numbers is: " + sum);
        }

        // average
        fort (int f = 0; f<array.length; f++)
        {
            Double average = new Double(array) / amount;
            System.out.println("the average of your numbers is: " + average);
        }
    }
}