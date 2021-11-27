// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import static frc.robot.Constants.SUBSYSTEM.JOYSTICK.*;

import frc.robot.commands.Auto;
import frc.robot.commands.DriveStraight;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveBase;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Sucker;
import frc.robot.subsystems.Opener;
import frc.robot.commands.OpenToSuck;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static  final Joystick taycam = new Joystick(Y);
  private final DriveBase drivebase = new DriveBase();
  private final Shooter gibberish = new Shooter();
  private final Opener openeer = new Opener();
  private final Sucker sugma = new Sucker();

  Command drivestraight = new DriveStraight(drivebase, 0.8);
  Command grab = new Shoot(gibberish, 0.1);
  Command opentosuck = new OpenToSuck(openeer, 0.2);
  Command m_auto = new Auto(openeer, gibberish, drivebase, sugma);
  /*Opener opener, Shooter shooter , DriveBase Drive , Sucker sucker */
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
     new JoystickButton(taycam, L1).whenActive(drivestraight);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_auto;
  }
}