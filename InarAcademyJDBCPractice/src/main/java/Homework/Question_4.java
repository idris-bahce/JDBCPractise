package Homework;

import java.sql.*;

public class Question_4 {
    //4-Which countries have made higher payments than 800$?(with their payment amount in desc order)

    public static void answer_4() throws SQLException {

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "tester2016";

        Connection connection = DriverManager.getConnection(dbURL,username,password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String query = "" +
                "SELECT country, COUNT(amount) FROM country\n" +
                "INNER JOIN city ON city.country_id = country.country_id\n" +
                "INNER JOIN address ON address.city_id = city.city_id\n" +
                "INNER JOIN customer ON customer.address_id = address.address_id\n" +
                "INNER JOIN payment ON payment.customer_id = customer.customer_id\n" +
                "GROUP BY country\n" +
                "HAVING COUNT(amount)>800\n" +
                "ORDER BY COUNT(amount) DESC";
        ResultSet resultSet = statement.executeQuery(query);
        int count = 1;
        while (resultSet.next()){
            System.out.println(count++ + " : " + resultSet.getString("country"));
        }
    }
}
