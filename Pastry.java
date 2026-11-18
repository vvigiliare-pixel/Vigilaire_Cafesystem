/**
 * Represents a baked item that can be warmed for an extra fee.
 *
 * @author Vigilaire George C. Viajar Jr.
 * @version 1.0
 */
public class Pastry extends MenuItem {
    /** Fee for warming a pastry, in pesos. */
    private static final double WARMING_FEE = 10;

    /** True if the pastry is warmed. */
    private boolean warmed;

    /**
     * Default constructor. The pastry is not warmed.
     */
    public Pastry() {
        super();
        this.warmed = false;
    }

    /**
     * Parameterized constructor.
     *
     * @param name      the pastry name
     * @param basePrice the base price in pesos
     * @param itemCode  the item code
     * @param warmed    true if the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the price: base price plus a warming fee if warmed.
     *
     * @return the price in pesos
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add the warming fee only when the pastry is warmed
        if (warmed) {
            price += WARMING_FEE;
        }
        return price;
    }

    /**
     * Describes the pastry, adding "(Warmed)" when applicable.
     *
     * @return the description text
     */
    @Override
    public String getDescription() {
        String text = super.getDescription();
        // Mention warming only when it applies
        if (warmed) {
            text += " (Warmed)";
        }
        return text;
    }

    /**
     * Checks whether the pastry is warmed.
     *
     * @return true if warmed
     */
    public boolean isWarmed() {
        return warmed;
    }

    /**
     * Sets whether the pastry is warmed.
     *
     * @param warmed true to warm the pastry
     */
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
