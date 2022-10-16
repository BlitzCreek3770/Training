// Team 3770 Robotics Programming
// Example: Pythagorean1
// Determine hypotenuse based on sides of a right triangle

import java.util.Scanner;

public class Pythagorean2
{
   public static void main( String args[] )
   {
      // Declare variables
      double lengthOfA, lengthOfB, hypotenuse;

      // Instantiate scanner object for keyboard input
      Scanner keyboard = new Scanner(System.in);

      // Prompt for and read user input
      System.out.print("Enter triangle side A: ");
      lengthOfA = keyboard.nextInt();
      System.out.print("Enter triangle side B: ");
      lengthOfB = keyboard.nextInt();

      // Find length of hypotenuse
      hypotenuse = Math.sqrt(lengthOfA * lengthOfA + lengthOfB * lengthOfB);

      // Print length of hypotenuse
      System.out.println("Hypotenuse: " + hypotenuse);
   }
}
