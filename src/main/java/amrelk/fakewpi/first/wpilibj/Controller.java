/*----------------------------------------------------------------------------*/
/* Copyright (c) 2008-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package amrelk.fakewpi.first.wpilibj;

/**
 * An interface for controllers. Controllers run control loops, the most command are PID controllers
 * and there variants, but this includes anything that is controlling an actuator in a separate
 * thread.
 */
public interface Controller {
  /**
   * Allows the control loop to run.
   */
  void enable();

  /**
   * Stops the control loop from running until explicitly re-enabled by calling {@link #enable()}.
   */
  void disable();
}
