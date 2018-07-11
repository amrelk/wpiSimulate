/*----------------------------------------------------------------------------*/
/* Copyright (c) 2008-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package amrelk.fakewpi.first.wpilibj.command;

/**
 * A {@link PrintCommand} is a command which prints out a string when it is initialized, and then
 * immediately finishes. It is useful if you want a {@link CommandGroup} to print out a string when
 * it reaches a certain point.
 */
public class PrintCommand extends InstantCommand {
  /**
   * The message to print out.
   */
  private final String m_message;

  /**
   * Instantiates a {@link PrintCommand} which will print the given message when it is run.
   *
   * @param message the message to print
   */
  public PrintCommand(String message) {
    super("Print(\"" + message + "\"");
    m_message = message;
  }

  @Override
  protected void initialize() {
    System.out.println(m_message);
  }
}
