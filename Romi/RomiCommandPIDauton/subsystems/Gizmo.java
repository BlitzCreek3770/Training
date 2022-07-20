// FRC Team 3770 - BlitzCreek - OLLE 2021
// Shooter Subsystem
// Controls the ball shooter system, and 
// utilizes PID controller for motor speed.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

// Import Constants
import frc.robot.Constants;

public class Gizmo extends SubsystemBase 
{
  private Servo gizmoController; 

  // ----------------------------------------------------------------------------
  // Constructor - (Do nothing)
  public Gizmo() 
  {
    gizmoController = new Servo(Constants.GIZMO_PWM_PORT);
  }

  // ----------------------------------------------------------------------------
  public void setMin()
  {
    gizmoController.set(0.0);
  }

  // ----------------------------------------------------------------------------
  public void setMax()
  {
    gizmoController.set(1.0);
  }

}
