//

package frc.robot.sensors;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants;

public class RomiEncoders
{
  private  Encoder leftEncoder;
  private  Encoder rightEncoder;

  public RomiEncoders() 
  {
    leftEncoder = new Encoder(4, 5);
    rightEncoder = new Encoder(6, 7);
  }

  public void reset() 
  {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public int getLeftEncoderCount() 
  {
    return leftEncoder.get();
  }

  public int getRightEncoderCount() 
  {
    return rightEncoder.get();
  }

  // Average both encoders and multiply by conversion factor.
  // Returns inches moved since last reset.
  public double getInchesMoved()
  {
    return (rightEncoder.get() + leftEncoder.get()) * Constants.ENCODER_INCHES_PER_TICK;
  }
  
}
