// Delta College/Team 3770 Robotics Programming
// Contains all constant declarations for port numbers and other
// parameters necessary for robot operation and tuning.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

/* Vendor library URLs 
 * CTRE:   https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix5-frc2023-latest.json
 * 
 * 
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

    // Auton limits
    public static final double SIMPLE_AUTON_DRIVE_TIME    = 3.0;
    public static final double SIMPLE_AUTON_POWER         = 0.5;

    public static final int UTILITY_MOTOR_PORT   = 0;

    public static final int HEAVY_SWITCH_DIG_PORT = 0;
    public static final int LIGHT_SWITCH_DIG_PORT = 1;
        
     public static final int REV_CAN_ID           = 5;

    // Flash duraction on/off time
    public static final double FLASH_TIME                 = 0.5;

    // Pneumatics
    public static final int PNEUMATICS_IN_PORT   = 7;     
    public static final int PNEUMATICS_OUT_PORT  = 4;   

    // LED switch relay port
    public static final int LIGHT_RELAY_PORT     = 0;
}
