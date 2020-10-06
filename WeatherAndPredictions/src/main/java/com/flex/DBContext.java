package com.flex;
import java.sql.*;
import java.util.Properties;

public class DBContext {
    protected Connection dbConnection;
    protected Statement stmt;
    public boolean Connect(String connectionString) throws SQLException {
        Properties info = new Properties();
        info.put("user", "root");
        info.put("password", "");
        dbConnection = DriverManager.getConnection(connectionString, info);
        if (dbConnection != null) {
            return false;
        }
        return true;
    }
    protected ResultSet Query(String query) throws SQLException {
        try {
            stmt = dbConnection.createStatement();

            // executing SELECT query
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
            if(stmt != null)
                stmt.close();
        }
        return null;
    }
    protected void close() throws SQLException {
        stmt.close();
    }
}