package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DBUtils;

import java.sql.SQLException;

public class Hooks {

    @Before
    public void setUpDBConnection(){
        System.out.println("I am setting up the DB Connection!!!");
        DBUtils.createConnection();

    }
    @After
    public static void tearDownDBConnection(){
        System.out.println("I am closing the DB Connection!!!");
        try {
            DBUtils.destroy();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
