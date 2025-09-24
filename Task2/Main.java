package Task1.Task2;



import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            System.out.println("\n=== Welcome to Hospital Management System ===");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. EHR Management");
            System.out.println("5.Inventory Management");
            System.out.println("6. Staff Management");
            System.out.println("7.Bill Management");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    patientMenu();
                    break;
                case 2:
                    doctorMenu();
                    break;
                case 3:
                    appointmentMenu();
                    break;

                    case 4:
                        ehrMenu();
                        break;
                case 5:
                    inventoryMenu();
                    break;
                case 6:
                    staffMenu();
                    break;
                case 7:
                    billMenu();
                    break;
                case 8:
                    System.out.println("Thank you! Recover soon.");
                    break;
                default:
                    System.out.println("Invalid choice! Please choose again.");
            }
        }

        sc.close();
    }

    // =================== Patient Module ===================
    public static void patientMenu() {
        Scanner sc = new Scanner(System.in);
        Patient patient = new Patient();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Patient Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    patient.addPatient();
                    break;
                case 2:
                    patient.viewPatient();
                    break;
                case 3:
                    patient.updatePatient();
                    break;
                case 4:
                    patient.deletePatient();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // =================== Doctor Module ===================
    public static void doctorMenu() {
        Scanner sc = new Scanner(System.in);
        Doctor doctor = new Doctor();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Doctor Management ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    doctor.addDoctor();
                    break;
                case 2:
                    doctor.viewDoctor();
                    break;
                case 3:
                    doctor.updateDoctor();
                    break;
                case 4:
                    doctor.deleteDoctor();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // =================== Appointment Module ===================
    public static void appointmentMenu() {
        Scanner sc = new Scanner(System.in);
        Appointment appointment = new Appointment();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Appointment Management ---");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. View Appointments");
            System.out.println("3. Update Appointment");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    appointment.scheduleAppointment();
                    break;
                case 2:
                    appointment.viewAppointments();
                    break;
                case 3:
                    appointment.updateAppointment();
                    break;
                case 4:
                    appointment.cancelAppointment();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    // =================== EHR Module ===================
    public static void ehrMenu() {
        Scanner sc = new Scanner(System.in);
        EHR ehr = new EHR();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- EHR Management ---");
            System.out.println("1. Add EHR");
            System.out.println("2. View EHRs");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    ehr.addEHR();
                    break;
                case 2:
                    ehr.viewEHR();
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    // =================== Staff Module ===================
    public static void staffMenu() {
        Scanner sc = new Scanner(System.in);
        Staff staff = new Staff();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Staff Management ---");
            System.out.println("1. Add Staff");
            System.out.println("2. View Staff");
            System.out.println("3. Update Staff");
            System.out.println("4. Delete Staff");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    staff.addStaff();
                    break;
                case 2:
                    staff.viewStaff();
                    break;
                case 3:
                    staff.updateStaff();
                    break;
                case 4:
                    staff.deleteStaff();
                    break;
                case 5:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    // =================== Inventory Module ===================
    public static void inventoryMenu() {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Inventory Management ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Update Quantity");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    inventory.addInventory();
                    break;
                case 2:
                    inventory.viewInventory();
                    break;
                case 3:
                    inventory.updateInventoryQuantity();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    // =================== Bill Module ===================
    public static void billMenu() {
        Scanner sc = new Scanner(System.in);
        Bill bill = new Bill();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n--- Billing Management ---");
            System.out.println("1. Add Bill");
            System.out.println("2. View Bills");
            System.out.println("3. Update Bill Status");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    bill.addBill();
                    break;
                case 2:
                    bill.viewBills();
                    break;
                case 3:
                    bill.updateBillPaymentStatus();
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }


}
