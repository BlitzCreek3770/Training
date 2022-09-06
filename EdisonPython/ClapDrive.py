# ClapDrive.py
# Wait for clap to start action.  Then, simply
# drive forward a few inches.
# FRC 3770 Edison Python Programming
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.INCH
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

# Continually read clap sensor.  If no clap, do nothing.
Ed.ReadClapSensor()
while Ed.ReadClapSensor() == False:
    pass

# After clap, perform primary program action.
Ed.Drive(Ed.FORWARD,Ed.SPEED_6,20)
    