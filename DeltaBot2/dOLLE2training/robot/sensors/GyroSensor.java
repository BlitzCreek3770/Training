// FRC Team 3770 - BlitzCreek - OLLE 20
// GyroPID subsystem
// Manaages gyro mechanism and PID control with gyro.

package frc.robot.sensors;

import edu.wpi.first.wpilibj.SPI;

import com.kauailabs.navx.frc.AHRS;

public class GyroSensor 
{ 
	private AHRS gyro;     

	public GyroSensor() 
	{
        // Initialize gyro
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
	
}
