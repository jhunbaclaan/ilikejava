/*
 * Activity 3.6.3
 */
public class PetSimulator
{
  public static void main(String[] args)
  {
    // create an array that can hold up to 10 pets (does not require looping)
    Pet[] tenGoblins = new Pet[10];
    // adopt (create and name) four pets, two cats, two dogs (does not require looping)
    tenGoblins[0] = new Pet("mushroom", 1);
    tenGoblins[1] = new Pet("steak", 1);
    tenGoblins[2] = new Pet("mustard", 2);
    tenGoblins[3] = new Pet("puff pastry", 2);
    // first things first, feed your pets
    for (Pet p : tenGoblins)
    {
      if (p != null)
      {
        p.feed();
      }
    }
    // next, make yourself the owner of all of your new pets
    for (Pet p: tenGoblins)
    {
      if (p != null)
      {
        p.setOwner("june");
      }
    }
    // your dogs make some noise, take them for a walk
    for (Pet d : tenGoblins)
    {
      if (d != null)
      {
        if (d.getType() == 2)
        {
          d.makeNoise();
          d.walk();
        }
      }
    }
    // when you get back, your cats make some noise
    for (Pet c : tenGoblins)
    {
      if (c != null)
      {
        if (c.getType() == 1)
        {
          c.makeNoise();
        }
      }
    }
    // give all of your pets a treat
    for (Pet p : tenGoblins)
    {
      if (p != null)
      {
        p.feed();
      }
    }
    // groom your cats
    for (Pet c : tenGoblins)
    {
      if (c != null)
      {
        if (c.getType() == 1)
        {
          c.groom();
        }
      } 
    }
    // grooming is done, play with all pets
    for (Pet p : tenGoblins)
    {
      if (p != null)
      {
        p.play();
      }
    }
    // whew, that was tiring, all pets nap and get fed
    for (Pet p : tenGoblins)
    {
      if (p != null)
      {
        p.feed();
        p.sleep();
      }
    }

    // danganronpa
    for (Pet p : pets) 
    {
      if (p != null && p.getName() == "mushroom") 
      {
        p.playDanganronpa();
      }
    }
    System.out.println("--- MY PETS ---");
    // show the state of all of your pets
    for (Pet p : tenGoblins)
    {
      if (p != null)
      {
        System.out.println(p.toString());
      }
    }
    // You decide to get a couple of pets for your friend (does not require looping)
    tenGoblins[4] = new Pet("fish", 1);
    tenGoblins[5] = new Pet("juice", 1);
    tenGoblins[6] = new Pet("box", 2);
    tenGoblins[7] = new Pet("nugget", 2);
    // set the owner of the new pets to your friends name
    for (Pet p : tenGoblins)
    {
      if (p != null && p.getOwner() != "june") // needs to specify getOwner so sam doesnt steal all my pets
      {
        p.setOwner("sam");
      }
    }
    System.out.println("--- MY PETS ---");
    //  show the state of all of your pets
    for (Pet p : tenGoblins)
    {
      if (p != null && p.getOwner() == "june")
      {
        System.out.println(p.toString());
      }
    }
  }
}