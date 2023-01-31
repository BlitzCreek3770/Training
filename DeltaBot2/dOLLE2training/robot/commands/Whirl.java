package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Whirligig;
import edu.wpi.first.wpilibj.Timer;

public class Whirl extends CommandBase
{
    private Whirligig whirligig;
    private Timer mechanismTimer;

    public Whirl(Whirligig w)
    {
        whirligig = w;
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
        if (mechanismTimer.get() < 1.0)
        {
            whirligig.spinForward();
        }else if (mechanismTimer.get() >= 1.0 && mechanismTimer.get() > 2.0)
        {
            whirligig.stop();
        }else if (mechanismTimer.get() >= 2.0 && mechanismTimer.get()< 3.0)
        {
            whirligig.spinReverse();
        }else if (mechanismTimer.get() >= 3.0)
        {
            whirligig.stop();
        }
    }

    @Override
    public boolean isFinished()
    {
        if (mechanismTimer.get() >= 3.0)
        {
            return true;
        }else
        {
            return false;
        }
    }

    protected void end() {  }
    protected void interrupted()
    {
        whirligig.stop();
    }
}
