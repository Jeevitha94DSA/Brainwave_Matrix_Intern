package Task1.Task2;

import java.sql.*;
import java.util.Scanner;

public class Appointment
{
    static Scanner sc=new Scanner(System.in);
    public static void scheduleAppointment()
    {
        try(Connection con = DBConnection.getConnection())
        {
            System.out.println("\n--- Schedule Appointment ---");
            System.out.print("Patient ID: ");
            int patientId = sc.nextInt();
            System.out.print("Doctor ID: ");
            int doctorId = sc.nextInt();
            sc.nextLine(); // consume newline
            System.out.print("Date (yyyy-mm-dd): ");
            String date = sc.nextLine();
            System.out.print("Time (hh:mm:ss): ");
            String time = sc.nextLine();
            System.out.print("Status: ");
            String status = sc.nextLine();

            String sql = "INSERT INTO Appointment(patient_id, doctor_id, Date_of_Appointment, time_of_Appointment, status_of_Appointment) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, patientId);
            ps.setInt(2, doctorId);
            ps.setString(3, date);
            ps.setString(4, time);
            ps.setString(5, status);
            ps.executeUpdate();

            System.out.println("Appointment scheduled successfully!");
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
    public static void viewAppointments() {
        try (Connection con = DBConnection.getConnection()) {
            System.out.println("\n--- Appointment Records ---");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Appointment");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("appointment_id") +
                        ", Patient ID: " + rs.getInt("patient_id") +
                        ", Doctor ID: " + rs.getInt("doctor_id") +
                        ", Date: " + rs.getDate("Date_of_Appointment") +
                        ", Time: " + rs.getTime("time_of_Appointment") +
                        ", Status: " + rs.getString("status_of_Appointment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateAppointment()
    {
        try(Connection conn=DBConnection.getConnection())
        {
            System.out.println("-- Update the Appointment Details--");
            System.out.print("Enter the Patient ID to update the Appointment Details: ");
            int patientId = sc.nextInt();
            System.out.print("Date (yyyy-mm-dd): ");
            String date = sc.nextLine();
            System.out.print("Time (hh:mm:ss): ");
            String time = sc.nextLine();
            System.out.print("Status: ");
            String status = sc.nextLine();
            String sql="Update Appointment set Date_of_Appointment=?,time_of_Appointment=?,status_of_Appointment=? where patient_id=?";
             PreparedStatement ps=conn.prepareStatement(sql);
             ps.setString(1,date);
             ps.setString(2,time);
             ps.setString(3,status);
             ps.setInt(4,patientId);

             int rows=ps.executeUpdate();
             if(rows>0)
             {
                 System.out.println("Appointment updated Successfully");
             }
             else {
                 System.out.println("No Appointments are scheduled");
             }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void cancelAppointment()
    {
        try(Connection conn=DBConnection.getConnection())
        {
            System.out.println("-- To cancel the appointment--");
            System.out.print("Enter the Patient ID to update the Appointment Details: ");
            int patientId = sc.nextInt();
            String sql="delete from Appointment where patient_id=?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setInt(1,patientId);
            int rows= ps.executeUpdate();
            if(rows>0)
            {
                System.out.println("Appointment Cancelled Successfully");
            }
            else {
                System.out.println("No Appointments are scheduled");
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}





