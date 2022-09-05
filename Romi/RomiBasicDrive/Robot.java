// Delta College/Team 3770 Robotics Programming
// Example: MotorOnOff
// Robot control using basic linear tank drive.  One utility motor is turned on
// via a joystick button and off via another.

package frc.robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

public class Robot extends TimedRobot
{
    private Servo motorController1, motorController2;
    private XboxController controlUnit;
    private Spark leftMotor = new Spark(0);
    private Spark rightMotor = new Spark(1);
    
   // Utility variables
    private double left,right;
    Timer autonDriveTimer;

    private final double ZERO_TOLERANCE_LEVEL = 0.10;
    private final int CONTROLLER_LEFT_STICK_AXIS  = 1;
    private final int CONTROLLER_RIGHT_STICK_AXIS = 5;
    
    //-------------------------------------------------
    public void robotInit() 
    {
        motorController1 = new Servo(2);
        motorController2 = new Servo(3);
        // Correct orientation of motor (i.e. direction for positive value)
        controlUnit  = new XboxController(0);  

    }
    
    //---------------------------------------------4----
    public void teleopPeriodic()
    {
        left  = controlUnit.getRawAxis(CONTROLLER_LEFT_STICK_AXIS);
        right = controlUnit.getRawAxis(CONTROLLER_RIGHT_STICK_AXIS);

       // Set drive motors to current stick values
       // Dampen motor values to zero when stick values within 
       // tolerance
       if ( Math.abs(left) > ZERO_TOLERANCE_LEVEL )
       {
           leftMotor.set(-1.0 * left);
       }
       else
       {
           leftMotor.set(0.0);
       }
       if ( Math.abs(right) > ZERO_TOLERANCE_LEVEL )
       {
           rightMotor.set(right);
       }
       else
       {
           rightMotor.set(0.0);
       }

       if (controlUnit.getAButtonPressed())
           motorController1.set(1.0);
       if (controlUnit.getBButtonPressed())
           motorController1.set(0.0);
       if (controlUnit.getXButtonPressed())
           motorController2.set(1.0);
       if (controlUnit.getYButtonPressed())
           motorController2.set(0.0);


    }
     // ----------------------------------------------------------------------------
    // Autonomous Constructor
    public void autonomousInit() 
    { 
        autonDriveTimer = new Timer();
        autonDriveTimer.reset();     // Ready timer - Set to zero
        autonDriveTimer.start();    
    }
    
    // ----------------------------------------------------------------------------
    // Autonomous  Periodic
    // Drive forward at given reduced speed for designated time.  Then stop.
    public void autonomousPeriodic() 
    {
        // Forward 1 second
        if (autonDriveTimer.get() < 3.0)
        {
            leftMotor.set(0.5);
            rightMotor.set(0.5);
            motorController1.set(0.0);
        }
        else
        {
            leftMotor.set(0.0);
            rightMotor.set(0.0);
            motorController1.set(1.0);
        }  
        
    }    
}