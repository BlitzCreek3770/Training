// Delta College/Team 3770 Robotics Programming
// Contains all constant declarations for port numbers and other
// parameters necessary for robot operation and tuning.

package frc.robot;
import edu.wpi.first.wpilibj.util.Color;

/* Vendor library URLs 
 * CTRE:   https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix5-frc2023-latest.json
 * 
 * Rev:    https://software-metadata.revrobotics.com/REVLib-2023.json
 * 
 * Navx:   https://dev.studica.com/releases/2023/NavX.json

 */
public final class Constants 
{
    // Driver motors
    public static final int LEFT_MOTOR1_CAN_ID   = 2;
    public static final int LEFT_MOTOR2_CAN_ID   = 3;
    public static final int RIGHT_MOTOR1_CAN_ID  = 4;
    public static final int RIGHT_MOTOR2_CAN_ID  = 1;

    // Joystick control
    public static final int LEFT_STICK_USB_PORT  = 0;
    public static final int RIGHT_STICK_USB_PORT = 1;

    // LED switch relay port
    public static final int LIGHT_RELAY_PORT     = 0;

    // Pneumatics
    public static final int PNEUMATICS_IN_PORT   = 7;     
    public static final int PNEUMATICS_OUT_PORT  = 4;   
        
    // Switch sensors
    public static final int HEAVY_SWITCH_DIG_PORT = 0;
    public static final int LIGHT_SWITCH_DIG_PORT = 1;
    
    // Utility motors
    public static final int UTILITY_MOTOR_PORT   = 0;
    public static final int REV_CAN_ID           = 5;
    

    // Definitions to clarify switch usage.  "false" is triggred
    public static final boolean SWITCH_TRIGGERED    = false;
    public static final boolean SWITCH_NOT_TRIGGERED = true;   

    // Gyros PID settings
    public static final double GYRO_PID_TOLERANCE                = 2.0;
    public static final double GYRO_PID_P                        = 0.01;
    public static final double GYRO_PID_I                        = 0.0;
    public static final double GYRO_PID_D                        = 0.0;

    // LimeLight camera PID settings
    public static  final double VISION_X_PID_TOLERANCE = 3.0;    // Absolute vision distance angle range
    public static  final double VISION_PID_P           = 0.06;
    public static  final double VISION_PID_I           = 0.03;
    public static  final double VISION_PID_D           = 0.0025;
    
    // Flash duraction on/off time
    public static final double FLASH_TIME                 = 0.5;

    public static final double SIMPLE_AUTON_DRIVE_TIME    = 3.0;
    public static final double SIMPLE_AUTON_POWER         = 0.5;

    public static  final Color COLOR_BLUE   = new Color(0.143, 0.427, 0.429);
    public static  final Color COLOR_RED    = new Color(0.561, 0.232, 0.114);

    public static final double ENCODER_INCHES_PER_TICK = 0.00303075;

    public static final double TURN_ANGLE_TOLERANCE = 2.0;
    public static final double TURN_TIME_LIMIT      = 3.0;

}
