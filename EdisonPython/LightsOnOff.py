# LightsOnOff.py
# Demonstrate turning LEDs on and off
# FRC 3770 Edison Python Programming
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.CM
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

Ed.LeftLed(Ed.ON)

Ed.TimeWait(2, Ed.TIME_SECONDS)

Ed.LeftLed(Ed.OFF)
Ed.RightLed(Ed.ON)

Ed.TimeWait(2, Ed.TIME_SECONDS)

Ed.RightLed(Ed.OFF)