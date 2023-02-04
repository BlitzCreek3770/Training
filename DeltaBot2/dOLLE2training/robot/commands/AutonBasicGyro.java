// BlitzCreek 3770 - OLLE 2021
// Auton Command
// Basic Auton - drive robot forward for designated time

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
// Imports
import frc.robot.subsystems.DriveSystem;

public class AutonBasicGyro extends CommandBase
{
  private final DriveSystem driveSystem;
  Timer autonDriveTimer;
  double autonPowerLeft = 0;
    double autonPowerRight = 0;
  
  public AutonBasicGyro(DriveSystem d)
  {
    driveSystem  = d;

    addRequirements(driveSystem);
  }

  // ----------------------------------------------------------------------------
  // 
  @Override
  public void initialize() 
  { 
    autonPowerLeft = Constants.SIMPLE_AUTON_POWER;
    autonPowerRight = Constants.SIMPLE_AUTON_POWER;

    autonDriveTimer = new Timer();
    autonDriveTimer.reset();     // Ready timer - Set to zero
    autonDriveTimer.start();   
  }
  
  // ----------------------------------------------------------------------------
  // Called after the first 60 inches are driven and then does fancy stuff for 
  // the rest of Auton GSC.
  @Override
  public void execute()
  {
    SmartDashboard.putNumber("gyro", driveSystem.getAngle());

    if (driveSystem.getAngle() >= 5)
    {
      autonPowerRight = autonPowerRight + autonPowerRight * 0.01;
      autonPowerLeft = autonPowerLeft - autonPowerLeft * 0.01;
    }
    else if (driveSystem.getAngle() <= -5)
    {
      autonPowerLeft = autonPowerLeft + autonPowerLeft * 0.01;
      autonPowerRight = autonPowerRight - autonPowerRight * 0.01;
    }
    else
    {
      autonPowerLeft = Constants.SIMPLE_AUTON_POWER;
      autonPowerRight = Constants.SIMPLE_AUTON_POWER;
    }

    driveSystem.drive(-1 * autonPowerRight,-1 * autonPowerLeft);
  }

  // ----------------------------------------------------------------------------
  // Return true when timer reaches designated target time.
  @Override
  public boolean isFinished() 
  {
    if (autonDriveTimer.get() > 12.0)
      return true;
    else
      return false;
  }
}