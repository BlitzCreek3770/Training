// This program tests a method that responds to game controller button
// states.

public class ButtonResponse 
{
    public static void main(String args[]) 
    {
        boolean a,b,x,y;
        int aInt,bInt,xInt,yInt;

        // Generate all possible true/false patterns for four
        // variables A, B, X, Y.  Pass to method to test.
        for (aInt = 0; aInt <= 1; aInt++)
            for (bInt = 0; bInt <= 1; bInt++)
                for (xInt = 0; xInt <= 1; xInt++)
                    for (yInt = 0; yInt <= 1; yInt++)
                    {
                        a = (aInt == 1) ? true : false;
                        b = (bInt == 1) ? true : false;
                        x = (xInt == 1) ? true : false;
                        y = (yInt == 1) ? true : false;

                        System.out.print(a + " " + b + " " + x + " " + y + " " );
                        buttonActionsBoolean(a, b, x, y);
                    }
    }

    // Method reacts to button states and writes direction to the output console
    public static void buttonActionsBoolean(boolean A, boolean B, boolean X, boolean Y )
    {


        // Write details of method here





    }
}