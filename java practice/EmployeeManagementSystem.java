import java.util.*;

record Employee(int id, String name, String department, double salary) {
    public void display() {
        System.out.println("---------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs." + salary);
    }
}

public class EmployeeManagementSystem {
    private static final List<Employee> employeeList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> viewAllEmployees();
                case "3" -> searchEmployeeById();
                case "4" -> {
                    System.out.println("\nThank you for using EMS. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n====== Employee Management System ======");
        System.out.println("1. Add New Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Check for duplicate ID
            boolean exists = employeeList.stream().anyMatch(emp -> emp.id() == id);
            if (exists) {
                System.out.println("\n❌ Employee with ID " + id + " already exists.");
                return;
            }

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine().// filepath: c:\Users\SHIVAM\Desktop\java practice\EmployeeManagementSystem.java
import java.util.*;

record Employee(int id, String name, String department, double salary) {
    public void display() {
        System.out.println("---------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs." + salary);
    }
}

public class EmployeeManagementSystem {
    private static final List<Employee> employeeList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addEmployee();
                case "2" -> viewAllEmployees();
                case "3" -> searchEmployeeById();
                case "4" -> {
                    System.out.println("\nThank you for using EMS. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n====== Employee Management System ======");
        System.out.println("1. Add New Employee");
        System.out.println("2. View All Employees");
        System.out.println("3. Search Employee by ID");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Check for duplicate ID
            boolean exists = employeeList.stream().anyMatch(emp -> emp.id() == id);
            if (exists) {
                System.out.println("\n❌ Employee with ID " + id + " already exists.");
                return;
            }

            System.out.print("Enter Employee Name: ");
            String name = scanner.nextLine().trim();

            System.out.print("Enter Department: ");
            String department = scanner.nextLine().
