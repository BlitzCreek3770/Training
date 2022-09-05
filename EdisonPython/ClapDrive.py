# ClapDrive.py
# Wait for clap to start action.  Then, simply
# drive forward a few inches.
# FRC 3770 Edison Python Programming
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.CM
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

Ed.ReadClapSensor()
while Ed.ReadClapSensor() != Ed.CLAP_DETECTED:
    pass
Ed.Drive(Ed.FORWARD, Ed.SPEED_10, 15)