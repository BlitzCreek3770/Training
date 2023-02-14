// FRC Team 3770 - BlitzCreek - OLLE 20
// GyroPID subsystem
// Manaages gyro mechanism and PID control with gyro.

package frc.robot.sensors;

import edu.wpi.first.wpilibj.SPI;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;

import edu.wpi.first.math.controller.PIDController;

import frc.robot.Constants;

public class GyroSensor  extends PIDSubsystem 
{ 
	private AHRS gyro;   
	private double pidOutput, currentSetpoint;  

	public GyroSensor() 
	{
        // Initialize gyro
		super( new PIDController(Constants.GYRO_PID_P, Constants.GYRO_PID_I, Constants.GYRO_PID_D) );   

        try {
			gyro = new AHRS(SPI.Port.kMXP);
			resetGyro();
		} catch (RuntimeException ex) 
		{
            System.out.println("Error instantiating navX MXP:  " + ex.getMessage());
        }
	
	}

	// Primary action to get current gyro angle measure.  Defined as abstract and there
	// mandated.  Automatically called periodically.
	public double getYaw() 
	{
    	return gyro.getAngle(); 
	}

	// Zero gyro reading
	public void resetGyro()
	{	
		gyro.reset();
		gyro.zeroYaw();
	}

		// Getter action to retrieve current setpoint
		public double getSetpoint()
		{
			return currentSetpoint;
		}

		// Primary action to get current gyro angle measure.  Defined as abstract and there
	// mandated.  Automatically called periodically.
	@Override
	public double getMeasurement() 
	{
    	return gyro.getAngle(); 
	}

		// Consumes output of PID controller using current set point.  Automatically called
	// periodically.
	@Override
	public void useOutput(double output, double setpoint)
	{
		pidOutput        = output;
		currentSetpoint  = setpoint;
	}

	// Getter action to retrieve calculated PID output.
	public double getOutput()
	{
		return pidOutput;
	}

	
}
