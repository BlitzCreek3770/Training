// This program tests a sensor input to determine if in-range

import java.util.Random;

public class NearWall 
{
            
    // Declare constants
    
    
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
            // distance = TARGET_DISTANCE + (40.0 * randomGenerator.nextDouble() - 20.0);
            

            // Make method call here

            
            System.out.println(String.format("%5.2f", distance) + " - " + targetInRange);
        }
    }
    
    
    
    // Write method here
    
    
    
}