// FRC Team 3770 - BlitzCreek 
// WhirlAlternating Command
// Has access to the Whirligig subsystem.
// Spins disk ("Whirligig") in one direction for a second, pauses,
// and spins for one second in the other direction.  Then,stops.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Whirligig;
import edu.wpi.first.wpilibj.Timer;

public class WhirlAlternating extends Command
{
    private Whirligig whirligig;
    private Timer whirlTimer;

    public WhirlAlternating(Whirligig w)
    {
        whirligig = w;
        whirlTimer = new Timer();
    }

    // To start command, reset and start timer.
    @Override
    public void initialize()
    {
        whirlTimer.reset();
        whirlTimer.start();
    }

    // Method runs periodically while command in action.  Running timer dictates
    // the behavior of the Whirligig object.
    public void execute()
    {
        if (whirlTimer.get() < 1.0) {
            whirligig.spinForward();
        }
        else if (whirlTimer.get() >= 1.0 && whirlTimer.get() > 2.0) {
            whirligig.stop();
        }
        else if (whirlTimer.get() >= 2.0 && whirlTimer.get() < 3.0) {
            whirligig.spinReverse();
        }
        else if (whirlTimer.get() >= 3.0) {
            whirligig.stop();
        }
    }

    // Stop command based on timer.  Return 'true' when command complete
    // and 'false' to allow command to continue.
    @Override
    public boolean isFinished()
    {
        if (whirlTimer.get() >= 3.0) {
            return true;
        }
        else {
            return false;
        }
    }

    // If any other command interrupts this, stop motor.
    protected void interrupted()
    {
        whirligig.stop();
    }
}
