# TestProgram
# Run various features on robot for general testing
# FRC 3770 Edison Python Programming

#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.TIME
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

# Run misc. robot actions indefinitely
while True:
	Ed.PlayBeep()
	Ed.LeftLed(Ed.OFF)
	Ed.RightLed(Ed.ON)
	Ed.Drive(Ed.SPIN_RIGHT, 5, 350)
	Ed.TimeWait(300, Ed.TIME_MILLISECONDS)
	Ed.Drive(Ed.FORWARD,5,500)
	Ed.TimeWait(300, Ed.TIME_MILLISECONDS)
	Ed.PlayBeep()
	Ed.LeftLed(Ed.ON)
	Ed.RightLed(Ed.OFF)
	Ed.Drive(Ed.SPIN_LEFT, 5, 350)
	Ed.TimeWait(300, Ed.TIME_MILLISECONDS)
	Ed.Drive(Ed.BACKWARD,2,500)
	Ed.TimeWait(300, Ed.TIME_MILLISECONDS)
	