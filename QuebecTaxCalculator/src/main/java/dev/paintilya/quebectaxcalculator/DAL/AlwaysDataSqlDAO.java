package dev.paintilya.quebectaxcalculator.DAL;

import dev.paintilya.quebectaxcalculator.BLL.Model.TaxBracket;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlwaysDataSqlDAO implements ITaxBracketDAO {

    private AlwaysDataSqlConnector connector;

    public AlwaysDataSqlDAO(AlwaysDataSqlConnector connector) {
        this.connector = connector;
    }


    @Override
    public List<TaxBracket> findAll() {
        List<TaxBracket> taxBrackets = new ArrayList<>();

        // Establish a database connection
        try (Connection conn = this.connector.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TaxBracket")) {

            // Execute the query
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // Retrieve data from the result set
                    Double min = rs.getDouble("min");
                    Double max = rs.getDouble("max");
                    Double rate = rs.getDouble("rate");

                    // Create a User object and add it to the list
                    TaxBracket taxBracket = new TaxBracket(min, max, rate);
                    taxBrackets.add(taxBracket);
                }
            }

        } catch (SQLException e) {
            // Handle any exceptions
            e.printStackTrace();
        }

        return taxBrackets;
    }


    @Override
    public TaxBracket findByRate(float rateToSearch) {
        // Establish a database connection
        try (Connection conn = this.connector.connect();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM TaxBracket WHERE rate = ?")) {
            // Set the parameter for the query
            stmt.setFloat(1, rateToSearch);

            // Execute the query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Retrieve data from the result set
                    Double min = rs.getDouble("min");
                    Double max = rs.getDouble("max");
                    Double rate = rs.getDouble("rate");

                    TaxBracket taxBracket = new TaxBracket(min, max, rate);
                    return  taxBracket;
                }
            }

        } catch (SQLException e) {
            // Handle any exceptions
            e.printStackTrace();
        }

        return null;
    }
}
