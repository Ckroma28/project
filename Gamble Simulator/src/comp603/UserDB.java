package comp603;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB {
    // JDBC URL, username, and password of Derby server
    private static final String URL = "jdbc:derby://localhost:1527/UserDB";
    private static final String USER = "UserDB";
    private static final String PASSWORD = "User";

    // JDBC variables for managing connection
    private static Connection connection;

    // Static initializer block to automatically connect to the database
    static {
        connect();
    }

    // Method to establish a database connection
    public static void connect() {
        try {
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Error connecting to database: " + e.getMessage());
        }
    }

    // Method to close the database connection
    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error closing database connection: " + e.getMessage());
        }
    }

    // Method to create the users table if it doesn't exist
    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS users ("
                + "username VARCHAR(100) PRIMARY KEY,"
                + "balance INT"
                + ")";

        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // Method to insert a new user into the database
    public static void insertUser(String username, int balance) {
        String insertUserSQL = "INSERT INTO users (username, balance) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, balance);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
        }
    }

    // Method to retrieve user information from the database
    public static User getUser(String username) {
        String query = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(resultSet.getString("username"), resultSet.getInt("balance"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving user information: " + e.getMessage());
        }
        return null;
    }

    // Method to update user balance in the database
    public static void updateUserBalance(String username, int newBalance) {
        String query = "UPDATE users SET balance = ? WHERE username = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newBalance);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error updating user balance: " + e.getMessage());
        }
    }

    static void updateUser(User user) {
    }
}
