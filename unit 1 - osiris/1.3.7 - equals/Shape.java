class Shape
{
  String shapeOf="";
  int numOfSides;
  
  public void setShape(String x, int y)
  {
    shapeOf=x;
    numOfSides = y;
  }
  
  public String getShape()
  {
    return shapeOf;
  }
  
  public int getSides()
  {
    return numOfSides;
  }
  
  public boolean equals(Shape s)
  {
    if (s.shapeOf == null)
    {
      return false;
    }
    else if (s.shapeOf.equals(shapeOf) && s.numOfSides == numOfSides)
    {
      return true;
    }
      return false;
  }
}