package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Plunger;

public class CyclePlunge extends SequentialCommandGroup{
    public CyclePlunge(Plunger plunger)
    {
        addCommands(
            new PlungeIn(plunger),
            new PlungeOut(plunger),
            new PlungeIn(plunger),
            new PlungeOut(plunger)
        );
    }
}
