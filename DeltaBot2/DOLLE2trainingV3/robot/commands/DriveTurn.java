// Delta College/Team 3770 Robotics Programming
// Class: DriveTurn
// Command that will control DriveSystem subsystem and use
// gyro measure pivot turn to a desired angle measure.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveSystem;
import frc.robot.Constants;

public class DriveTurn extends CommandBase
{
    // Class member variables
    private double targetAngle;
    private Timer segmentDriveTimer;
    
    double angleRotateMotorAdjust;      // For adjusting left/right motors for angle correction
    double zValue;                      // Parameter for mecanum axis managed by PID
    private double left,right;

    // Robot object referencess required for this action
    private final DriveSystem   driveSystem;  

    //-------------------------------------------------
    // Constructor:  Capture time and motor level for straight drive
    public DriveTurn( DriveSystem d, double angle) 
    {
        // Capture references to existing robot subsystems.  Define them as requirements.
        driveSystem   = d;   
        addRequirements(driveSystem);
        
        targetAngle = angle;   
        segmentDriveTimer = new Timer();
    }

    //-------------------------------------------------
    // Called just before this Command runs the first time
    public void initialize() 
    {
        // Start clock for this action
        segmentDriveTimer.reset(); 
        segmentDriveTimer.start();

        // Initialize gyro and encoder s=ensors
        driveSystem.enablePID();
        driveSystem.setAngleSetpoint(targetAngle);
    }
    
    //-------------------------------------------------
    // Called repeatedly when this Command is scheduled to run
    public void execute() 
    {
        
        angleRotateMotorAdjust = driveSystem.getGyroPIDoutput();
           
        // Adjust left/right motor sets to PID output.  Rotate
        // as needed toward target angle
        left  = +angleRotateMotorAdjust;
        right = -angleRotateMotorAdjust;
    }
    
    //-------------------------------------------------
    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished() 
    {
        // If not get at target angle (within tolerance) AND time limit not
        // reached, continue to update drive system motors.
        if ( driveSystem.getGyroAngle() < Constants.TURN_ANGLE_TOLERANCE  ||  segmentDriveTimer.get() <  Constants.TURN_TIME_LIMIT) 
        {
            driveSystem.drive(left, right);  // Set drive motors to target level
            return false;
        } 
        else
        {
            driveSystem.drive(0.0, 0.0);
            return true;
        }
    }

    //-------------------------------------------------
    protected void end()      { }
    public void interrupted() { }
}