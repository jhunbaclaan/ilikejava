// imports required for program
import java.io.*;
import java.util.*;
import java.util.function.IntToDoubleFunction;

public class BoxPractice{
    public static void main(String[] args){
        // unique way of creating a wrapper AND autoboxing
        List <Integer> list = new ArrayList<Integer>();
        for (int yangus = 0; yangus < 10; yangus++); // yangus = 0; if yangus < 10, add 1 to value
            list.add(Integer.valueOf(yangus)); // creates an integer wrapper FROM the primitive yangus' value

    }
    //unboxing using a similar program
    public static int sumOfOddNumber(List<Integer> list) {
        int sum = 0;
        for (Integer i : list)
        {
            // use a different variable, i, and unbox it
            if(i % 2 != 0)
                sum += i;

        }
        return sum;
    }
}