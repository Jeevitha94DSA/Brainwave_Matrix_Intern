package Task1.Task2;
import java.sql.*;
import java.util.Scanner;
public class Bill {
    static Scanner sc=new Scanner(System.in);
    public static void addBill() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Add Bill ---");

            System.out.print("Patient ID: ");
            int patientId = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine(); // consume newline

            System.out.print("Details (e.g., consultation, tests): ");
            String details = sc.nextLine();

            System.out.print("Payment Status (Paid/Unpaid): ");
            String paymentStatus = sc.nextLine();

            String sql = "INSERT INTO Bill(patient_id, amount, details, payment_status) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patientId);
            ps.setDouble(2, amount);
            ps.setString(3, details);
            ps.setString(4, paymentStatus);

            ps.executeUpdate();
            System.out.println("Bill added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBills() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- All Bills ---");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Bill");

            while (rs.next()) {
                System.out.println("Bill ID: " + rs.getInt("bill_id") +
                        ", Patient ID: " + rs.getInt("patient_id") +
                        ", Amount: " + rs.getDouble("amount") +
                        ", Details: " + rs.getString("details") +
                        ", Payment Status: " + rs.getString("payment_status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void updateBillPaymentStatus() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Update Bill Payment Status ---");

            System.out.print("Enter Bill ID: ");
            int billId = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter new Payment Status (Paid/Unpaid): ");
            String status = sc.nextLine();

            String sql = "UPDATE Bill SET payment_status = ? WHERE bill_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, billId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Bill payment status updated successfully!");
            } else {
                System.out.println("No bill found with this ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
