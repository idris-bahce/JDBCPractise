package Homework;

import java.sql.*;

public class Question_3 {
    public static void answer_3() throws SQLException {
        //3-What are the names of top 5 categories, that have more than 150 films in inventory of store-1?


        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "tester2016";

        Connection connection = DriverManager.getConnection(dbURL,username,password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String query =
                "SELECT c.name, COUNT(c.category_id) FROM category c\n" +
                "INNER JOIN film_category fc ON c.category_id = fc.category_id\n" +
                "INNER JOIN film ON fc.film_id = film.film_id\n" +
                "INNER JOIN inventory ON film.film_id = inventory.film_id\n" +
                "WHERE store_id = 1\n" +
                "GROUP BY c.name\n" +
                "HAVING COUNT(c.category_id)>150\n" +
                "ORDER BY COUNT(c.category_id) DESC";

        ResultSet resultSet = statement.executeQuery(query);
        int count = 1;
        while (resultSet.next()){
            System.out.println(count++ + " : " + resultSet.getString("name"));
        }
    }
}
