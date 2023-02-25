package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DBUtils;

import java.sql.SQLException;

public class Hooks {
    @Before
    public void createDBConnection(){
        System.out.println("I am setting up the connection.");
        DBUtils.createConnection();
    }
    @After
    public void tearDownDBConnection(){
        System.out.println("I am closing the DB connection!!!");
        try {
            DBUtils.destroy();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
