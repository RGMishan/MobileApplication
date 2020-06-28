package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office
        extends Building {

    // TODO - Put your code here.

    private String businessName;
    private int parkingSpace;
    private static int totalOffice = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        totalOffice++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        this(length, width, lotLength, lotWidth);
        this.businessName = businessName;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpace) {
        this(length, width, lotLength, lotWidth, businessName);
        this.parkingSpace = parkingSpace;
    }

    public String getBusinessName() {
        return businessName;
    }

    public int getParkingSpaces() {
        return parkingSpace;
    }

    public void setParkingSpaces(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public String toString() {
        String sent = "Business: ";
        if (businessName == null || businessName.equals(""))
            sent = sent + "unoccupied";
        else
            sent = sent + businessName;
        if (parkingSpace != 0)
            sent = sent + "; has " + parkingSpace + " parking spaces";
        sent = sent + " (total offices: " + totalOffice + ")";
        return sent;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Office) {
            Office off = (Office) o;
            if (off.calcBuildingArea() == this.calcBuildingArea() && off.getParkingSpaces() == this.getParkingSpaces())
                return true;
        }
        return false;
    }
}