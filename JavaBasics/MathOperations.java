// Team 3770 Robotics Programming
// Example: BasicConsoleOutput
//

public class MathOperations
{
   public static void main( String args[] )
   {
      // Variable declarations
      double a = 6.7;
      double b = 9.2;
      double c, d, e, f;
      double bottom, top;

      // Math operations
      c = Math.sqrt(a * a + b * b);
      System.out.println(c);

      d = Math.round(c);
      System.out.println(d);

      e = Math.pow(3,4);
      System.out.println(e);

      f = Math.abs(-3.5);
      System.out.println(f);

      bottom = Math.floor(3.7);
      top = Math.ceil(3.7);
      System.out.println(bottom + "|" + top);

      bottom = Math.floor(-3.7);
      top = Math.ceil(-3.7);
      System.out.println(bottom + "|" + top);
   }
}