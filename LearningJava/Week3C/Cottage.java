package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage
        extends House {

    // TODO - Put your code here.

    private boolean secondFloor;

    public Cottage(int dimension, int lotLength, int lotWidth) {
        super(dimension, dimension, lotLength, lotWidth);
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String owner, boolean secondFloor) {
        this(dimension, lotLength, lotWidth);
        this.secondFloor = secondFloor;
    }

    public boolean hasSecondFloor() {
        return secondFloor;
    }

    @Override
    public String toString() {
        String sent = super.toString();
        if (secondFloor)
            sent = sent + " is a two story cottage";
        else
            sent = sent + " is a cottage";

        return sent;
    }
}