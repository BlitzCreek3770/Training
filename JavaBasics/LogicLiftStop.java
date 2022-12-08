// This program tests a method to perform a logical stop to avoid
// a lifting mechanism from being moved too far up or down.

import java.util.Random;

public class LogicLiftStop 
{
    static final double TOP_LIMIT    = 100.0;
    static final double BOTTOM_LIMIT = 0.0;

    public static void main(String args[]) 
    {
        Random randomGenerator = new Random();
        double position = 0.0;
        double newShift = 0.0;

        // Pick 25 random numbers -1.0...1.0 to simulate joystick usage
        for (int i = 1; i <= 25; i++)
        {
            // Map random number 0.0...1.0 to -100.0...100.0
            newShift = 100.0 * randomGenerator.nextDouble();

            // Randomly select an up or down shift
            if (randomGenerator.nextInt(2) == 1)
            {
                // position = moveLifterUp(position,newShift);
                System.out.print("Shift UP: " + String.format("%5.2f", newShift));
            }
            else
            {
                // position = moveLifterDown(position,newShift);
                System.out.print("Shift DOWN: " + String.format("%5.2f", newShift));
            }
            System.out.println("| New Position: " + String.format("%5.2f", position));
            
        }
    }
    
    
    
    // Enter methods here


}