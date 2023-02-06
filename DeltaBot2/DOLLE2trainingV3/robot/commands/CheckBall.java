// Delta College/Team 3770 Robotics Programming
// Whirl PlungeOut
// Uses the Plunger sybsystem to extend cylinder.

package frc.robot.commands;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Plunger;
import frc.robot.sensors.ColorSensor;

public class CheckBall extends CommandBase 
{
    Timer actionTimer;
    Plunger plunger;
    ColorSensor colorSensor;
    boolean isOut, isDone;
    
    // ----------------------------------------------------------------------------
    public CheckBall(Plunger plunger, ColorSensor colorSensor) 
    {
        actionTimer = new Timer(); 
        this.plunger = plunger;
        this.colorSensor = colorSensor;
    }
    
    // ----------------------------------------------------------------------------
    public void initialize() 
    { 
        actionTimer.reset();
        actionTimer.start();
        
        isOut = false;
        isDone = false;
    }
    
    // ----------------------------------------------------------------------------
    public void execute()  
    // Execute primary action:  Extend pneumatic cylinder and pause.
    {
        if (colorSensor.getColor().equals("Red") &&  isOut == false && isDone == false)
        {
            plunger.punchOut();
            isOut = true;
        }
        if (isOut == true && isDone == false && actionTimer.get() > 0.5)
        {
            plunger.punchIn();
            isDone = true;
            isOut = false;
        }

        System.out.println(colorSensor.getRGB());
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() 
    {
        if (isDone == true)
            return true;
        else
            return false;
    }
}
