package dz_4;

import java.util.Arrays;

public class Main {
     public static void main(String[] args) {
        Customer[] customers = new Customer[2];
        customers[0] = new Customer("Иван Иванов", 30, "123456789");
        customers[1] = new Customer("Петр Петров", 25, "987654321");

        Product[] products = new Product[5];
        products[0] = new Product("Телефон", 10000);
        products[1] = new Product("Ноутбук", 50000);
        products[2] = new Product("Планшет", 15000);
        products[3] = new Product("Наушники", 2000);
        products[4] = new Product("Флешка", 500);

        Order[] orders = new Order[5];

        try {
            orders[0] = makePurchase(customers, products, "Иван Иванов", "Ноутбук", 2);
            orders[1] = makePurchase(customers, products, "Петр Петров", "Телефон", -5);
            orders[2] = makePurchase(customers, products, "Михаил Сидоров", "Флешка", 1);
            orders[3] = makePurchase(customers, products, "Иван Иванов", "Монитор", 1);
            orders[4] = makePurchase(customers, products, "Петр Петров", "Наушники", 10);
        } catch (CustomerException | ProductException | AmountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(Arrays.toString(orders));
        System.out.println("Количество совершенных покупок: " + countPurchases(orders));
    }


    public static Order makePurchase(Customer[] customers, Product[] products, String customerName, String productName, int quantity) {
        Customer customer = findCustomer(customers, customerName);
        if (customer == null) {
            throw new CustomerException("Несуществующий покупатель: " + customerName);
        }

        Product product = findProduct(products, productName);
        if (product == null) {
            throw new ProductException("Несуществующий товар: " + productName);
        }

        if (quantity <= 0 || quantity > 100) {
            System.out.println("Неверное количество товара. Покупка будет совершена в количестве 1");
            quantity = 1;
        }

        return new Order(customer, product, quantity);
    }

    public static Customer findCustomer(Customer[] customers, String customerName) {
        for (Customer customer : customers) {
            if (customer.getFullName().equals(customerName)) {
                return customer;
            }
        }
        return null;
    }

    public static Product findProduct(Product[] products, String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public static int countPurchases(Order[] orders) {
        int count = 0;
        for (Order order : orders) {
            if (order != null) {
                count++;
            }
        }
        return count;
    }
}