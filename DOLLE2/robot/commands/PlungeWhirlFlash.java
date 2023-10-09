package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Whirligig;
import frc.robot.subsystems.Blinger;
import frc.robot.subsystems.Plunger;

public class PlungeWhirlFlash extends ParallelCommandGroup{
    public PlungeWhirlFlash(Whirligig whirligig, Blinger blinger, Plunger plunger)
    {
        addCommands(//Figure out what addCommands does and ParallelCommandGroup

            new CyclePlunge(plunger),
            new Whirl(whirligig),   
            new Flash(blinger, 5.0) 
            
            );   
    }
}
