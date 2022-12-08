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
            // Map random number 0.0...1.0 to -1.0...1.0
            newShift = 2 * randomGenerator.nextDouble() - 1.0;

            position = moveLifter(position, newShift);
            
            System.out.println(String.format("%5.2f  ==>   %5.2f", joyStick, adjustJoyStick));
        }
    }
    
    public static double moveLifterUp(double position, double shift)
    {
        position = position + shift;
        if (position > TOP_LIMIT)
            position = TOP_LIMIT;
        return position;
    }    
    
    public static double moveLifterDown(double position, double shift)
    {
        position = position - shift;
        if (position < BOTTOM_LIMIT)
            position = BOTTOM_LIMIT;
        return position;
    }
}