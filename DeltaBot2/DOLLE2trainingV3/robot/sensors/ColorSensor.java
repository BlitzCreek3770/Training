package frc.robot.sensors;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.I2C;
import frc.robot.Constants;

public class ColorSensor 
{ 
  private  I2C.Port i2cPort;
  private  ColorSensorV3 m_colorSensor;
  private  ColorMatch m_colorMatcher;

  public ColorSensor() 
  {
    i2cPort = I2C.Port.kOnboard;
    m_colorSensor = new ColorSensorV3(i2cPort);
    m_colorMatcher = new ColorMatch();

    m_colorMatcher.addColorMatch(Constants.COLOR_BLUE);
    m_colorMatcher.addColorMatch(Constants.COLOR_RED);
  }

  public String getColor() 
  {
    Color detectedColor = m_colorSensor.getColor();
    
    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == Constants.COLOR_BLUE) {
      colorString = "Blue";
    } else if (match.color == Constants.COLOR_RED) {
      colorString = "Red";
    } else {
      colorString = "Unknown";
    }

    return colorString;
  }

  public String getRGB()
  {
    String RGB = "R: " + Integer.toString(m_colorSensor.getRed()) + " G: " + Integer.toString(m_colorSensor.getGreen()) + " B: " + Integer.toString(m_colorSensor.getBlue());

    return RGB;
  }
}