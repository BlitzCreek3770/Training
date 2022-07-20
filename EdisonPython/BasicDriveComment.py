# Example 1.2
# Demonstrate basic drive - with comments
# FRC 3770 Edison Python Programming

#-------------Setup----------------

import Ed
Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.INCH  # Set units to inches
Ed.Tempo = Ed.TEMPO_MEDIUM  # Medium general robot speed

#--------Your code below-----------
# Drive forward at half speed for 20 inches
Ed.Drive(Ed.FORWARD,Ed.SPEED_5,20)

# Turn right 90 degrees
Ed.Drive(Ed.SPIN_RIGHT, Ed.SPEED_3, 90)

# Drive forward at half speed for 30 inches
Ed.Drive(Ed.FORWARD, Ed.SPEED_5, 15)

# Turn left 90 degrees
Ed.Drive(Ed.SPIN_LEFT, Ed.SPEED_3, 90)

# Drive in reverse at slow speed for 10 inches
Ed.Drive(Ed.BACKWARD, Ed.SPEED_2, 10)