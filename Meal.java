/**
 * Represents a rice meal that can be upsized and given extra sides.
 *
 * @author Vigilaire George C. Viajar Jr.
 * @version 1.0
 */
public class Meal extends MenuItem {
    /** Upsize fee in pesos. */
    private static final double UPSIZE_FEE = 20;
    /** Price per extra side in pesos. */
    private static final double SIDE_FEE = 12;

    /** True if the meal is upsized. */
    private boolean upsized;
    /** Number of extra sides. */
    private int extraSides;

    /**
     * Default constructor. Regular size with no extra sides.
     */
    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    /**
     * Parameterized constructor.
     *
     * @param name       the meal name
     * @param basePrice  the base price in pesos
     * @param itemCode   the item code
     * @param upsized    true if upsized
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides); // validate the count
    }

    /**
     * Computes the price: base + upsize fee + extra sides.
     *
     * @return the price in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice + (SIDE_FEE * extraSides);
        // Add the upsize fee only when upsized
        if (upsized) {
            price += UPSIZE_FEE;
        }
        return price;
    }

    /**
     * Describes the meal with upsize status and number of extra sides.
     *
     * @return the description text
     */
    @Override
    public String getDescription() {
        String status;
        // Show the upsize status as readable text
        if (upsized) {
            status = "Upsized";
        } else {
            status = "Regular";
        }
        String sides = (extraSides == 1) ? "side" : "sides";
        return super.getDescription() + " " + status + ", " + extraSides + " " + sides;
    }

    /**
     * Checks whether the meal is upsized.
     *
     * @return true if upsized
     */
    public boolean isUpsized() {
        return upsized;
    }

    /**
     * Sets whether the meal is upsized.
     *
     * @param upsized true to upsize
     */
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    /**
     * Gets the number of extra sides.
     *
     * @return the extra side count
     */
    public int getExtraSides() {
        return extraSides;
    }

    /**
     * Sets the number of extra sides. Negative values are rejected.
     *
     * @param extraSides the new count
     */
    public void setExtraSides(int extraSides) {
        // Negative side counts make no sense, so keep the old value
        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}
