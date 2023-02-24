package Homework;

import java.sql.*;

public class Question_5 {
    //5-How much will store-2 earn when all the rented films are returned?
    public static void answer_5() throws SQLException {
        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "tester2016";

        Connection connection = DriverManager.getConnection(dbURL,username,password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        String query = "SELECT SUM(amount)\n" +
                "FROM rental r\n" +
                "JOIN inventory i ON i.inventory_id = r.inventory_id\n" +
                "JOIN payment p ON p.rental_id = r.rental_id\n" +
                "WHERE return_date IS NULL\n" +
                "AND store_id = 2";
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        System.out.println(resultSet.getString("count"));
    }
}
