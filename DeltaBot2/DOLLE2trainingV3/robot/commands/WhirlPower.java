package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Whirligig;
import edu.wpi.first.wpilibj.Timer;

public class WhirlPower extends CommandBase{
    private Whirligig whirligig;
    private Timer mechanismTimer;

    public WhirlPower(Whirligig w)
    {
        whirligig = w;
    }

    @Override
    public void initialize()
    {
        mechanismTimer.reset();
        mechanismTimer.start();
    }

    public void execute()
    {
 
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
