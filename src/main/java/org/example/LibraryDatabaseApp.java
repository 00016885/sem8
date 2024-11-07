package org.example;

import java.sql.*;

public class LibraryDatabaseApp {

    public static void main(String[] args) {
        String url = "jdbc:h2:mem:libraryDB";
        String user = "sa";
        String password = "";

        try(Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement()){
            String createTableSQL = "Create TABLE Book("+
                    "id INT PRIMARY KEY, "+
                    "title VARCHAR(255), "+
                    "author VARCHAR(255)"+
                    ")";
            stmt.execute(createTableSQL);

            String insertBookOne = "INSERT INTO Book (id, title, author) "+
                    "VALUES (1, 'Pride and Prejutice', 'Jane Austen')";
            String insertBookTwo = "INSERT INTO Book (id, title, author) "+
                    "VALUES (2, 'Master and Margarita', 'Mihail Bulgakov')";
            stmt.execute(insertBookOne);
            stmt.execute(insertBookTwo);

            String selectSQL = "SELECT * FROM Book";
            ResultSet resultSet = stmt.executeQuery(selectSQL);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                System.out.println("Book "+title+", "+author);

            }

        } catch (SQLException e) {
           e.printStackTrace();
        }
    }
}
