/**
 * Represents the person placing an order.
 * Student customers receive a discount and everyone earns loyalty points.
 *
 * @author Vigilaire George C. Viajar Jr.
 * @version 1.0
 */
public class Customer {
    /** Pesos that must be spent to earn one loyalty point. */
    private static final double PESOS_PER_POINT = 50;

    /** Customer name. */
    private String name;
    /** True if the customer is a student. */
    private boolean student;
    /** Accumulated loyalty points. */
    private int loyaltyPoints;

    /**
     * Default constructor. Creates a non-student "Guest" with no points.
     */
    public Customer() {
        this("Guest", false);
    }

    /**
     * Creates a non-student customer with a name.
     *
     * @param name the customer name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with a name and student status.
     *
     * @param name    the customer name
     * @param student true if the customer is a student
     */
    public Customer(String name, boolean student) {
        this.name = name;
        this.student = student;
        this.loyaltyPoints = 0;
    }

    /**
     * Adds loyalty points directly.
     *
     * @param points the points to add
     */
    public void addPoints(int points) {
        // Ignore negative additions so points never go below zero
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    /**
     * Adds loyalty points based on money spent: 1 point per 50 pesos.
     *
     * @param amountSpent the amount spent in pesos
     */
    public void addPoints(double amountSpent) {
        // Whole points only; the cast drops the remainder
        addPoints((int) (amountSpent / PESOS_PER_POINT));
    }

    /**
     * Gets the customer name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the customer name.
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
     * Checks whether the customer is a student.
     *
     * @return true if a student
     */
    public boolean isStudent() {
        return student;
    }

    /**
     * Sets the student status.
     *
     * @param student true if a student
     */
    public void setStudent(boolean student) {
        this.student = student;
    }

    /**
     * Gets the loyalty points.
     *
     * @return the points
     */
    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    /**
     * Sets the loyalty points. Negative values are rejected.
     *
     * @param loyaltyPoints the new total
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        // Points can never be negative
        if (loyaltyPoints < 0) {
            System.out.println("Error: loyalty points cannot be negative.");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}
