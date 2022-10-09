# WhileTimed
# Demonstrates a timer-driven action.
# FRC 3770 Edison Python Programming
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.CM
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------
DRIVE_DURATION = 3500  # Milliseconds

# Drive for indicated number of milliseconds
Ed.StartCountDown(DRIVE_DURATION,Ed.TIME_MILLISECONDS)
while Ed.ReadCountDown(Ed.TIME_MILLISECONDS) > 0:
    Ed.Drive(Ed.FORWARD,Ed.SPEED_5,Ed.DISTANCE_UNLIMITED)
Ed.Drive(Ed.STOP,0,0)