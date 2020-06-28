package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {

    // TODO - Put your code here.

    private int length;
    private int width;
    private int lotLength;
    private int lotWidth;

    public Building() {
    }

    public Building(int length, int width, int lotLength, int lotWidth) {
        this.length = length;
        this.width = width;
        this.lotLength = lotLength;
        this.lotWidth = lotWidth;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getLotLength() {
        return lotLength;
    }

    public int getLotWidth() {
        return lotWidth;
    }

    public void setLength(int l) {
        length = l;
    }

    public void setWidth(int w) {
        width = w;
    }

    public void setLotLength(int ll) {
        lotLength = ll;
    }

    public void setLotWidth(int lw) {
        lotWidth = lw;
    }

    public int calcBuildingArea() {
        return length * width;
    }

    public int calcLotArea() {
        return lotLength * lotWidth;
    }

    @Override
    public String toString() {
        return "";
    }
}