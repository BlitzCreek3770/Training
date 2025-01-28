// Team 3770 Robotics Programming
// Whirligig Subsystem
// Manages subsystem with one motor controlling a rotating disk.

package frc.robot.subsystems;

// Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants;

public class Whirligig extends SubsystemBase
{
    private VictorSP utilityMotor;

    public Whirligig()
    {
        super();
        utilityMotor = new VictorSP(Constants.UTILITY_MOTOR_PORT);
    }

    public void spinForward()
    {
        utilityMotor.set(1.0);
    }

    public void spinReverse()
    {
        utilityMotor.set(-1.0);
    }

    public void stop()
    {
        utilityMotor.set(0.0);
    }
}
