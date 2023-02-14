// Delta College/Team 3770 Robotics Programming
// Example: CyclePlunge
// Command group that cycles the plunger in and out n times.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.subsystems.DriveSystem;

public class AutonRoutine2 extends SequentialCommandGroup 
{
    public AutonRoutine2(DriveSystem driveSystem)
    {
        addCommands(
                new DriveStraight(driveSystem, -0.50, 300.0, 0.0)
                );
    }
}
