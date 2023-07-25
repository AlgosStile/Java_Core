package dz_4;

class Order {
    private final Customer customer;
    private final Product product;
    private final int quantity;

    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}