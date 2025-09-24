package Task1.Task2;
import java.sql.*;
import java.util.Scanner;

public class Doctor {
    static Scanner sc=new Scanner(System.in);
    public static void addDoctor() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Add Doctor ---");
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Specialization: ");
            String specialization = sc.nextLine();
            System.out.print("Contact: ");
            long contact = sc.nextLong();

            String sql = "INSERT INTO Doctor(name, specialization, contact) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.setLong(3, contact);
            ps.executeUpdate();

            System.out.println("Doctor added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewDoctor() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Doctor Records ---");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Doctor");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("doctor_id") + ", Name: " + rs.getString("name") +
                        ", Specialization: " + rs.getString("specialization") +
                        ", Contact: " + rs.getLong("contact"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void updateDoctor()
        {
            try (Connection conn = DBConnection.getConnection()) {
                System.out.println("--Update Doctor--");
                System.out.print("Enter Doctor Id:");
                int doctor_id = sc.nextInt();
                sc.nextLine();
                System.out.print("Specialization: ");
                String specialization = sc.nextLine();
                System.out.print("Contact: ");
                long contact = sc.nextLong();
                String sql = " update Doctor set Specialization=?,Contact=? where doctor_id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, specialization);
                ps.setLong(2, contact);
                ps.setInt(3, doctor_id);
                int rows=ps.executeUpdate();
                if(rows>0) {
                    System.out.println("Doctor detatils updated Sucessfully!");
                }
                else {
                    System.out.println("No data found for the given id!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static void deleteDoctor()
        {
        try(Connection conn=DBConnection.getConnection())
        {
            System.out.println("-- Delete Doctor Details--");
            System.out.print("Enter Doctor id to delete:");
            int doctor_id=sc.nextInt();
            String sql="delete from Doctor where doctor_id=?";
            try(PreparedStatement ps=conn.prepareStatement(sql)) {
                ps.setInt(1, doctor_id);
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Doctor Details Deleted Successfully!");
                } else {
                    System.out.println("No Doctor details were found on the entered Id...");
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        }
    }

