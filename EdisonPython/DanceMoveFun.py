# DanceMoveFun.py
# Dancemove actions are defined in a function. 
# FRC 3770 Edison Python Programming
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.CM
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

def danceMove():
    Ed.Drive(Ed.FORWARD_RIGHT,4,50)
    Ed.Drive(Ed.BACKWARD_RIGHT,4,50)
    Ed.Drive(Ed.FORWARD_LEFT,4,50)
    Ed.Drive(Ed.BACKWARD_LEFT,4,50)
    Ed.Drive(Ed.SPIN_RIGHT,6,360)
    Ed.PlayBeep()
    Ed.LeftLed(Ed.ON)
    Ed.RightLed(Ed.ON)
    Ed.TimeWait(300,Ed.TIME_MILLISECONDS)
    Ed.LeftLed(Ed.OFF)
    Ed.RightLed(Ed.OFF)
    
danceMove()