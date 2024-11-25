// FRC Team 3770 - BlitzCreek - OLLE 2020
// Drive Human Command
// Has access to the DriveSystem subsystem.
// Receives joystick values and sets them to
// drive system. It is defined as the default 
// command so it never ends.

package frc.robot.commands;

import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSystem;

public class DriveHuman extends Command 
{
  private final DriveSystem driveSystem;   // Reference to drive system object 
  
  private DoubleSupplier leftStickValue, rightStickValue;

  // ----------------------------------------------------------------------------
  // Constructor
  public DriveHuman(DriveSystem d, DoubleSupplier left, DoubleSupplier right)
  {
    driveSystem = d;

    leftStickValue  = left;
    rightStickValue = right;

    addRequirements(driveSystem);
  }

  // ----------------------------------------------------------------------------
  // Initialization
  @Override
  public void execute()
  {
    driveSystem.drive(rightStickValue.getAsDouble(),leftStickValue.getAsDouble());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return false;
  }
}
