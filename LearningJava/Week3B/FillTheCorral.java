package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here

    public void setCorralGates(Gate[] gate, Random selectDirection) {
        for (int i = 0; i < gate.length; i++) {
            int d = selectDirection.nextInt();
            if (d < 0)
                gate[i].setSwing(Gate.OUT);
            else if (d > 0)
                gate[i].setSwing(Gate.IN);
            else if (d == 0)
                gate[i].setSwing(Gate.CLOSED);
        }
    }

    public boolean anyCorralAvailable(Gate[] corral) {
        for (int i = 0; i < corral.length; i++) {
            if (corral[i].getSwingDirection() == Gate.IN)
                return true;
        }
        return false;
    }

    public int corralSnails(Gate[] corral, Random rand) {
        int count = 0;
        int snails = 5;
        while (snails != 0) {
            int gateno = rand.nextInt(corral.length);
            int no = rand.nextInt(snails) + 1;
            snails = snails - corral[gateno].thru(no);
            count++;
        }
        return count;
    }
}