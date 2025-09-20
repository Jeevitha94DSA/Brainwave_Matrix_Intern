package Task1;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class Atmimplementation implements Atminterface {
    private int accountNumber;
    private Map<Double, String> stmt = new HashMap<>();

    public Atmimplementation(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    private double getBalanceFromDB() {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT available_balance FROM user_accounts WHERE account_number=?")) {
            ps.setInt(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getDouble(1);
        } catch (SQLException e) { e.printStackTrace(); }
        return 0.0;
    }

    private void updateBalanceInDB(double newBalance) {
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "UPDATE user_accounts SET available_balance=? WHERE account_number=?")) {
            ps.setDouble(1, newBalance);
            ps.setInt(2, accountNumber);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    @Override
    public void viewBalance() {
        System.out.println("Available Balance is: " + getBalanceFromDB());
    }

    @Override
    public void withdrawn(double amount) {
        if (amount <500 ) {
            System.out.println("Minimum withdrawal amount is 500");
            return;
        }
        double balance = getBalanceFromDB();
        if (amount <= balance) {
            stmt.put(amount, "Withdrawn");
            double newBal = balance - amount;
            updateBalanceInDB(newBal);
            System.out.println("Please collect your cash: " + amount);
            viewBalance();
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    @Override
    public void depositAmount(double amount) {
        double balance = getBalanceFromDB();
        double newBal = balance + amount;
        stmt.put(amount, "Deposit");
        updateBalanceInDB(newBal);
        System.out.println("Amount " + amount + " deposited successfully!");
    }

    @Override
    public void viewMinistatement() {
        stmt.forEach((k,v) -> System.out.println(k + " " + v));
    }
}

