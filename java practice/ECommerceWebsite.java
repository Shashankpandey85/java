// Console-Based E-Commerce Website in Java
// Basic simulation for resume or learning purpose

import java.util.*;

class Product {
    int id;
    String name;
    double price;

    Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.printf("%d. %s - Rs.%.2f\n", id, name, price);
    }
}

class CartItem {
    Product product;
    int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    double getTotal() {
        return product.price * quantity;
    }
}

public class ECommerceWebsite {
    static List<Product> productList = new ArrayList<>();
    static List<CartItem> cart = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedProducts();
        while (true) {
            System.out.println("\nWelcome to ConsoleCart!");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> displayProducts();
                case "2" -> addToCart();
                case "3" -> viewCart();
                case "4" -> checkout();
                case "5" -> {
                    System.out.println("\nThank you for visiting ConsoleCart!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void seedProducts() {
        productList.add(new Product(1, "Laptop", 49999));
        productList.add(new Product(2, "Smartphone", 19999));
        productList.add(new Product(3, "Headphones", 1499));
        productList.add(new Product(4, "Keyboard", 799));
    }

    static void displayProducts() {
        System.out.println("\nAvailable Products:");
        for (Product p : productList) {
            p.display();
        }
    }

    static void addToCart() {
        displayProducts();
        try {
            System.out.print("Enter Product ID to add: ");
            int id = Integer.parseInt(scanner.nextLine());
            Product selected = productList.stream().filter(p -> p.id == id).findFirst().orElse(null);
            if (selected == null) {
                System.out.println("Product not found.");
                return;
            }
            System.out.print("Enter quantity: ");
            int qty = Integer.parseInt(scanner.nextLine());
            cart.add(new CartItem(selected, qty));
            System.out.println("Added to cart!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\nYour Cart:");
        double total = 0;
        for (CartItem item : cart) {
            System.out.printf("%s x%d = Rs.%.2f\n", item.product.name, item.quantity, item.getTotal());
            total += item.getTotal();
        }
        System.out.printf("\nTotal: Rs.%.2f\n", total);
    }

    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Nothing to checkout.");
            return;
        }
        viewCart();
        System.out.println("\nProceeding to checkout... Payment Successful!");
        cart.clear();
    }
}
