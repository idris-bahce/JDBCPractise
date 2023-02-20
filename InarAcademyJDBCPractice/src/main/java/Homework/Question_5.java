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
        String query = "" +
                "SELECT store.store_id,COUNT(amount) FROM store\n" +
                "INNER JOIN inventory ON store.store_id = inventory.store_id\n" +
                "INNER JOIN rental ON inventory.inventory_id = rental.inventory_id\n" +
                "INNER JOIN payment ON rental.rental_id = payment.rental_id\n" +
                "WHERE store.store_id = 2\n" +
                "GROUP BY store.store_id";
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        System.out.println(resultSet.getString("count"));
    }
}
