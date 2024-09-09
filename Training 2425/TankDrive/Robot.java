/* 
 Delta College/Team 3770 Robotics Programming
 Example: TankDrive
 Basic robot tank drive.  Includes direct access to joystick y-axis values
 to set respective motor speeds. 
 Robot is controlled by two seperate joysticks independently 
 controlling left and right motors.
*/
package frc.robot;

//Imports all basic utilities needed
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
    // Includes speed controllers and joysticks
    private Victor leftMotor1, rightMotor1, leftMotor2, rightMotor2;
    private Joystick leftStick, rightStick;
    
   // Utility variables
    private double left,right;
    
    //-------------------------------------------------
    public void robotInit() 
    {
        // Instantiate robot objects by calling constructors
        leftMotor1  = new Victor(LEFT_MOTOR1_PORT);   
        leftMotor2  = new Victor(LEFT_MOTOR2_PORT);    
        rightMotor1 = new Victor(RIGHT_MOTOR1_PORT);
        rightMotor2 = new Victor(RIGHT_MOTOR2_PORT); 
        
        // Reverse rotation (polarity) of left motor set
        leftMotor1.setInverted(true);
        leftMotor2.setInverted(true);
        
        // Correct orientation of motor (i.e. direction for positive value)
        leftStick  = new Joystick(LEFT_STICK_USB_PORT);     
        rightStick = new Joystick(RIGHT_STICK_USB_PORT);
    }
    
    //-------------------------------------------------
    public void teleopPeriodic()
    {
        // Get joystick values ( [-1,1] )
        left  = leftStick.getY();
        right = rightStick.getY();
        
        // Set drive motors to current joystick values
        leftMotor1.set(left);
        leftMotor2.set(left);
        rightMotor1.set(right);
        rightMotor2.set(right);
        
    }
}