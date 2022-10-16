// Team 3770 Robotics Programming
// Example: IfStatements2
// Demonstrates various examples of Java selection (if) control
// including use of Boolean variables

public class IfStatements2
{
   public static void main(String args[])
   {
      // Variable declarations and display
      boolean x = true;
      boolean y = false;
      System.out.println("x = " + x + ", y = " + y );
      System.out.println();

      // ----------------------------------------------------

      if (x == true || y == true)
         System.out.println("Answer1");
      else
         System.out.println("Answer2");

      if (x == true && y == true)
         System.out.println("Answer3");
      else
         System.out.println("Answer4");

      // ----------------------------------------------------

      double a = 123.45;
      double b = 98.765;
      double c = 678.9;

      if (a < 50)
         System.out.println("Low");
      else if (a < 100)
         System.out.println("Medium");
      else if (a < 200)
         System.out.println("High");
      else
         System.out.println("Error");

      if (a > 100)
      {
         if (b < 100)
            System.out.println("AnswerA");
         else
            System.out.println("AnswerB");
      }
      else
      {
         if (c < 100)
            System.out.println("AnswerC");
         else
            System.out.println("AnswerD");
      }

   }
}