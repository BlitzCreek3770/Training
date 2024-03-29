// FRC Team 3770 - BlitzCreek - OLLE 20
// GyroPID subsystem
// Manaages gyro mechanism and PID control with gyro.

package frc.robot.sensors;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.controller.PIDController;

import com.kauailabs.navx.frc.AHRS;

import frc.robot.Constants;

public class GyroSensor extends PIDSubsystem 
{ 
	private AHRS gyro;     
	private double pidOutput, currentSetpoint;

	public GyroSensor() 
	{
		super( new PIDController(Constants.GYRO_PID_P, Constants.GYRO_PID_I, Constants.GYRO_PID_D) );   

        // Initialize gyro
        try {
			gyro = new AHRS(SPI.Port.kMXP);
			resetGyro();
		} catch (RuntimeException ex) 
		{
            System.out.println("Error instantiating navX MXP:  " + ex.getMessage());
        }

		getController().setTolerance(Constants.GYRO_PID_TOLERANCE);   // Degree tolerance for set point
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

	// Getter action to retrieve current setpoint
	public double getSetpoint()
	{
		return currentSetpoint;
	}		

	// Zero gyro reading
	public void resetGyro()
	{	
		gyro.reset();
		gyro.zeroYaw();
	}

	// Adjust "P" value
	public void setPvalue(double newP)
	{
		getController().setP(newP);
	}
	
}
