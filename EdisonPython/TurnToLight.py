# TurnToLight
# Drive, stop and turn toward brightest light
# FRC 3770 Edison Python Programming

#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.INCH
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

Ed.Drive(Ed.FORWARD,Ed.SPEED_4,12)

if Ed.ReadRightLightLevel() > Ed.ReadLeftLightLevel():
    Ed.Drive(Ed.SPIN_RIGHT, Ed.SPEED_3, 90)
else:
    Ed.Drive(Ed.SPIN_LEFT, Ed.SPEED_3, 90)
    
Ed.TimeWait(250, Ed.TIME_MILLISECONDS)
Ed.Drive(Ed.FORWARD,Ed.SPEED_4,6)
Ed.PlayBeep();