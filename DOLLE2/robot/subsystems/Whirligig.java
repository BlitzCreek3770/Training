package frc.robot.subsystems;

// Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.DigitalInput; 

public class Whirligig extends SubsystemBase
{
    private VictorSP utilityMotor;
    private DigitalInput heavySwitch, lightSwitch;

    public Whirligig()
    {
        super();

        utilityMotor = new VictorSP(Constants.UTILITY_MOTOR_PORT);

        heavySwitch = new DigitalInput(Constants.HEAVY_SWITCH_DIG_PORT);
        lightSwitch = new DigitalInput(Constants.LIGHT_SWITCH_DIG_PORT);
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

    public boolean getLightSwitchValue()
    {
        return lightSwitch.get();
    }

    public boolean getHeavySwitchValue()
    {
        return heavySwitch.get();
    }

    public void initDefaultCommand() {}
}
