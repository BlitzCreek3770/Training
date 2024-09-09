/* 
 Delta College/Team 3770 Robotics Programming
 Example: CamPneumatics
 Basic robot tank drive.  Includes basic pneumatics set up with compressor and
 button control of one cylinder via a double solenoid.
 Activates one basic USB camera.
*/
package frc.robot;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.motorcontrol.Victor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends TimedRobot
{
    // Declare constant values for ports
    private final int LEFT_STICK_USB_PORT         = 0;
    private final int RIGHT_STICK_USB_PORT        = 1;
    private final int CONTROLLER_STICK_USB_PORT   = 2;
    
    private final int RIGHT_MOTOR1_PORT   = 0;
    private final int RIGHT_MOTOR2_PORT   = 1;
    private final int LEFT_MOTOR1_PORT    = 2;
    private final int LEFT_MOTOR2_PORT    = 3;
        
    private final int GAME_CONTROLLER_LEFT_INDEX_BUTTON  = 5;
    private final int GAME_CONTROLLER_RIGHT_INDEX_BUTTON = 6;
    
    private final int IN_PORT  = 7;     // Pneumatics control port to move cylinder IN
    private final int OUT_PORT = 0;     // Pneumatics control port to move cylinder OUT
        
    // Declare objects
    Victor leftMotor1, rightMotor1, leftMotor2, rightMotor2;
    Joystick leftStick, rightStick, gameController;
    
    // Pneumatic actuator control solenoid
    DoubleSolenoid controlSolenoid;
    
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
        
        leftMotor1.setInverted(true);
        leftMotor2.setInverted(true);
        
        leftStick      = new Joystick(LEFT_STICK_USB_PORT);     
        rightStick     = new Joystick(RIGHT_STICK_USB_PORT);
        gameController = new Joystick(CONTROLLER_STICK_USB_PORT);
        
        controlSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,
                                             IN_PORT,OUT_PORT);
        
        // Trigger access to USB camera.  Initializes as robot constructor
        // fired and stream continuously with this one line of code.
        CameraServer.startAutomaticCapture();        
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
        
        // Extend pneumatic arm OUT
        if (gameController.getRawButton(GAME_CONTROLLER_LEFT_INDEX_BUTTON))            
            controlSolenoid.set(DoubleSolenoid.Value.kForward);
            
        // Extend pneumatic arm IN
        else if (gameController.getRawButton(GAME_CONTROLLER_RIGHT_INDEX_BUTTON))       
            controlSolenoid.set(DoubleSolenoid.Value.kReverse);  
    }
    
}