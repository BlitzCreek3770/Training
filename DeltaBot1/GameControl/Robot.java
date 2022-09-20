// Delta College/Team 3770 Robotics Programming
// Example: GameControl
// Basic robot tank drive using game controller joysticks for driving 

package frc.robot;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;

public class Robot extends TimedRobot
{
    // Declare constant values for ports
    private final int LEFT_STICK_USB_PORT         = 0;
    private final int RIGHT_STICK_USB_PORT        = 1;
    private final int CONTROLLER_STICK_USB_PORT   = 2;
    
    // Define port numbers for motor and light connections
    private final int RIGHT_MOTOR1_PORT    = 0;
    private final int RIGHT_MOTOR2_PORT    = 1;
    private final int LEFT_MOTOR1_PORT     = 2;
    private final int LEFT_MOTOR2_PORT     = 3;
    private final int UTILITY_MOTOR_PORT   = 4;
    private final int SERVO_MOTOR_PWM_PORT = 9;
    private final int RELAY_PORT           = 0;
    
    // Define game controller button numbers for controls
    private final int MOTOR_ON_BUTTON    = 1;   
    private final int MOTOR_OFF_BUTTON   = 2;
    private final int LIGHT_ON_BUTTON    = 3;    
    private final int LIGHT_OFF_BUTTON   = 4;
    private final int SERVO_MIN_BUTTON   = 5;    
    private final int SERVO_MAX_BUTTON   = 6;  
    
    // Declare objects
    private Victor leftMotor1, rightMotor1, leftMotor2, rightMotor2;
    private Joystick leftStick, rightStick, controlUnit;
    private Victor utilityMotor;
    private Servo servoMotor;
    private Relay lightSwitch;
    
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
        
        // Instantiate joystick and game controller objects
        leftStick    = new Joystick(LEFT_STICK_USB_PORT);     
        rightStick   = new Joystick(RIGHT_STICK_USB_PORT);
        controlUnit  = new Joystick(CONTROLLER_STICK_USB_PORT);  
        
        // Instantiate utility motors and switch for LED strip
        utilityMotor = new Victor(UTILITY_MOTOR_PORT); 
        lightSwitch = new Relay(RELAY_PORT,Relay.Direction.kForward);
        servoMotor = new Servo(SERVO_MOTOR_PWM_PORT);
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
        if (controlUnit.getRawButton(MOTOR_ON_BUTTON))   
        {
            utilityMotor.set(1.0);              // Turn motor ON (full)
        }
        else if (controlUnit.getRawButton(MOTOR_OFF_BUTTON))
        {
            utilityMotor.set(0.0);              // Turn motor OFF
        } 
        else if (controlUnit.getRawButton(LIGHT_ON_BUTTON))   
        {
            lightSwitch.set(Relay.Value.kOn);   // Turn light ON
        }
        else if (controlUnit.getRawButton(LIGHT_OFF_BUTTON))   
        {
            lightSwitch.set(Relay.Value.kOff);  // Turn light OFF
        }
        else if (controlUnit.getRawButton(SERVO_MAX_BUTTON))  // Engage servo to MAX
        {
            servoMotor.set(1.0);
        }
        else if (controlUnit.getRawButton(SERVO_MIN_BUTTON))  // Engage servo to MIN
        {
            servoMotor.set(0.0);
        }
    }
}