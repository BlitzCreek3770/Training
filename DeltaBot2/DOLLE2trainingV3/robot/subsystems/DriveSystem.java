// Delta College/Team 3770 Robotics Programming
// Blinger Subsystem
// Manages subsystem that includes a simple electronic relay switch
// that turns an LED strip on/off.

package frc.robot.subsystems;
import frc.robot.Constants;
import frc.robot.sensors.GyroSensor;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Encoder;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;  

public class DriveSystem extends SubsystemBase
{
    // Instantiate robot objects by calling constructors
    private TalonSRX leftMotor1,leftMotor2,rightMotor1,rightMotor2;

    private  Encoder leftEncoder;
    private  Encoder rightEncoder;

    private GyroSensor gyro;

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

   // ----------------------------------------------------------------------------
  // GYRO

  public double getGyroAngle()
  {
    return gyro.getMeasurement();
  }

  public void enablePID()
  {
    gyro.enable();
  }

  public void disablePID()
  {
    gyro.disable();
  }
  public void setAngleSetpoint(double angle)
  {
    gyro.setSetpoint(angle);
  }

  public double getGyroPIDoutput()
  {
    return gyro.getOutput();
  }



 // ----------------------------------------------------------------------------
  // ----------------------------------------------------------------------------
  // ENCODERS

  public void resetEncoders() 
  {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public int getLeftEncoderCount() 
  {
    return leftEncoder.get();
  }

  public int getRightEncoderCount() 
  {
    return rightEncoder.get();
  }

  // Average both encoders and multiply by conversion factor.
  // Returns inches moved since last reset.
  public double getInchesMoved()
  {
    return (rightEncoder.get() + leftEncoder.get()) * Constants.ENCODER_INCHES_PER_TICK;
  }
}
