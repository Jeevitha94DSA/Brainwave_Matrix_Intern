package Task1.Task2;

import java.sql.*;
import java.util.Scanner;
public class EHR {
    static Scanner sc=new Scanner(System.in);
    public static void addEHR() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Add EHR ---");
            System.out.print("Patient ID: ");
            int patientId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Diagnosis: ");
            String diagnosis = sc.nextLine();
            System.out.print("Treatment: ");
            String treatment = sc.nextLine();
            System.out.print("Prescription: ");
            String prescription = sc.nextLine();
            System.out.print("Lab Results: ");
            String labResults = sc.nextLine();

            String sql = "INSERT INTO EHR(patient_id, diagnosis, treatment, prescription, lab_results) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patientId);
            ps.setString(2, diagnosis);
            ps.setString(3, treatment);
            ps.setString(4, prescription);
            ps.setString(5, labResults);
            ps.executeUpdate();
            System.out.println("EHR added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewEHR() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- EHR Records ---");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM EHR");
            while (rs.next()) {
                System.out.println("EHR ID: " + rs.getInt("ehr_id") +
                        ", Patient ID: " + rs.getInt("patient_id") +
                        ", Diagnosis: " + rs.getString("diagnosis") +
                        ", Treatment: " + rs.getString("treatment") +
                        ", Prescription: " + rs.getString("prescription") +
                        ", Lab Results: " + rs.getString("lab_results"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
