package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Revver;
import edu.wpi.first.wpilibj.Timer;

public class Rev extends CommandBase{ 

    private Revver revver;
    private Timer mechanismTimer;

    public Rev(Revver r)
    {
        revver = r;
        mechanismTimer = new Timer();
    }

    @Override
    public void initialize()
    {
        mechanismTimer.reset();
        mechanismTimer.start();
    }

    public void execute()
    {
        revver.spinForward();
    }

    @Override
    public boolean isFinished()
    {
        if (mechanismTimer.get() >= 3.0)
        {
            revver.stop();
            return true;
        }else
        {
            return false;
        }
    }

    protected void end() {  }
    protected void interrupted()
    {
        revver.stop();
    }
}
