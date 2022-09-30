# PlayBeeps.py
# Demonstrate audio: basic beep, custom beep, and a tone
# FRC 3770 Edison Python Programming
#-------------Setup----------------

import Ed

Ed.EdisonVersion = Ed.V2

Ed.DistanceUnits = Ed.CM
Ed.Tempo = Ed.TEMPO_MEDIUM

#--------Your code below-----------

# Play various tones with 2 seconds in between

Ed.PlayBeep()

Ed.TimeWait(2, Ed.TIME_SECONDS)

Ed.PlayMyBeep(5000)

Ed.TimeWait(2, Ed.TIME_SECONDS)

Ed.PlayTone(Ed.NOTE_C_8,Ed.NOTE_WHOLE)