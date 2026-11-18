/**
 * Main class that drives the Campus Cafe Ordering System.
 *
 * @author Vigilaire George C. Viajar Jr.
 * @version 1.0
 */
public class CafeApp {
    /**
     * Program entry point. Builds customers, items, and two orders,
     * then prints both receipts.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Customers built with different constructors
        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");
        Customer guest = new Customer();
        System.out.println("Guest customer (default constructor): " + guest.getName());
        System.out.println();

        // ---- Order 1: parameterized constructors ----
        Beverage latte = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);
        Pastry cookie = new Pastry("Cookie", 30, "P-02", false);

        Order order1 = new Order("1001", ana);
        order1.addItem(latte);
        order1.addItem(ensaymada);
        order1.addItem(adobo);
        order1.addItem(cookie); // fourth item: should be rejected
        order1.printReceipt();

        // ---- Setter rejecting invalid data ----
        Beverage cocoa = new Beverage(); // default constructor
        cocoa.setName("Hot Chocolate");
        cocoa.setItemCode("B-02");
        cocoa.setBasePrice(-5); // rejected
        cocoa.setBasePrice(80); // accepted
        cocoa.setSize("M");
        cocoa.setSize("XL");    // rejected, keeps M
        System.out.println();

        // ---- Order 2: default constructors + setters, with voucher ----
        Meal tapa = new Meal();
        tapa.setName("Beef Tapa");
        tapa.setItemCode("M-02");
        tapa.setBasePrice(130);
        tapa.setExtraSides(-1); // rejected

        Order order2 = new Order("1002", ben);
        order2.addItem(cocoa);
        order2.addItem(tapa);
        order2.printReceipt(20);
    }
}
