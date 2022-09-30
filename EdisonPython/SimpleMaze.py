# SimpleMaze.py
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.INCH
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

Ed.Drive(Ed.FORWARD, Ed.SPEED_4, 16)

Ed.Drive(Ed.SPIN_LEFT, Ed.SPEED_3, 90)

Ed.Drive(Ed.FORWARD, Ed.SPEED_4, 12)

Ed.Drive(Ed.SPIN_RIGHT, Ed.SPEED_3, 90)

Ed.Drive(Ed.FORWARD, Ed.SPEED_4, 20)