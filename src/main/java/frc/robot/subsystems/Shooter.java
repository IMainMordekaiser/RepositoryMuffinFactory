// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import static frc.robot.Constants.SUBSYSTEM.*;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Grabber extends SubsystemBase {
  /** Creates a new Grabber. */
  public WPI_TalonSRX grabber1 = new WPI_TalonSRX(GRABBER1_ID); 
  public WPI_TalonSRX grabber2 = new WPI_TalonSRX(GRABBER2_ID); 
  public Grabber() {}
  public void grab(double speed) {
    grabber1.set(speed);
    grabber2.set(-speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
