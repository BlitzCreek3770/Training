// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


import frc.robot.subsystems.*;
import frc.robot.commands.*;
import frc.robot.sensors.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // Instantiate joystick objects
  private final Joystick leftStick  = new Joystick(Constants.LEFT_STICK_USB_PORT);
  private final Joystick rightStick = new Joystick(Constants.RIGHT_STICK_USB_PORT);

  // Instantiate all robot subsystems
  private ColorSensor        colorSensor  = new ColorSensor();

  private final DriveSystem  driveSystem  = new DriveSystem();
  private final Plunger      plunger      = new Plunger();
  private final Blinger      blinger      = new Blinger();
  private final Whirligig    whirligig    = new Whirligig();
  private final Revver       revver       = new Revver();



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // Configure the button bindings
    configureButtonBindings();

    driveSystem.setDefaultCommand(
       new DriveHuman(driveSystem,
                      () -> leftStick.getY(),
                      () -> rightStick.getY()
                      ));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    new JoystickButton(leftStick, 5).whenPressed(new Whirl(whirligig));
    new JoystickButton(leftStick, 3).whenPressed(new PlungeOut(plunger));
    new JoystickButton(leftStick, 4).whenPressed(new PlungeIn(plunger));
    new JoystickButton(leftStick, 6).whenPressed(new Flash(blinger, 5));
    new JoystickButton(rightStick, 3).whenPressed(new PlungeWhirlFlash(whirligig, blinger, plunger));
    new JoystickButton(rightStick, 4).whenPressed(new CyclePlunge(plunger));

    new JoystickButton(rightStick, 5).whenPressed(new CheckBall(plunger,colorSensor));

    new JoystickButton(rightStick, 6).whenPressed(new Rev(revver));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() 
  {
    return new AutonRoutine1(driveSystem);
  }
}
