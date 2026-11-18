/**
 * Connects a Customer to up to three MenuItem objects.
 * Items are stored in separate fields (no arrays or collections).
 *
 * @author Vigilaire George C. Viajar Jr.
 * @version 1.0
 */
public class Order {
    /** Maximum number of items per order. */
    private static final int MAX_ITEMS = 3;
    /** Student discount rate (10%). */
    private static final double STUDENT_DISCOUNT = 0.10;

    /** The customer who placed the order. */
    private Customer customer;
    /** First item slot. */
    private MenuItem item1;
    /** Second item slot. */
    private MenuItem item2;
    /** Third item slot. */
    private MenuItem item3;
    /** Number of items currently in the order. */
    private int itemCount;
    /** Order identifier. */
    private String orderId;

    /**
     * Creates an empty order for a customer.
     *
     * @param orderId  the order id
     * @param customer the customer placing the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.itemCount = 0;
    }

    /**
     * Adds an item to the first empty slot.
     *
     * @param item the item to add
     * @return true if added, false if the order is already full
     */
    public boolean addItem(MenuItem item) {
        // Place the item in the first empty slot
        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        } else {
            // All three slots are taken
            System.out.println("Order is full. Cannot add " + item.getName()
                    + " [" + item.getItemCode() + "].");
            return false;
        }
        itemCount++;
        return true;
    }

    /**
     * Sums the price of every non-null item (polymorphic calls).
     *
     * @return the subtotal in pesos
     */
    public double computeSubtotal() {
        double subtotal = 0;
        // Skip empty slots
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    /**
     * Computes the student discount amount.
     *
     * @return the discount in pesos (0 for non-students)
     */
    public double computeDiscount() {
        // Only students get the 10% discount
        if (customer.isStudent()) {
            return computeSubtotal() * STUDENT_DISCOUNT;
        } else {
            return 0;
        }
    }

    /**
     * Computes the total after the student discount.
     *
     * @return the total in pesos
     */
    public double computeTotal() {
        return computeSubtotal() - computeDiscount();
    }

    /**
     * Computes the total after the student discount and a voucher.
     * The total never goes below zero.
     *
     * @param voucher the voucher amount in pesos
     * @return the total in pesos
     */
    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;
        // Never let the total go negative
        if (total < 0) {
            return 0;
        } else {
            return total;
        }
    }

    /**
     * Prints the receipt without a voucher and updates the customer's points.
     */
    public void printReceipt() {
        printReceipt(0);
    }

    /**
     * Prints the receipt with a voucher and updates the customer's points.
     *
     * @param voucher the voucher amount in pesos (0 for none)
     */
    public void printReceipt(double voucher) {
        String tag;
        // Label student customers on the header
        if (customer.isStudent()) {
            tag = " (Student)";
        } else {
            tag = "";
        }
        System.out.println("Order #" + orderId + " - " + customer.getName() + tag);
        printLine(item1);
        printLine(item2);
        printLine(item3);
        System.out.printf("  Subtotal: %.2f%n", computeSubtotal());
        // Show the discount line only for students
        if (customer.isStudent()) {
            System.out.printf("  Student discount (10%%): -%.2f%n", computeDiscount());
        }
        // Show the voucher line only when one is used
        if (voucher > 0) {
            System.out.printf("  Voucher: -%.2f%n", voucher);
        }
        double total = computeTotal(voucher);
        System.out.printf("  TOTAL: %.2f%n", total);
        customer.addPoints(total); // object interaction: Order updates Customer
        System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println();
    }

    /**
     * Prints one item line if the slot is not empty.
     *
     * @param item the item to print (may be null)
     */
    private void printLine(MenuItem item) {
        // Empty slots print nothing
        if (item != null) {
            System.out.printf("  %-45s %7.2f%n", item.getDescription(), item.computePrice());
        }
    }

    /**
     * Gets the customer.
     *
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Gets the number of items in the order.
     *
     * @return the item count
     */
    public int getItemCount() {
        return itemCount;
    }

    /**
     * Gets the order id.
     *
     * @return the order id
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Sets the order id.
     *
     * @param orderId the new order id
     */
    public void setOrderId(String orderId) {
        // Keep the old id if the new one is missing or blank
        if (orderId != null && !orderId.trim().isEmpty()) {
            this.orderId = orderId;
        } else {
            System.out.println("Error: order id cannot be empty.");
        }
    }
}
