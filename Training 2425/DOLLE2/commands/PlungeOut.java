// Delta College/Team 3770 Robotics Programming
// Whirl PlungeOut
// Uses the Plunger sybsystem to extend cylinder.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Plunger;

public class PlungeOut extends Command 
{
    Timer actionTimer;
    Plunger plunger;
    
    // ----------------------------------------------------------------------------
    public PlungeOut(Plunger plunger) 
    {
        actionTimer = new Timer(); 
        this.plunger = plunger;
    }
    
    // ----------------------------------------------------------------------------
    public void initialize() 
    { 
        actionTimer.reset();
        actionTimer.start();
    }
    
    // ----------------------------------------------------------------------------
    public void execute()  
    // Execute primary action:  Extend pneumatic cylinder and pause.
    {
        plunger.punchOut();
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() 
    {
        if (actionTimer.get() > 0.5)
            return true;
        else
            return false;
    }
}
