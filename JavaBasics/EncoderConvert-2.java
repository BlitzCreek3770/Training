// Write a program that contains a method that converts encoder
// ticks to inches.  Through testing, 345 ticks == 1 foot.


public class EncoderConvert 
{
    public static final double INCHES_PER_TICK = 0.034783;
    
    public static void main(String args[]) 
    {
        int ticks = 10456;
        double inches;
        
        inches = getInchesMoved(ticks);

        System.out.println(ticks + " ticks = " + inches + " in");
    }
    
    // Convert encoder ticks to inches
    public static double getInchesMoved(int t)
    {
        return t * INCHES_PER_TICK;
    }
}