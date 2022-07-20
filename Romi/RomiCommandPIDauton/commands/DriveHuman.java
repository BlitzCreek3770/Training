// BlitzCreek 3770 - OLLE 2021
// DriveHuman Command
// Allows player input of drivetrain

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.CommandBase;

// Import Subsystems
import frc.robot.subsystems.DriveSystem;

public class DriveHuman extends CommandBase 
{
  private final DriveSystem    driveSystem;
  private       DoubleSupplier leftValue, rightValue;

  // ----------------------------------------------------------------------------
  // Constructor
  public DriveHuman(DriveSystem d, DoubleSupplier left, DoubleSupplier right)
  {
    driveSystem = d;

    leftValue   = left;
    rightValue  = right;
    
    addRequirements(driveSystem);
  }

  // ----------------------------------------------------------------------------
  // Action to repeatedly run when command is scheduled.
  @Override
  public void execute()
  {
    driveSystem.drive(leftValue.getAsDouble(), rightValue.getAsDouble());
  }
}
