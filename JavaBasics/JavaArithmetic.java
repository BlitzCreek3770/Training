// Team 3770 Robotics Programming
// Example: BasicConsoleOutput
// Demonstrates basic Java console output

public class JavaArithmetic
{
   public static void main( String args[] )
   {
      // Variable declarations
      int    a, b, c, d;
      double x, y, z;

      // Assignments
      a = 4;
      b = 7;

      x = 2.3;
      y = 6.7;

      // Arithmetic:  addition and subtraction
      c = a + b;   // Addition
      z = y - x;   // Subtraction

      // Display results
      System.out.println();
      System.out.println(a + " + " + b + " = " + c);
      System.out.println(y + " - " + x + " = " + z);

      // Arithmetic:  multiplication and division
      c = a * b;   // Multiplication
      z = y / x;   // Division

      // Display results
      System.out.println();
      System.out.println(a + " * " + b + " = " + c);
      System.out.println(y + " / " + x + " = " + z);

      // Integer arithmetic:  division and modulus
      c = b / a;   // Integer division (not truncation)
      d = b % a;   // Modulus (remainder of long division)

      // Display results
      System.out.println();
      System.out.println(b + " / " + a + " = " + c);
      System.out.println(b + " % " + a + " = " + d);
   }
}