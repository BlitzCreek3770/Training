// BlitzCreek 3770 - OLLE 2021
// Auton Command
// Basic Auton - drive robot forward for designated time

package frc.robot.commands;

// Imports
import frc.robot.subsystems.DriveSystem;
import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;

public class AutonBasic extends Command
{
  private final DriveSystem driveSystem;
  Timer autonDriveTimer;
  
  public AutonBasic(DriveSystem d)
  {
    driveSystem  = d;

    addRequirements(driveSystem);
  }

  // ----------------------------------------------------------------------------
  // 
  @Override
  public void initialize() 
  { 
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
    driveSystem.drive(Constants.SIMPLE_AUTON_POWER,Constants.SIMPLE_AUTON_POWER);
  }

  // ----------------------------------------------------------------------------
  // Return true when timer reaches designated target time.
  @Override
  public boolean isFinished() 
  {
    if (autonDriveTimer.get() > Constants.SIMPLE_AUTON_DRIVE_TIME)
      return true;
    else
      return false;
  }
}