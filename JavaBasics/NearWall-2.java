// This program tests a sensor input to determine if in-range

import java.util.Random;

public class NearWall 
{
    // Declare constants
    final static double TARGET_DISTANCE = 126.5;
    final static double VARIANCE        = 2.3;
    
    public static void main(String args[]) 
    {
        Random randomGenerator = new Random();
        boolean targetInRange = false;
        double distance = 0.0;

        // Pick 10 random numbers within 20 units of TARGET_DISTANCE
        for (int i = 1; i <= 20; i++)
        {
            // Create random number +/- 20.0 from TARGET_DISTANCE
            // Uncomment the next line for testing
            distance = TARGET_DISTANCE + (40.0 * randomGenerator.nextDouble() - 20.0);
            
            targetInRange = inRange(distance);
            
            System.out.println(String.format("%5.2f", distance) + " - " + targetInRange);
        }
    }
    
    // Determine if target in range.  Returns true if so; false otherwise. 
    // Precondition: Constants TARGET_DISTANCE and VARIANCE are defined and in scope.
    public static boolean inRange(double dist)
    {
        if (Math.abs(TARGET_DISTANCE - dist) < VARIANCE)
            return true;
        else
            return false;
    }
}