/*----------------------------------------------------------------------------*/
/* Copyright (c) 2014-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package amrelk.fakewpi.first.wpilibj;

import amrelk.fakewpi.first.wpilibj.hal.AnalogJNI;
import amrelk.fakewpi.first.wpilibj.hal.FRCNetComm.tResourceType;
import amrelk.fakewpi.first.wpilibj.hal.HAL;
import amrelk.fakewpi.first.wpilibj.sim.AnalogOutSim;
import amrelk.fakewpi.first.wpilibj.smartdashboard.SendableBuilder;

/**
 * Analog output class.
 */
public class AnalogOutput extends SendableBase {
  private int m_port;
  private int m_channel;

  /**
   * Construct an analog output on a specified MXP channel.
   *
   * @param channel The channel number to represent.
   */
  public AnalogOutput(final int channel) {
    SensorUtil.checkAnalogOutputChannel(channel);
    m_channel = channel;

    final int portHandle = HAL.getPort((byte) channel);
    m_port = AnalogJNI.initializeAnalogOutputPort(portHandle);

    HAL.report(tResourceType.kResourceType_AnalogOutput, channel);
    setName("AnalogOutput", channel);
  }

  @Override
  public void close() {
    super.close();
    AnalogJNI.freeAnalogOutputPort(m_port);
    m_port = 0;
    m_channel = 0;
  }

  /**
   * Get the channel of this AnalogOutput.
   */
  public int getChannel() {
    return m_channel;
  }

  public void setVoltage(double voltage) {
    AnalogJNI.setAnalogOutput(m_port, voltage);
  }

  public double getVoltage() {
    return AnalogJNI.getAnalogOutput(m_port);
  }

  @Override
  public void initSendable(SendableBuilder builder) {
    builder.setSmartDashboardType("Analog Output");
    builder.addDoubleProperty("Value", this::getVoltage, this::setVoltage);
  }

  public AnalogOutSim getSimObject() {
    return new AnalogOutSim(m_channel);
  }
}
