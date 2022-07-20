// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {



    public static final int LEFT_MOTOR_PORT  = 0;
    public static final int RIGHT_MOTOR_PORT = 1;

    public static final int CONTROLLER_USB_PORT = 0;

    public static final int CONTROLLER_LEFT_STICK_AXIS  = 1;
    public static final int CONTROLLER_RIGHT_STICK_AXIS = 5;

    public static final int GIZMO_PWM_PORT = 3;

    public static final double ENCODER_INCHES_PER_TICK = 0.00303075;

    public static final double GYRO_PID_P  = 0.006;
    public static final double GYRO_PID_I  = 0.0;
    public static final double GYRO_PID_D  = 0.0;

    public static final double GYRO_PID_TOLERANCE = 1.0;

    public static final double ANGLE_TOLERANCE = 2.0;
    public static final double TURN_TIME_LIMIT = 3.0;
}
