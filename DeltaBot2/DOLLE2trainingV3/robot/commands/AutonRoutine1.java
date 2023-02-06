// BlitzCreek 3770 - OLLE 2021
// Auton Command
// Basic Auton

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.*;
import edu.wpi.first.wpilibj.Timer;

// Import Subsystems
import frc.robot.subsystems.DriveSystem;

public class AutonRoutine1 extends CommandBase
{
  private DriveSystem driveSystem;
  Timer autonDriveTimer;
  
  public AutonRoutine1(DriveSystem d)
  {
    driveSystem  = d;

    addRequirements(driveSystem);
  }

  // Current Plan:
  // Implementing above code should be easy.
  // The hard part is the first segment. How do I figure out when to stop?

	// ----------------------------------------------------------------------------
  // 
  @Override
  public void initialize() 
  { 
    
    autonDriveTimer = new Timer();
    autonDriveTimer.reset();    
     // Ready timer - Set to zero
    autonDriveTimer.start();   
  }
  
  // ----------------------------------------------------------------------------
  // Called after the first 60 inches are driven and then does fancy stuff for 
  // the rest of Auton GSC.
  @Override
  public void execute()
  {
    driveSystem.drive(0.5,0.5);

    System.out.println(driveSystem.getGyroAngle());
  }

  // ----------------------------------------------------------------------------
  // Return true when timer reaches designated target time.
  @Override
  public boolean isFinished() 
  {
    if (autonDriveTimer.get() > 6.0)
      return true;
    else
      return false;
  }
}