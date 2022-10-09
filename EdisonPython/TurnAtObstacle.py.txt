# TurnAtObstacle.py
# Drive until obstacle, turn right and drive to avoid.
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.CM
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

# Turn on obstacle detection
Ed.ObstacleDetectionBeam(Ed.ON)

# Drive forward until an obstacle is detected
while Ed.ReadObstacleDetection() == Ed.OBSTACLE_NONE:
    Ed.Drive(Ed.FORWARD, Ed.SPEED_2, Ed.DISTANCE_UNLIMITED)
    
# Turn right and drive a small amount
Ed.Drive(Ed.SPIN_RIGHT,Ed.SPEED_4,90)   
Ed.Drive(Ed.FORWARD, Ed.SPEED_4, 20)    



        