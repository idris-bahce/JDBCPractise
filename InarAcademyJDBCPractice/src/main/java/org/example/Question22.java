package org.example;

import java.sql.*;

public class Question22 {
    public static void answer() throws SQLException {

        //1 - Get a connection to DB
        String dbURL = "jdbc:postgresql://localhost:5432/exercises";
        String username = "postgres";
        String password = "tester2016";

        Connection connection = DriverManager.getConnection(dbURL,username,password);

        //2- Create a statement object

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        //3 - Execute a query

        String firstQuery = "SELECT TO_CHAR(date_trunc('month', joindate), 'Month') AS month, COUNT(*) AS total_members\n" +
                "FROM cd.members\n" +
                "GROUP BY month\n" +
                "ORDER BY total_members DESC\n" +
                "LIMIT 1;";
        ResultSet resultSet = statement.executeQuery(firstQuery);

        //4 - Process the result test

        int count = 1;
        while (resultSet.next()){
            System.out.println(resultSet.getString("month"));
        }
    }
}
