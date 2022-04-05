/*
* Activity 1.2.4
* CodeCompiler
*
* V1.0
* 6/1/2019
* Copyright(c) 2019 PLTW to present. All rights reserved
*/
import java.util.Arrays;

/*
* This file contains the use of enums and some escape sequences that are beyond 
* the scope of the course. There are some examples of using important String
* methods like equals, split, and substring that could be good to examine.
* 
*/
public class CodeCompiler
{
  public enum Method
  {
    // define all method calls for the object 
    SET_X ("setX", 1),
    SET_Y ("setY", 1),
    SET_COLOR ("setColor", 1),
    SET_EAT("eat", 0),
    SET_SIT("sit",0),
    SET_SPEAK("speak",0),
    SET_WALK("walk",0);

    private final String methodIdentifier;
    private final int numberOfArguments;

    Method(String name, int numArgs)
    {
      this.methodIdentifier = name;
      this.numberOfArguments = numArgs;
    }

    public String getMethodIdentifier()
    {
      return methodIdentifier;
    }
    
    public int getNumberOfArguments()
    {
      return numberOfArguments;
    }
  }

  public DogAction compile(String code)
  {
    String tokens [] = code.split(" ");

    DogAction dogAct = null;

    // Constructors
    dogAct = checkConstructors(tokens);
    if (dogAct == null)
    {
      // static Methods
      dogAct = checkStaticMethods(tokens);
    }
    if (dogAct == null)
    {
      dogAct = checkVoidMethods(tokens);
    }
    if (dogAct == null)
    {
      // accessor Methods
      dogAct = checkAccessorMethods(tokens);
    }

    return dogAct;
  }

  private DogAction checkConstructors(String[] tokens)
  {
    if (tokens.length >= 5)
    {
      // Checks constructor syntax with one space between tokens
      // a try is like an if statement, "throwing" an error if the body of the try fails
      try
      {
        if (tokens[0].equals("Dog") && validIdentifier(tokens[1]) && tokens[2].equals("=") && 
            tokens[3].equals("new") && tokens[4].substring(0,4).equals("Dog(") && 
            tokens[tokens.length-1].substring(tokens[tokens.length-1].length()-2).equals(");"))
        {
          // Constructor with no arguments
          if(tokens.length == 5 && tokens[4].equals("Dog();"))
          {
            return new DogAction("Constructor 0", tokens[1]);
          }
          // Consturctor with some number of arguments
          else
          {
            String argumentString = "";
            for (int i = 4; i < tokens.length; i++)
            {
              argumentString += tokens[i].trim();
            }
            argumentString = argumentString.substring(4, argumentString.length()-2);
            // System.out.println("The argument string contains: " + argumentString); 
            String[] args = argumentString.split(",");

            return new DogAction("Constructor 1", tokens[1], args);
          }
        }
      } catch (Exception e) { System.err.println("CodeCompiler Error: could not process " + Arrays.toString(tokens) + "\n"); }
    }
    return null;
  }

  private DogAction checkStaticMethods(String[] tokens)
  {
    return null;
  }

  private DogAction checkVoidMethods(String[] tokens)
  {
    DogAction dogActionBuilder = new DogAction();
    // No dot operator means no method call
    if ((tokens.length > 0) && tokens[0].contains("."))
    {
      // Must be operating on a valid identifer. Whether that Dog object exists gets checked in GUI
      String identifier = tokens[0].split("\\.")[0];

      if (validIdentifier(identifier))
      {
        dogActionBuilder.setIdentifier(identifier);
        String methodIdentifier = tokens[0].split("\\.")[1].split("\\(")[0];

        // Ensure that the portion following the . is a valid Dog method identifier
        for (Method method : Method.values())
        {
          if (methodIdentifier.equals(method.getMethodIdentifier()))
          {
            dogActionBuilder.setAction(methodIdentifier);
            String[] remainder = tokens[0].split("\\("); // Remainder of first token following open paren
            String argumentString = new String();
            // In case there is no space after the opening paren
            if (remainder.length > 1)
            {
              argumentString += remainder[1];
            }
            // Ensures that the statement terminates with );
            if (tokens[tokens.length-1].substring(tokens[tokens.length-1].length()-2).equals(");"))
            {
              for (int i = 1; i < tokens.length; i++)
              {
                argumentString += tokens[i];
              }
              argumentString = argumentString.substring(0, argumentString.length()-2);
              String[] arguments = argumentString.split(",");
              
              // no arg method call OR match # of args provided with # of params defined (no overloading)
              if (arguments[0].equals("") || (arguments.length ==  method.getNumberOfArguments()))
              {
                dogActionBuilder.setArgs(arguments);
              }
            
              return dogActionBuilder;
            }
          }
        }
      }
    }
    return null;
  }

  private DogAction checkAccessorMethods(String[] tokens)
  {
    return null;
  }

  private boolean validIdentifier(String identifier)
  {
    if (Character.isLetter(identifier.charAt(0)) || identifier.charAt(0) == '$' || identifier.charAt(0) == '_')
    {
      for (char c : identifier.toCharArray())
      {
        if (!Character.isLetterOrDigit(c))
        {
          if (!(c == '$' || c == '_'))
          {
            return false;
          }
        }
      }
      return true;
    }
    return false;
  }

}