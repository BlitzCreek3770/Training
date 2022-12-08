// This program tests a method that creates a joystick "dead zone" near zero.

import java.util.Random;

public class JoyStickDeadZone 
{

    // Declare constant here
    
    
    public static void main(String args[]) 
    {
        Random randomGenerator = new Random();
        double joyStick = 0.0, adjustJoyStick = 0.0;

        // Pick 25 random numbers -1.0...1.0 to simulate joystick usage
        for (int i = 1; i <= 25; i++)
        {
            // Map random number 0.0...1.0 to -1.0...1.0
            joyStick = 2 * randomGenerator.nextDouble() - 1.0;
            
            
            
            // Add method call here
            
            
            
            System.out.println(String.format("%5.2f  ==>   %5.2f", joyStick, adjustJoyStick));
        }
    }
    
    
    
    // Add method here
    
    
    
}