import java.util.ArrayList;
import java.util.Scanner;

// Patient class
class Patient {
    int id;
    String name;
    int age;
    String gender;
    String diagnosis;

    public Patient(int id, String name, int age, String gender, String diagnosis) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.diagnosis = diagnosis;
    }

    public void displayInfo() {
        System.out.println("\n--- Patient Info ---");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Diagnosis: " + diagnosis);
    }
}

// Main class
public class HospitalManagementSystem {
    static ArrayList<Patient> patientList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int patientIdCounter = 1;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 3);
    }

    public static void addPatient() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter diagnosis: ");
        String diagnosis = sc.nextLine();

        Patient newPatient = new Patient(patientIdCounter++, name, age, gender, diagnosis);
        patientList.add(newPatient);

        System.out.println("Patient added successfully!");
    }

    public static void viewPatients() {
        if (patientList.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient p : patientList) {
                p.displayInfo();
            }
        }
    }
}
