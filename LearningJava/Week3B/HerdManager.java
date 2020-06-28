package mooc.vandy.java4android.gate.logic;

import android.util.Log;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    private static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here

    public void simulateHerd(Random rand)
    {
        int in = HERD;
        int no;
        mOut.println("There are currently "+in+" snails in the pen and "+(HERD - in)+" snails in the pasture");
        for (int i=0;i<MAX_ITERATIONS;i++)
        {
            if(in == 0)
                no = 0;
            else if(HERD == in)
                no = 1;
            else
                no = rand.nextInt(2);

            switch (no)
            {
                case 1:
                    in = in + mEastGate.thru(rand.nextInt(in) + 1);
                    break;
                case 0:
                    in = in + mWestGate.thru(rand.nextInt(HERD - in) + 1);
                    break;
            }
            mOut.println("There are currently "+in+" snails in the pen and "+(HERD - in)+" snails in the pasture");
            Log.d("HerdManager","IN "+in+" OUT "+(HERD - in));
        }
    }

}