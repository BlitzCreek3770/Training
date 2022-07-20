// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.sensors;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.hal.SimDevice.Direction;
import edu.wpi.first.hal.SimDouble;
import edu.wpi.first.math.MathUtil;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;

public class RomiGyro extends PIDSubsystem
{
  private SimDouble simAngleZ;

  private double pidOutput;


  /** Create a new RomiGyro. */
  public RomiGyro() 
  {
    super(new PIDController(Constants.GYRO_PID_P, Constants.GYRO_PID_I, Constants.GYRO_PID_D));  
    this.setSetpoint(0.0);

    // Set default tolerance and PID parameter(s)
    getController().setTolerance(Constants.GYRO_PID_TOLERANCE);  
    getController().setP(Constants.GYRO_PID_P);
    getController().enableContinuousInput(-180, 180);

    SimDevice gyroSimDevice = SimDevice.create("Gyro:RomiGyro");
    if (gyroSimDevice != null) {
      gyroSimDevice.createBoolean("init", Direction.kOutput, true);
      simAngleZ = gyroSimDevice.createDouble("angle_z", Direction.kInput, 0.0);
    }
  }

  // --------------------------------------------------------------------------
  public double getAngleZ() 
  {
    if (simAngleZ != null) {

      return simAngleZ.get();
  
    }

    return 0.0;
  }

  // --------------------------------------------------------------------------
  public double getGyroAngle()
  {
    if (simAngleZ != null) 
    {
      return simAngleZ.get();
    }
    return 0.0;
  }

  /** Reset the gyro angles to 0. */
  public void reset() 
  {
   
    

  }

  // --------------------------------------------------------------------------
	//  Adjust "P" value
	public void setPvalue(double newP)    
	{
		getController().setP(newP);
	}

  // --------------------------------------------------------------------------
	// Returns Yaw measurement of Gyroscope in degrees.
	@Override
	public double getMeasurement() 
	{
    System.out.print("Gyro ==> "+this.getGyroAngle() + " | ");
		return this.getGyroAngle(); 
  }

  // --------------------------------------------------------------------------
	// Consumes output of PID controller using current set point.
	@Override
	public void useOutput(double output, double setpoint)
	{
    pidOutput = MathUtil.clamp(getController().calculate(this.getGyroAngle(), setpoint), -0.5, 0.5);
	}

  // --------------------------------------------------------------------------
  public double getPIDoutput()
	{
		return pidOutput;
	}

}
