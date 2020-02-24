package frc.robot.components;

import java.util.HashMap;
import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.components.DriverJoystick.TriState;
import frc.robot.logging.LoggableRobotComponent;

public class Intake extends LoggableRobotComponent {
  private VictorSPX outerIntake;
  private VictorSPX innerIntake;
  private VictorSPX indexer;

  public Intake(int outerIntakeID, int innerIntakeID, int indexerID) {
    outerIntake = new VictorSPX(outerIntakeID);
    innerIntake = new VictorSPX(innerIntakeID);
    indexer = new VictorSPX(indexerID);
  }

  private void driveOuterIntake(double power) {
    outerIntake.set(ControlMode.PercentOutput, power * 0.3);
  }

  private void driveInnerIntake(double power) {
    innerIntake.set(ControlMode.PercentOutput, power * 0.3);
  }

  private void driveIndexer(double power) {
    indexer.set(ControlMode.PercentOutput, power * 0.3);
  }
  
  public void drive(TriState outerIntakeState, TriState innerIntakeState, TriState indexerState) {
    driveOuterIntake(outerIntakeState.value);
    driveInnerIntake(innerIntakeState.value);
    driveIndexer(indexerState.value);
  }

  @Override
  public String getComponentName() {
    return "Intake";
  }

  @Override
  public Map<String, Double> getLogs() {
    Map<String, Double> info = new HashMap<>();

    return info;
  }
}