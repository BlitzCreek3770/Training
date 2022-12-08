// This program converts linear drive to quadratic

import java.util.Random;

public class QuadraticDrive 
{
    public static void main(String args[]) 
    {
        double linJoyStickValue, quadJoyStickValue;
        Random randomGenerator = new Random();
        
        System.out.println("Linear   Quadratic");  // Headings
        
        // Pick 10 random numbers -1.0...1.0 to simulate joystick usage
        for (int i = 1; i <= 10; i++)
        {
            // Map random number 0.0...1.0 to -1.0...1.0
            linJoyStickValue = 2 * randomGenerator.nextDouble() - 1.0;
            
            quadJoyStickValue = quadraticOutput(linJoyStickValue);
            
            System.out.println(String.format("%5.2f      %5.2f", linJoyStickValue, quadJoyStickValue));
        }
    }
    
    // Square the incoming joystick value while retaining sign.
    public static double quadraticOutput(double jStick)
    {
        double returnLevel = 0.0;
        if (jStick > 0.0)
            returnLevel = jStick * jStick;
        else
            returnLevel = -1.0 * jStick * jStick;  
        return returnLevel;
    }
}