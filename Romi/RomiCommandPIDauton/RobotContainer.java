// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer 
{

  private final XboxController           controller         = new XboxController(Constants.CONTROLLER_USB_PORT);
  private final DriveSystem              driveSystem        = new DriveSystem();
  private final Gizmo                    gizmo              = new Gizmo();




  //private final AutonBasic m_autonCommand = new AutonBasic(driveSystem);
  private final AutonRoutine1 m_autonCommand = new AutonRoutine1(driveSystem);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // Configure the button bindings
    configureButtonBindings();

    driveSystem.setDefaultCommand(new DriveHuman(
      driveSystem,
      () -> -controller.getRawAxis(Constants.CONTROLLER_LEFT_STICK_AXIS),
      () -> -controller.getRawAxis(Constants.CONTROLLER_RIGHT_STICK_AXIS)));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {


     new JoystickButton(controller, XboxController.Button.kA.value).whenPressed(new CycleGizmo(gizmo));
  }


  public Command getAutonomousCommand() 
  {
    // An ExampleCommand will run in autonomous
    return m_autonCommand;
  }
}
