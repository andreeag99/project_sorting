package org.example;
import java.sql.*;
import java.util.ArrayList;

public class DatabaseLink {


    static String jdbcUrl = "jdbc:mysql://localhost:3306/java_project";
    static String jbcUsername = "root";
    static String jbcPassword = "Parolagrea_01";



    public boolean authenticateUser(String username, String password) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {

            String query = "SELECT * FROM users WHERE username = ? AND password = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    return resultSet.next();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void addUser(String username, String password) {

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {

            String query = "INSERT INTO users (username, password, role) VALUES (?, ?, 'client')";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateUserRole(String username, String newRole) {

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {


            String assignRoleQuery = "UPDATE users SET role = ? WHERE username = ?";

            try (
                 PreparedStatement assignRoleStatement = connection.prepareStatement(assignRoleQuery)) {




                assignRoleStatement.setString(1, newRole);
                assignRoleStatement.setString(2, username);
                int rowsAffected = assignRoleStatement.executeUpdate();

                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }


    }

    public static String getUserRole(String username) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {

            String query = "SELECT role FROM users WHERE username = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                // Set the product title as a parameter in the query
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("role");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void deleteUser(String username) {

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {

            String deleteQuery = "DELETE FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                preparedStatement.setString(1, username);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Product deleted successfully.\n");
                } else {
                    System.out.println("Product not found or could not be deleted.\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void displayUsersFromDB() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {
            String query = "SELECT username, role FROM users";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                System.out.println("List of users:\n");
                while (resultSet.next()) {
                    String title = resultSet.getString("username");
                    String genre = resultSet.getString("role");


                    System.out.println(title + " , " + genre + "\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertProductToDB(Product product) throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");


        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {

            String insertQuery = "INSERT INTO Products (title, yearOfAppearence, duration, director, ageRestriction, price, genre, type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {


                preparedStatement.setString(1, product.getTitle());
                preparedStatement.setInt(2, product.getYearOfAppearance());
                preparedStatement.setInt(3, product.getDuration());
                preparedStatement.setString(4, product.getDirector());
                preparedStatement.setInt(5, product.getAgeRestriction());
                preparedStatement.setInt(6, product.getPrice());
                preparedStatement.setString(7, product.getGenre());
                preparedStatement.setString(8, product.getType());

                preparedStatement.executeUpdate();


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void displayProductsFromDB() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {
            String query = "SELECT title, type FROM Products";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                System.out.println("List of products:\n");
                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String genre = resultSet.getString("type");


                    System.out.println(title + " , " + genre + "\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkSpecificObjectFromDB(String productTitle) {


        int count;

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {

            String query = "SELECT COUNT(*) AS count FROM Products WHERE title = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, productTitle);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    if (resultSet.next()) {
                        count = resultSet.getInt("count");
                        return count > 0;
                    }
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }





    public static void deleteProduct(String productName) {

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {

            String deleteQuery = "DELETE FROM Products WHERE title = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                preparedStatement.setString(1, productName);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Product deleted successfully.\n");
                } else {
                    System.out.println("Product not found or could not be deleted.\n");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getProductType(String productTitle) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, jbcUsername, jbcPassword)) {

            String query = "SELECT type FROM products WHERE title = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                // Set the product title as a parameter in the query
                preparedStatement.setString(1, productTitle);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("type");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }







}
