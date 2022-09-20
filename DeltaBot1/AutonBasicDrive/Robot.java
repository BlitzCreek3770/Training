// Delta College/Team 3770 Robotics Programming
// Example: BasicAutonDrive
// Includes simple tank drive along with a very basic auton
// routine that drives forward at reduced power for given
// number of seconds.

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot
{
    // Declare constant values for ports
    private final int LEFT_STICK_USB_PORT    = 0;
    private final int RIGHT_STICK_USB_PORT   = 1;
    
    private final int RIGHT_MOTOR1_PORT   = 0;
    private final int RIGHT_MOTOR2_PORT   = 1;
    private final int LEFT_MOTOR1_PORT    = 2;
    private final int LEFT_MOTOR2_PORT    = 3;
    
    // Set constants for autonomous actions.  
    // NOTE: Robot motors inverted in auton for unknown reason.
    // Negative implies FORWARD motion for both motors.
    private final double AUTON_FORWARD_TIME_LIMIT  = 3.0;
    private final double AUTON_MOTOR_FORWARD_POWER = -0.5;  
    
    // Declare objects
    Victor leftMotor1, rightMotor1, leftMotor2, rightMotor2;
    Joystick leftStick, rightStick;
    Timer autonDriveTimer;
    
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
        
        // Ready auton timer
        autonDriveTimer = new Timer();
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
    }

    // ----------------------------------------------------------------------------
    // Autonomous Constructor
    public void autonomousInit() 
    { 
        autonDriveTimer.reset();     // Ready timer - Set to zero
        autonDriveTimer.start();    
    }
    
    // ----------------------------------------------------------------------------
    // Autonomous  Periodic
    // Drive forward at given reduced speed for designated time.  Then stop.
    public void autonomousPeriodic() 
    {
        // Forward 1 second
        if (autonDriveTimer.get() < AUTON_FORWARD_TIME_LIMIT)
        {
            leftMotor1.set(AUTON_MOTOR_FORWARD_POWER);
            leftMotor2.set(AUTON_MOTOR_FORWARD_POWER);
            rightMotor1.set(AUTON_MOTOR_FORWARD_POWER);
            rightMotor2.set(AUTON_MOTOR_FORWARD_POWER);
        }
        else
        {
            leftMotor1.set(0.0);
            leftMotor2.set(0.0);
            rightMotor1.set(0.0);
            rightMotor2.set(0.0);
        }  
    }    
    
}