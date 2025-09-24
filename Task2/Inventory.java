package Task1.Task2;

import java.sql.*;
import java.util.Scanner;
public class Inventory {
    static Scanner sc=new Scanner(System.in);
    public static void addInventory() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Add Inventory Item ---");
            sc.nextLine(); // consume newline
            System.out.print("Item Name: ");
            String name = sc.nextLine();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.print("Expiry Date (yyyy-mm-dd): ");
            String expiry = sc.nextLine();

            String sql = "INSERT INTO Inventory(name, quantity, expiry_date) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, quantity);
            ps.setString(3, expiry);
            ps.executeUpdate();
            System.out.println("Inventory item added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewInventory() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Inventory Records ---");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Inventory");
            while (rs.next()) {
                System.out.println("Item ID: " + rs.getInt("item_id") +
                        ", Name: " + rs.getString("name") +
                        ", Quantity: " + rs.getInt("quantity") +
                        ", Expiry Date: " + rs.getDate("expiry_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateInventoryQuantity() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Update Inventory Quantity ---");

            System.out.print("Enter Item ID: ");
            int itemId = sc.nextInt();
            System.out.print("Enter quantity change (positive to add, negative to reduce): ");
            int change = sc.nextInt();

            // Update quantity in database
            String sql = "UPDATE Inventory SET quantity = quantity + ? WHERE item_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, change);
            ps.setInt(2, itemId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Inventory quantity updated successfully!");
            } else {
                System.out.println("No item found with this ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
