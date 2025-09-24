package Task1.Task2;
import java.sql.*;
import java.util.Scanner;
public class Staff {
    static Scanner sc=new Scanner(System.in);
    public static void addStaff() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Add Staff ---");
            sc.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Role: ");
            String role = sc.nextLine();

            System.out.print("Contact Number: ");
            long contact = sc.nextLong();

            String sql = "INSERT INTO Staff(name, role, contact) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, role);
            ps.setLong(3, contact);

            ps.executeUpdate();
            System.out.println("Staff added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewStaff() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Staff Records ---");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");

            while (rs.next()) {
                System.out.println("Staff ID: " + rs.getInt("staff_id") +
                        ", Name: " + rs.getString("name") +
                        ", Role: " + rs.getString("role") +
                        ", Contact: " + rs.getLong("contact"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateStaff() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Update Staff ---");

            System.out.print("Enter Staff ID to update: ");
            int staffId = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Enter new Role: ");
            String role = sc.nextLine();

            System.out.print("Enter new Contact Number: ");
            long contact = sc.nextLong();

            String sql = "UPDATE Staff SET role = ?, contact = ? WHERE staff_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, role);
            ps.setLong(2, contact);
            ps.setInt(3, staffId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Staff updated successfully!");
            } else {
                System.out.println("No staff found with this ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteStaff() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Delete Staff ---");

            System.out.print("Enter Staff ID to delete: ");
            int staffId = sc.nextInt();

            String sql = "DELETE FROM Staff WHERE staff_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, staffId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Staff deleted successfully!");
            } else {
                System.out.println("No staff found with this ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
