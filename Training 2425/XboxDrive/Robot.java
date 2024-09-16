/* 
 Delta College/Team 3770 Robotics Programming
 Example: GameDrive
 Basic robot tank drive using game controller joysticks for driving 
*/

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Victor;

public class Robot extends TimedRobot
{
    // Declare constant values for ports
    private final int CONTROLLER_STICK_USB_PORT   = 2;
    
    private final int RIGHT_MOTOR1_PORT   = 0;
    private final int RIGHT_MOTOR2_PORT   = 1;
    private final int LEFT_MOTOR1_PORT    = 2;
    private final int LEFT_MOTOR2_PORT    = 3;
    
    private final int CONTROLLER_LEFT_STICK_AXIS  = 1;
    private final int CONTROLLER_RIGHT_STICK_AXIS = 5;
    
    /*  
     Define level for engaging drive controller.  To prevent
     motor action for near-zero values, drive motors will only
     engage for stick values that exceed this percentage.
    */
    private final double ZERO_TOLERANCE_LEVEL = 0.10;
    
    // Declare objects
    Victor leftMotor1, rightMotor1, leftMotor2, rightMotor2;
    Joystick controlUnit;
    
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
        controlUnit  = new Joystick(CONTROLLER_STICK_USB_PORT);     
    }
    
    //-------------------------------------------------
    public void teleopPeriodic() 
    {
        // Get drive stick values ( [-1, 1 ] ) from game controller
        left  = controlUnit.getRawAxis(CONTROLLER_LEFT_STICK_AXIS);
        right = controlUnit.getRawAxis(CONTROLLER_RIGHT_STICK_AXIS);
        
        // Set drive motors to current stick values
        // Dampen motor values to zero when stick values within 
        // tolerance
        if (Math.abs(left) > ZERO_TOLERANCE_LEVEL)
        {
            leftMotor1.set(left);
            leftMotor2.set(left);
        }
        else
        {
            leftMotor1.set(0.0);
            leftMotor2.set(0.0);
        }
        if (Math.abs(right) > ZERO_TOLERANCE_LEVEL)
        {
            rightMotor1.set(right);
            rightMotor2.set(right);
        }
        else
        {
            rightMotor1.set(0.0);
            rightMotor2.set(0.0);
        }
    }
}