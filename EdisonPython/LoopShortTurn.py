# LoopShortTurn
# This program demonstrates a for-loop by performing
# a simple turn action a given number of times
# FRC 3770 Edison Python Programming
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.INCH
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

count = 5

# Turn rignt and pivot back to left the given number
# of times as dicated by the loop
for n in range(count):
    Ed.Drive(Ed.SPIN_RIGHT,Ed.SPEED_3,90)
    Ed.Drive(Ed.FORWARD_LEFT,Ed.SPEED_3,90)