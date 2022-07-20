// BlitzCreek 3770 - Romi Testing
// DriveSystem Subsystem
// Controls the drivetrain

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.sensors.RomiGyro;
import edu.wpi.first.wpilibj.Encoder;

// Import Constants
import frc.robot.Constants;

public class DriveSystem extends SubsystemBase
{
  // Define objects
  private Spark leftMotor, rightMotor;

  private  Encoder leftEncoder;
  private  Encoder rightEncoder;

  private RomiGyro gyro;
  
  // ----------------------------------------------------------------------------
  // Constructor
  public DriveSystem()
  {
    leftMotor    = new Spark(Constants.LEFT_MOTOR_PORT);
    rightMotor   = new Spark(Constants.RIGHT_MOTOR_PORT);

    leftEncoder  = new Encoder(4, 5);
    rightEncoder = new Encoder(6, 7);
    
    gyro     = new RomiGyro();
    
    rightMotor.setInverted(true);
  }

  // ----------------------------------------------------------------------------
  // ----------------------------------------------------------------------------
  // DRIVE MOTORS

  // Drives the motors based on input (-1..0..1)
  public void drive(double left, double right)
  {
    leftMotor.set(left);
    rightMotor.set(right);
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
    return gyro.getPIDoutput();
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

