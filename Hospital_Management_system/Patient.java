package Task1.Task2;

import java.sql.*;
import java.util.Scanner;

public class Patient {

    static Scanner sc=new Scanner(System.in);
    private int patientId;
    private String name;
    private int age;
    private String gender;
    private long contact;
    private String medicalHistory;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Patient() {

    }

    public static void addPatient()
    {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Add Patient ---");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            System.out.print("Contact: ");
            long contact = sc.nextLong();
            sc.nextLine(); // consume newline
            System.out.print("Medical History: ");
            String medicalHistory = sc.nextLine();

            String sql = "INSERT INTO Patient(name, age, gender, contact, medical_history) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, gender);
            ps.setLong(4, contact);
            ps.setString(5, medicalHistory);
            ps.executeUpdate();

            System.out.println("Patient added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePatient()
    {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Update Patient ---");
            System.out.print("Enter patient id to Update:");
            int patient_id=sc.nextInt();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Contact: ");
            long contact = sc.nextLong();
            sc.nextLine(); // consume newline
            System.out.print("Medical History: ");
            String medicalHistory = sc.nextLine();

            String sql = "update Patient set Age=?,Contact=?,medical_history=? where patient_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, age);
            ps.setLong(2, contact);
            ps.setString(3, medicalHistory);
            ps.setInt(4,patient_id);
            ps.executeUpdate();

            System.out.println("Patient updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deletePatient()
    {
        try(Connection conn=DBConnection.getConnection()) {
            System.out.println("\n--- Delete Patient ---");
            System.out.print("Enter patient id to Delete:");
            int patient_id = sc.nextInt();
            String sql=" delete from Patient where patient_id=?";
            try(PreparedStatement ps=conn.prepareStatement(sql))
            {
                ps.setInt(1,patient_id);
                int rows=ps.executeUpdate();
                if(rows>0)
                {
                    System.out.println("Patient Deleted SuccessFully!");
                }
                else
                {
                    System.out.println("No patient found with the given id");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void viewPatient()
    {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Patient Records ---");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Patient");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("patient_id") + ", Name: " + rs.getString("name") +
                        ", Age: " + rs.getInt("age") + ", Gender: " + rs.getString("gender") +
                        ", Contact: " + rs.getLong("contact") + ", History: " + rs.getString("medical_history"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

