// Delta College/Team 3770 Robotics Programming
// Class: DriveStraight
// Command that will control DriveSystem subsystem and use
// encoder measure to drive a given distance in inches.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveSystem;

public class DriveStraight extends CommandBase 
{
    // Class member objects
    private DriveSystem driveSystem;

    // Required work variables
    private double targetDistance;
    private double powerLevel;
    private double targetAngle;
    private Timer segmentDriveTimer;
 
    private double angleMotorAdjust;  // For adjusting left/right motors for angle correction
    
    // Utility variables
    private double left, right, percentage;   
    
    private final double TIME_LIMIT            = 10.0;   // Set time limit in event distance not reached
    private final double DISTANCE_TOLERANCE    = 3.0;    // Absolute distance tolerance
    private final double RAMP_UP_TIME          = 1.0;    // Time to ramp up speed in auton
    private final double RAMP_DOWN_DIST        = 8.0;    // Distance (inches) to target to decelerate

    //-------------------------------------------------
        // Constructor:  Capture time and motor level for straight drive
    public DriveStraight(DriveSystem ds, double power, double distance, double angle) 
    {
        // Ready required subsystems
        driveSystem = ds;
        targetAngle = angle;
        addRequirements(driveSystem);

        // Capture key parameters of drive sebment
        targetDistance = distance;   
        powerLevel     = power;

        // Instantiate emergency stop timer
        segmentDriveTimer = new Timer();
    }

    //-------------------------------------------------
         // Called just before this Command runs the first time
         @Override
         public void initialize() 
    {
        // Start emergency stop timer for this action
        segmentDriveTimer.reset(); 
        segmentDriveTimer.start();
        
        // Initialize gyro and encoder s=ensors
        driveSystem.enablePID();
        driveSystem.setAngleSetpoint(targetAngle);

        driveSystem.resetEncoders();
    }
    
    //-------------------------------------------------
    @Override
    public void execute()
    {
        // Periodic action that runs while distance to targe exceeds tolerance.
        if (Math.abs(targetDistance - driveSystem.getInchesMoved()) > DISTANCE_TOLERANCE) 
        {
            // Get motor adjustment derived from gyro.  This keeps driving in straight line.
            angleMotorAdjust = driveSystem.getGyroPIDoutput();
            
            left  = powerLevel + angleMotorAdjust;
            right = powerLevel - angleMotorAdjust;

System.out.print("Adjust:  " + angleMotorAdjust + " | " );


            
            // If just starting segment, ramp up gradually (linearly) over time period
            // If within given distance to target, begin ramping speed down linearly.
            if (segmentDriveTimer.get() < RAMP_UP_TIME)               // Handle gradual ramp down
            {
                percentage = segmentDriveTimer.get() / RAMP_UP_TIME;
                left = percentage * left;
                right = percentage * right;

System.out.print("RAMP_UP ==> ");
            }   
            else if (targetDistance - driveSystem.getInchesMoved() <= RAMP_DOWN_DIST)  // Handle gradual ramp down
            {
                percentage = (targetDistance - driveSystem.getInchesMoved()) / RAMP_DOWN_DIST;
                left = percentage * left;
                right = percentage * right;

System.out.print("RAMP_DOWN ==> ");
            } 

        }
    }
    
    //-------------------------------------------------
    @Override
    public boolean isFinished() 
    {
        // Continue driving until encoder measure OR emergency timer terminates action 
        if ( driveSystem.getInchesMoved() < targetDistance && segmentDriveTimer.get() < TIME_LIMIT) 
        {
System.out.println("Left:  " + left + " | " + "Right: " + right);
            driveSystem.drive(left, right);  // Set drive motors to target level
            return false;
        }
        else
        {
            driveSystem.drive(0.0, 0.0);
            driveSystem.disablePID();
            return true;
        }
    }

    //-------------------------------------------------
    // Method not needed
    protected void end()  {  }
}

