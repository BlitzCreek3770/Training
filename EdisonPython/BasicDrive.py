# BasicDrive.py
# Demonstrate basic drive: forward, back, and turns
# FRC 3770 Edison Python Programming

#-------------Setup----------------

import Ed
Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.INCH
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------
Ed.Drive(Ed.FORWARD,Ed.SPEED_5,20)
Ed.Drive(Ed.SPIN_RIGHT, Ed.SPEED_3, 90)
Ed.Drive(Ed.FORWARD, Ed.SPEED_5, 15)
Ed.Drive(Ed.SPIN_LEFT, Ed.SPEED_3, 90)
Ed.Drive(Ed.BACKWARD, Ed.SPEED_2, 10)
