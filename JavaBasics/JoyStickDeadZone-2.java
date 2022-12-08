// This program tests a method that creates a joystick "dead zone" near zero.

import java.util.Random;

public class JoyStickDeadZone 
{
    // Declare constant
    final static double DEAD_SPACE = 0.15;
    
    public static void main(String args[]) 
    {
        Random randomGenerator = new Random();
        double joyStick = 0.0, adjustJoyStick = 0.0;

        // Pick 20 random numbers -1.0...1.0 to simulate joystick usage
        for (int i = 1; i <= 20; i++)
        {
            // Map random number 0.0...1.0 to -1.0...1.0
            joyStickValue = 2 * randomGenerator.nextDouble() - 1.0;
            
            adjustJoyStick = adjustJoyStick(joyStickValue);
            
            System.out.println(String.format("%5.2f  ==>   %5.2f", joyStickValue, adjustJoyStick));
        }
    }
    
    // Method receives a joystick value -1.0...0...1.0.  If within the DEAD_SPACE
    // range of zero, return zero.  Otherwise, return the original joystick value
    public static double adjustJoyStick(double joyStickVal)
    {
        if (Math.abs(TARGET_DISTANCE - dist) < VARIANCE)
            return true;
        else
            return false;
    }
}