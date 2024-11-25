package frc.robot.commands;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Blinger;
import edu.wpi.first.wpilibj.Timer;

public class Flash extends Command{
    private Blinger blinger;
    private Timer flashTimer, actionTimer;
    private boolean lightOn;
    private double flashTotalTime; // Total duration for flash command

    public Flash(Blinger blinger, double time)
    {
        flashTotalTime = time;
        flashTimer = new Timer();
        actionTimer = new Timer();
        this.blinger = blinger;
    }

    public void initialize()
    {
        flashTimer.reset();
        flashTimer.start();
        lightOn = false;

        actionTimer.reset();
        actionTimer.start();
    }

    // ----------------------------------------------------------------------------
    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished()
    {
        if (actionTimer.get() > flashTotalTime)
        {
            blinger.lightOff();
            return true;
        }else
        {
            return false;
        }
    }

    public void execute()
    {
        if (flashTimer.get() > Constants.FLASH_TIME)
        {
            toggleFlash();
            flashTimer.stop();
            flashTimer.reset();
            flashTimer.start();
        }
    }

    // ----------------------------------------------------------------------------
    // Change light switch to opposite state
    public void toggleFlash()
    {
        if (lightOn == true)
        {
            blinger.lightOff();
            lightOn = false;
        }else
        {
            blinger.lightOn();
            lightOn = true;
        }
    }

    // ----------------------------------------------------------------------------
    // No default action required for class
    protected void end() { }
    protected void interrupted() { }
}
