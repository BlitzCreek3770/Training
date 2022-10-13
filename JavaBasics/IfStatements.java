// Team 3770 Robotics Programming
// Example: IfStatements
// Demonstrates various examples of Java selection (if) control

public class IfStatements
{
   public static void main( String args[] )
   {
      // Variable declarations and display
      int a = 8;
      int b = 3;
      int c = 5;
      System.out.println("a = 8, b = 3, c = 5");
      System.out.println();

      // ----------------------------------------------------

      // Simple if-statements and if-else-statements.
      // Braces optional if only one action after statement.
      if (a > b)
         System.out.println("a > b");

      if (b <= a)
      {
         System.out.println("b <= a");
      }

      if (c >= a)
         System.out.println("b >= a");
      else
         System.out.println("b < a");

      if (b < c)
      {
         System.out.println("b < c");
      }
      else
      {
         System.out.println("b >= c");
      }

      // ----------------------------------------------------

      if (true == true)
      {
         System.out.println(" ");
         System.out.println(" ");
         System.out.println(" ");
      }


      if (true == true)
      {
         System.out.println(" ");
         System.out.println(" ");
         System.out.println(" ");
      }
      else
      {
         System.out.println(" ");
         System.out.println(" ");
         System.out.println(" ");
      }

      // ----------------------------------------------------

   }
}