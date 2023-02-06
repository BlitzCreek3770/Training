// Delta College/Team 3770 Robotics Programming
// Plunger Subsystem
// Manages subsystem that includes a simple pneumatic cylinder.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.Constants;

public class Plunger extends Subsystem 
{
    private DoubleSolenoid controlSolenoid;
    
    // ----------------------------------------------------------------------------
    // Constructor - Instantiate solenoid
    public Plunger() 
    {
       super();   // Connect with Subsystem superclass by calling constructor
       controlSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.PNEUMATICS_IN_PORT,Constants.PNEUMATICS_OUT_PORT);
    }
    
    // ----------------------------------------------------------------------------
    // Methods to extend/retract pneumatic cylinder 
    public void punchIn()
    {
        controlSolenoid.set(DoubleSolenoid.Value.kReverse);  // Pneumatics IN
    }  
    
    public void punchOut()
    {
        controlSolenoid.set(DoubleSolenoid.Value.kForward);  // Pneumatics OUT
    }
    
    // ----------------------------------------------------------------------------
    // No default action required for class
    public void initDefaultCommand() { }
}
