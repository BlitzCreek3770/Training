// Delta College/Team 3770 Robotics Programming
// Whirl PlungeIn
// Uses the Plunger sybsystem to extend cylinder.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Plunger;

public class PlungeIn extends CommandBase 
{
    Timer actionTimer;
    Plunger plunger;
    
    // ----------------------------------------------------------------------------
    public PlungeIn(Plunger plunger) 
    { 
        actionTimer = new Timer();
        this.plunger = plunger;
    }
    
    // ----------------------------------------------------------------------------
    // Start action timer    
    public void initialize() 
    {
        actionTimer.reset();
        actionTimer.start();
    }

    // ----------------------------------------------------------------------------
    public void execute()  
    {
        plunger.punchIn();
    }

    // ----------------------------------------------------------------------------
    // After timed delay, terminate action
    public boolean isFinished() 
    {
        if (actionTimer.get() > 0.5)
            return true;
        else
            return false;
    }

    protected void end() {  }
    protected void interrupted() {  }
}
