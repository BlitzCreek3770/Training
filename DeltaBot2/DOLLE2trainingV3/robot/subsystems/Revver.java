package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;


public class Revver extends Subsystem {
    
    private CANSparkMax revMotor;

    public Revver()
    {
        super();

        revMotor = new CANSparkMax(Constants.REV_CAN_ID, MotorType.kBrushless);   
    }

    public void spinForward()
    {
        revMotor.set(1.0);
    }

    public void spinReverse()
    {
        revMotor.set(-1.0);
    }

    public void stop()
    {
        revMotor.set(0.0);
    }


    public void initDefaultCommand() {}
}
