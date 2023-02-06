// Delta College/Team 3770 Robotics Programming
// Blinger Subsystem
// Manages subsystem that includes a simple electronic relay switch
// that turns an LED strip on/off.

package frc.robot.subsystems;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay;


public class Blinger extends Subsystem{
    private Relay ledSwitch;

    // ----------------------------------------------------------------------------
    // Constructor - Instantiate motor
    public Blinger()
    {
        super();
        ledSwitch = new Relay(Constants.LIGHT_RELAY_PORT, Relay.Direction.kForward);
    }

    // ----------------------------------------------------------------------------
    // Methods to turn light switch on/off
    public void lightOn()
    {
        ledSwitch.set(Relay.Value.kOn);
    }

    public void lightOff()
    {
        ledSwitch.set(Relay.Value.kOff);
    }

    public void initDefaultCommand() {  }
}
