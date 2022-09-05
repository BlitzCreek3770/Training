# LineTurn.py
# Drive until black surface encountered.  Turn
# around and drive away.
# FRC 3770 Edison Python Programming
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.CM
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

Ed.LineTrackerLed(Ed.ON)

 
Ed.Drive(Ed.FORWARD, Ed.SPEED_5, Ed.DISTANCE_UNLIMITED)
	
# While Edison is on a white surface continue forwards
while Ed.ReadLineState() == Ed.LINE_ON_WHITE:
	pass
	
# When Edison is not on a white surface back up and turn around.
# Drive short distance away.
Ed.Drive(0, 0, 0)
Ed.Drive(Ed.BACKWARD, Ed.SPEED_5, 8)
Ed.Drive(Ed.SPIN_RIGHT,Ed.SPEED_3, 180)
Ed.Drive(Ed.FORWARD, Ed.SPEED_5, 12)
