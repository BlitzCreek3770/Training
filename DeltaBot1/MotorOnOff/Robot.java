// Delta College/Team 3770 Robotics Programming
// Example: MotorOnOff
// Robot control using basic linear tank drive.  One utility motor is turned on
// via a joystick button and off via another.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
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
    private final int UTILITY_MOTOR_PORT  = 4;
    
    // Define joystic button numbers for utility motor and light control
    private final int MOTOR_ON_BUTTON    = 5;    // Left stick
    private final int MOTOR_OFF_BUTTON   = 6;
    private final int LIGHT_ON_BUTTON    = 5;    // Right stick
    private final int LIGHT_OFF_BUTTON   = 6;
    
    // Declare robot objects and variables
    private Victor leftMotor1, rightMotor1, leftMotor2, rightMotor2;
    private Joystick leftStick, rightStick;
    private Relay lightSwitch;
    private Victor utilityMotor;
    
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
        
        // Instantiate utility motor and switch for LED strip
        utilityMotor = new Victor(UTILITY_MOTOR_PORT); 
        lightSwitch = new Relay(0,Relay.Direction.kForward);
    }
    
    //-------------------------------------------------
    public void teleopPeriodic()
    {
        // Get joystick values (-1 ... 0 ... 1)
        left  = leftStick.getY();
        right = rightStick.getY();
        
        // Set drive motors to current joystick values
        leftMotor1.set(left);
        leftMotor2.set(left);
        rightMotor1.set(right);
        rightMotor2.set(right);
        
        //  -------- Listen and react to new events --------
        if (leftStick.getRawButton(MOTOR_ON_BUTTON))   
        {
            utilityMotor.set(1.0);              // Turn motor ON (full)
        }
        else if (leftStick.getRawButton(MOTOR_OFF_BUTTON))
        {
            utilityMotor.set(0.0);              // Turn motor OFF
        } 
        else if (rightStick.getRawButton(LIGHT_ON_BUTTON))   
        {
            lightSwitch.set(Relay.Value.kOn);   // Turn light ON
        }
        else if (rightStick.getRawButton(LIGHT_OFF_BUTTON))   
        {
            lightSwitch.set(Relay.Value.kOff);  // Turn light OFF
        }
    }
}