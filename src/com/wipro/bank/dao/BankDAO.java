package com.wipro.bank.dao;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.DBUtil;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankDAO {

    public int generateSequenceNumber() {
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT seq1.NEXTVAL FROM dual";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean validateAccount(String accountNumber) {
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT Account_Number FROM ACCOUNT_TABLE WHERE Account_Number=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public float findBalance(String accountNumber) {

        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT Balance FROM ACCOUNT_TABLE WHERE Account_Number=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean updateBalance(String accountNumber, float newBalance) {

        Connection connection = DBUtil.getDBConnection();
        String query = "UPDATE ACCOUNT_TABLE SET Balance=? WHERE Account_Number=?";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setFloat(1, newBalance);
            ps.setString(2, accountNumber);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean transferMoney(TransferBean transferBean) {

        transferBean.setTransactionID(generateSequenceNumber());
        Connection connection = DBUtil.getDBConnection();
        String query = "INSERT INTO TRANSFER_TBL VALUES(?,?,?,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, transferBean.getTransactionID());
            ps.setString(2, transferBean.getFromAccountNumber());
            ps.setString(3, transferBean.getToAccountNUmber());

            Date d = new Date(transferBean.getDateOfTransaction().getTime());
            ps.setDate(4, d);
            ps.setFloat(5, transferBean.getAmount());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
