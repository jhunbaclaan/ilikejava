/*
* Activity 1.2.3
*
* A Cake class
*/
public class Cake
{    
  String layers = "";
  String candles = "";

  public Cake()
  {
   // default one tier
    oneTier();
  }
  
  public Cake(int t) 
  {
    oneTier(); 
    if (t == 2)
      twoTiers();
    if (t == 3)
      threeTiers();
  }

  public void oneTier()
  {
    layers = "      (~~~~~~~)\n      (       )\n      (~~~~~~~)";
  }

  public void twoTiers()
  {
    layers = "    (**********)\n    (*        *)\n    (*        *)\n";
    layers += "  (**************)\n  (*            *)\n  (*            *)\n  (**************)";
  }

  public void threeTiers()
  {
    layers = "    (**********)\n    (*        *)\n    (*        *)\n";
    layers += "  (**************)\n  (*            *)\n  (*            *)\n";
    layers += "(******************)\n(*                *)\n(*                *)\n(******************)";
  }
  public void addCandles()
  {
    candles = "         ,,,\n         |||";
  }

  public void show()
  {
    System.out.println(candles);
    System.out.println(layers);
  }

}