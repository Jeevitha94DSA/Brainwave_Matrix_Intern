package Task1;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ATM SERVICES!");
        System.out.print("Enter your ATM Number: ");
        int atmNumber = scanner.nextInt();
        System.out.print("Enter your ATM Pin: ");
        int atmPin = scanner.nextInt();

        // Validate credentials
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT atm_pin FROM user_accounts WHERE account_number=?")) {
            ps.setInt(1, atmNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next() && rs.getInt("atm_pin") == atmPin) {
                Atminterface operations = new Atmimplementation(atmNumber);

                while (true) {
                    System.out.println("1.Deposit Amount\n2.View Balance\n3.Withdraw Amount\n4.View Mini Statement\n5.Exit");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.print("Enter the amount to be deposited: ");
                            operations.depositAmount(scanner.nextDouble());
                            break;
                        case 2:
                            operations.viewBalance();
                            break;
                        case 3:
                            System.out.print("Enter the amount to be Withdraw: ");
                            operations.withdrawn(scanner.nextDouble());
                            break;
                        case 4:
                            operations.viewMinistatement();
                            break;
                        case 5:
                            System.out.println("Please collect your card.\nThank you for availing ATM servicesq!");
                            System.exit(0);
                        default:
                            System.out.println("Please enter a valid choice!");
                    }
                }
            } else {
                System.out.println("Invalid ATM NUMBER or Pin. Please try again!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
