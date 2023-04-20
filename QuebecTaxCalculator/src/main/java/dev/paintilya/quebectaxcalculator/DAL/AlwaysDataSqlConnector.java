package dev.paintilya.quebectaxcalculator.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Mariadb Driver
public class AlwaysDataSqlConnector implements ISQLConnector {

    public AlwaysDataSqlConnector() { }

    @Override
    public Connection connect() {
        Connection conn;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String connectionString = "jdbc:mariadb://mysql-bloometti.alwaysdata.net/bloometti_mysql?user=bloometti&password=paintilya";
            conn = DriverManager.getConnection(connectionString);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
