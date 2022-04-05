/*
 * Activity 3.8.2
 */
public class Traversing2DArrays
{
  public static void main(String[] args)
  {
   String board[][] = { {"close", "quarter"},
                        {"moon", "rock"},
                        {"band", "stand"},
                        {"out", "shine"} }; 
                       
    /* your code here */
    for (String[] row : board)
    {
      for (String str: row)
      {
        System.out.print(str + "\t");
      }
      System.out.println();
    }
    System.out.println("rows in board: " + board.length);
    System.out.println("columns in board: " + board[0].length);

    for (int r = 0; r < board.length; r++) // row major
    {
      for (int c = 0; c < board[0].length; c++)
      {
        System.out.print(board[r][c] + "\t");
      }
      System.out.println();
    }
    for (int r = 0; r < board[0].length; r++) // column major
    {
      for (int c = 0; c < board.length; c++)
      {
        System.out.print(board[c][r] + "\t");
      }
      System.out.println();
    }
  }
}
