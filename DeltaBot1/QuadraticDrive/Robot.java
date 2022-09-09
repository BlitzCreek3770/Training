// Delta College/Team 3770 Robotics Programming
// Example:  QuadraticDrive
// Basic robot tank drive.  Joystick values are accessed.  A quadratic
// speed function is applied to adjust motor control.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Victor;

public class Robot extends TimedRobot
{
    // Declare constant values for ports
    private final int LEFT_STICK_USB_PORT    = 0;
    private final int RIGHT_STICK_USB_PORT   = 1;
    
    private final int RIGHT_MOTOR1_PORT   = 0;
    private final int RIGHT_MOTOR2_PORT   = 1;
    private final int LEFT_MOTOR1_PORT    = 2;
    private final int LEFT_MOTOR2_PORT    = 3;
    
    // Declare robot objects and variables
    Victor leftMotor1, rightMotor1, leftMotor2, rightMotor2;
    Joystick leftStick, rightStick;;
    
    // Declare utility variables
    double left,right;
    
    //-------------------------------------------------
    public void robotInit() 
    {
        // Instantiate robot objects by calling constructors
        leftMotor1  = new Victor(LEFT_MOTOR1_PORT);   
        leftMotor2  = new Victor(LEFT_MOTOR2_PORT);    
        rightMotor1 = new Victor(RIGHT_MOTOR1_PORT);
        rightMotor2 = new Victor(RIGHT_MOTOR2_PORT); 
        
        // Correct orientation of motor (i.e. direction for positive value)
        leftMotor1.setInverted(true);
        leftMotor2.setInverted(true);       
        
        // Instantiate joystick objects
        leftStick  = new Joystick(LEFT_STICK_USB_PORT);     
        rightStick = new Joystick(RIGHT_STICK_USB_PORT);
    }
    
    //-------------------------------------------------
    public void teleopPeriodic()
    {
        // Get joystick y-axis values (-1 ... 0 ... 1)
        left  = leftStick.getY();
        right = rightStick.getY();
        
        // Calculate speed value via method call
        left  = driveCalc(left);
        right = driveCalc(right);
        
        // Set drive motors to current joystick values - for tank drive
        leftMotor1.set(left);
        leftMotor2.set(left);
        rightMotor1.set(right);
        rightMotor2.set(right);
    }
    
    //-------------------------------------------------
    // Convert linear drive to quadratic drive
    // Map -1.0 ... 1.0 input to drive value 0.0 ... 1.0
    public double driveCalc(double input)
    {
        double output = 0;
        
        if(input < 0) 
        {
            output = -input * input;   
        }
        if(input >= 0) 
        {
            output = input * input;
        }
        return output;
    }
    
}