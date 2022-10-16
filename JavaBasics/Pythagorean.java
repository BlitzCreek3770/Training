// Team 3770 Robotics Programming
// Example: Rectangle
// Determine hypotenuse based on sides of a right triangle
public class Pythagorean 
{
   public static void main( String args[] )
   {
      // Declare and initialize variables
      double lengthOfA, lengthOfB, hypotenuse;

      lengthOfA = 6;
      lengthOfB = 4;

      // Find length of hypotenuse
      hypotenuse = Math.sqrt(lengthOfA * lengthOfA + lengthOfB * lengthOfB);
 
      // Print length of hypotenuse
      System.out.println("Hypotenuse: " + hypotenuse);
   }
}

