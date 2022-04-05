public class ShapeEquals
{
  public static void main(String[] args) 
  {
    Shape shape1 = new Shape();
    shape1.setShape("Triangle", 3);
  
    Shape shape2 = new Shape();
    shape2.setShape("Square", 4);
  
    Shape shape3 = shape1;
    shape3.setShape("Hexagon", 6);

    Shape shape4 = new Shape();
    shape4.setShape("Square", 4);

    Shape shape5 = null;
    
    System.out.println(shape1.getShape());
    System.out.println("1 == 2: " +shape1.equals(shape2));
    System.out.println("1 == 3: " + shape1.equals(shape3));
    System.out.println("4 == 2: " + shape4.equals(shape2));
    System.out.println("5 == 4: " + shape5.equals(shape4));
  }
}
