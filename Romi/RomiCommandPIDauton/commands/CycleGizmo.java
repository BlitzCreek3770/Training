// FRC Team 3770 - BlitzCreek - OLLE 2021
// Prepare to Shoot command
// Prepares shooter motor for shooting.
// Motor speed set using vision feedback.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

// Import Subsystems
import frc.robot.subsystems.Gizmo;

public class CycleGizmo extends CommandBase 
{
  // Set vars
  private final Gizmo   gizmo;

  public        Joystick  leftStick, rightStick;
  public        Timer     delayTimer1,delayTimer2,delayTimer3;

  public        boolean   done1 = false, done2 = false, done3 = false;
  public        double    Distance, RPM;

  private       double WAIT_TIME = 0.8;

  // ----------------------------------------------------------------------------
  // Constructor: Capture time and motor level for straight drive
  public CycleGizmo(Gizmo g)
  {
    gizmo   = g;
    
    addRequirements(gizmo);

    delayTimer1 = new Timer();
    delayTimer2 = new Timer();
    delayTimer3 = new Timer();
  }

  // ----------------------------------------------------------------------------
  // Initialization
  public void initialize() 
  {
    gizmo.setMin();
  }
  
  // --------------------------------------------------------------------------
  // 
  public void execute() 
  {
    if (done1 == false)
    {
      gizmo.setMax();
      delayTimer1.reset();
      delayTimer1.start();
      done1 = true;
    }

    if (done2 == false && done1 == true && delayTimer1.get() >= WAIT_TIME)
    {
      gizmo.setMin();
      delayTimer2.reset();
      delayTimer2.start();
      done2 = true;
    }    

    if (done3 == false && done1 == true && done2 == true && delayTimer2.get() >= WAIT_TIME)
    {
      gizmo.setMax();
      delayTimer3.reset();
      delayTimer3.start();
      done3 = true;
    }      
  }
  
  // --------------------------------------------------------------------------
  // 
  public boolean isFinished() 
  {
    if (done3 == true  && delayTimer3.get() >= WAIT_TIME )
     return true;
    else
      return false;
  }
  
  
}