package com.login.dao; // Package declaration for the data access object related to login

import java.sql.Connection; // Import for handling database connections
import java.sql.DriverManager; // Import for managing database drivers
import java.sql.PreparedStatement; // Import for prepared SQL statements
import java.sql.ResultSet; // Import for handling the result set of a query
import java.sql.SQLException; // Import for handling SQL exceptions

public class LoginDao { // Defines the LoginDao class
    // Database connection parameters
    String url = "jdbc:mysql://localhost:3307/userdetails"; // URL of the database
    String username = "root"; // Database username
    String password = "Sreyaas777&&"; // Database password

    // SQL queries
    String sqlLogin = "SELECT * FROM name_pass WHERE uname=? AND pass=?"; // Query to check user credentials
    String sqlCreateUser = "INSERT INTO name_pass (uname, pass) VALUES (?, ?)"; // Query to create a new user

    // Method to check if the user exists with valid credentials
    public boolean check(String uname, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
            Connection con = DriverManager.getConnection(url, username, password); // Establish the connection to the database
            System.out.println("Database connected successfully!"); // Debug line
            
            PreparedStatement st = con.prepareStatement(sqlLogin); // Prepare the SQL statement for user login
            st.setString(1, uname); // Set the username parameter
            st.setString(2, pass); // Set the password parameter
            ResultSet rs = st.executeQuery(); // Execute the query
            
            if (rs.next()) { // Check if the result set has any entries
                return true; // Valid user found
            } else {
                System.out.println("Invalid credentials for user: " + uname); // Debug line for invalid credentials
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for SQL exceptions
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Catch ClassNotFoundException for the JDBC driver
        }
        return false; // User not found
    }

    // Method to create a new user
    public boolean createUser(String uname, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver
            Connection con = DriverManager.getConnection(url, username, password); // Establish the connection to the database
            System.out.println("Database connected successfully!"); // Debug line
            
            PreparedStatement st = con.prepareStatement(sqlCreateUser); // Prepare the SQL statement for creating a user
            st.setString(1, uname); // Set the username parameter
            st.setString(2, pass); // Set the password parameter
            int rowsAffected = st.executeUpdate(); // Execute the update query
            
            return rowsAffected > 0; // Return true if user was created successfully
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for SQL exceptions
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // Catch ClassNotFoundException for the JDBC driver
        }
        return false; // User not created
    }
}
