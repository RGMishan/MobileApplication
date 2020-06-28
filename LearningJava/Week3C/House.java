package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House
        extends Building {

    // TODO - Put your code here.
    private String owner;
    private boolean pool;

    public House() {
    }

    public House(int length, int width, int lotlength, int lotwidth) {
        super(length, width, lotlength, lotwidth);
    }

    public House(int length, int width, int lotlength, int lotwidth, String owner) {
        this(length, width, lotlength, lotwidth);
        this.owner = owner;
    }

    public House(int length, int width, int lotlength, int lotwidth, String owner, boolean pool) {
        this(length, width, lotlength, lotwidth, owner);
        this.pool = pool;
    }

    public String getOwner() {
        return owner;
    }

    public boolean hasPool() {
        return pool;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    @Override
    public String toString() {
        String sent = "Owner: ";
        if (this.owner.equals("") || this.owner == null)
            sent = sent + "n/a; ";
        else
            sent = sent + owner + "; ";
        if (pool)
            sent = sent + "has a pool; ";
        if (calcLotArea() > calcBuildingArea())
            sent = sent + "has a big open space; ";
        return sent.substring(0, sent.length() - 2);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof House) {
            if (((House) o).calcBuildingArea() == this.calcBuildingArea() && ((House) o).pool)
                return true;
        }
        return false;
    }
}