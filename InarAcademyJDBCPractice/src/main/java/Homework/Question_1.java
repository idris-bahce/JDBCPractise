package Homework;

import java.sql.*;

public class Question_1 {
    public static void answer_1() throws SQLException {
        //1- The last 3 person’s name and rent date, who had rent any film of actor “Ed Chase”

        String dbURL = "jdbc:postgresql://localhost:5432/dvdrental";
        String username = "postgres";
        String password = "tester2016";

        Connection connection = DriverManager.getConnection(dbURL,username,password);

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String query = "SELECT c.first_name, r.rental_date FROM customer c\n" +
                "INNER JOIN rental r ON r.customer_id = c.customer_id\n" +
                "INNER JOIN inventory ON inventory.inventory_id = r.inventory_id\n" +
                "INNER JOIN film ON film.film_id = inventory.film_id\n" +
                "INNER JOIN film_actor ON film_actor.film_id = film.film_id\n" +
                "INNER JOIN actor ON actor.actor_id = film_actor.actor_id\n" +
                "WHERE actor.first_name = 'Ed' AND actor.last_name = 'Chase'\n" +
                "ORDER BY rental_date DESC\n" +
                "LIMIT 3";
        ResultSet resultSet = statement.executeQuery(query);

        int countOfLastThree = 1;
        while (resultSet.next()){
            System.out.printf("%1s %1s %-7s %8s %20s",countOfLastThree++, " : ", resultSet.getString("first_name")
                    , "Date: ", resultSet.getString("rental_date"));
            System.out.println();
        }
    }
}
