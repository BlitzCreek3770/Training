// Delta College/Team 3770 Robotics Programming
// Blinger Subsystem
// Manages subsystem that includes a simple electronic relay switch
// that turns an LED strip on/off.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// Imports
import frc.robot.Constants;
import frc.robot.sensors.GyroSensor;  

public class DriveSystem extends SubsystemBase
{
    // Instantiate robot objects by calling constructors
    private TalonSRX leftMotor1,leftMotor2,rightMotor1,rightMotor2;
    private GyroSensor gyro;

    // ----------------------------------------------------------------------------
    public DriveSystem(GyroSensor g) 
    {
       super();   // Connect with Subsystem superclass by calling constructor

       gyro = g;
       
       gyro.resetGyro();
       
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
        //quadradic drive
        if (inputRight >= 0)
        {
            inputRight = inputRight * inputRight;
        }
        else if (inputRight <= 0)
        {
            inputRight = -inputRight * inputRight;
        }

        if (inputLeft >= 0)
        {
            inputLeft = inputLeft * inputLeft;
        }
        else if (inputLeft <= 0)
        {
            inputLeft = -inputLeft * inputLeft;
        }

        //motors
        leftMotor1.set(ControlMode.PercentOutput,inputLeft);
        leftMotor2.set(ControlMode.PercentOutput,inputLeft);
        rightMotor1.set(ControlMode.PercentOutput,inputRight);
        rightMotor2.set(ControlMode.PercentOutput,inputRight); 


     } 

    // ----------------------------------------------------------------------------
     public double getAngle()
     {
        return gyro.getYaw();
     }





}
