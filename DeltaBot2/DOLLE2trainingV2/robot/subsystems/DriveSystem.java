// Delta College/Team 3770 Robotics Programming
// Blinger Subsystem
// Manages subsystem that includes a simple electronic relay switch
// that turns an LED strip on/off.

package frc.robot.subsystems;

// Imports
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;  

public class DriveSystem extends SubsystemBase
{
    // Instantiate robot objects by calling constructors
    private TalonSRX leftMotor1,leftMotor2,rightMotor1,rightMotor2;

    // ----------------------------------------------------------------------------
    public DriveSystem() 
    {
       super();   // Connect with Subsystem superclass by calling constructor

        // Instantiate robot objects by calling constructors
        leftMotor1  = new TalonSRX(Constants.LEFT_MOTOR1_CAN_ID);
        leftMotor2  = new TalonSRX(Constants.LEFT_MOTOR2_CAN_ID);
        rightMotor1 = new TalonSRX(Constants.RIGHT_MOTOR1_CAN_ID);
        rightMotor2 = new TalonSRX(Constants.RIGHT_MOTOR2_CAN_ID);

        // Reverse rotation (polarity) of left motor set
        leftMotor1.setInverted(true);
        leftMotor2.setInverted(true);

    }
    
    // ----------------------------------------------------------------------------
    // Manage left and right drive wheels
    // Reversed drive allows backwards driving from a forward reference.
    public void drive(double inputRight, double inputLeft)
    {
        leftMotor1.set(ControlMode.PercentOutput,inputLeft);
        leftMotor2.set(ControlMode.PercentOutput,inputLeft);
        rightMotor1.set(ControlMode.PercentOutput,inputRight);
        rightMotor2.set(ControlMode.PercentOutput,inputRight); 
     } 

    // ----------------------------------------------------------------------------

}
