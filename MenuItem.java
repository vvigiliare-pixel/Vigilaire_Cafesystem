/**
 * Abstract parent of all items sold at the campus cafe.
 * It cannot be instantiated directly; each subclass defines its own pricing.
 *
 * @author Vigilaire George C. Viajar Jr.
 * @version 1.0
 */
public abstract class MenuItem {
    /** Display name of the item. */
    protected String name;
    /** Base price of the item in pesos. */
    protected double basePrice;
    /** Unique code of the item, e.g. B-01. */
    private String itemCode;

    /**
     * Default constructor. Sets safe placeholder values.
     */
    public MenuItem() {
        this.name = "Unnamed Item";
        this.basePrice = 0.0;
        this.itemCode = "N/A";
    }

    /**
     * Parameterized constructor.
     *
     * @param name      the item name
     * @param basePrice the base price in pesos
     * @param itemCode  the item code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        this.name = name;
        setBasePrice(basePrice); // reuse the validating setter
        this.itemCode = itemCode;
    }

    /**
     * Computes the final price of this item. Each subclass defines its own rule.
     *
     * @return the final price in pesos
     */
    public abstract double computePrice();

    /**
     * Describes the item using its name and code. Subclasses override this.
     *
     * @return the description text
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /**
     * Gets the item name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the item name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        // Keep the old name if the new one is missing or blank
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cannot be empty.");
        }
    }

    /**
     * Gets the base price.
     *
     * @return the base price in pesos
     */
    public double getBasePrice() {
        return basePrice;
    }

    /**
     * Sets the base price. Negative values are rejected.
     *
     * @param basePrice the new base price
     */
    public void setBasePrice(double basePrice) {
        // A price below zero is invalid, so reject it and keep the old value
        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    /**
     * Gets the item code.
     *
     * @return the item code
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code.
     *
     * @param itemCode the new item code
     */
    public void setItemCode(String itemCode) {
        // Keep the old code if the new one is missing or blank
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        } else {
            System.out.println("Error: item code cannot be empty.");
        }
    }
}
