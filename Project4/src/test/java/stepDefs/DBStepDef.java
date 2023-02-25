package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBStepDef {
    private static int counter = 0;
    @Given("verify the values: {string} and {string}")
    public void verify_the_values_and(String title, String count) {
        String query = "SELECT title,num_of_copies_in_store_1\n" +
                "FROM film\n" +
                "JOIN (\n" +
                "  SELECT film_id,\n" +
                "         SUM(CASE WHEN store_id = 1 THEN 1 ELSE 0 END) AS num_of_copies_in_store_1,\n" +
                "         SUM(CASE WHEN store_id = 2 THEN 1 ELSE 0 END) AS num_of_copies_in_store_2\n" +
                "  FROM inventory\n" +
                "  GROUP BY film_id\n" +
                ") r ON film.film_id = r.film_id\n" +
                "WHERE num_of_copies_in_store_1 > num_of_copies_in_store_2\n" +
                "ORDER BY film.film_id ASC";
        List<Map<String,Object>> resultMap = DBUtils.getQueryResultMap(query);
        Map<String,Object> row =  resultMap.get(counter++);
        Assert.assertEquals(row.get("title"),title);
        Assert.assertEquals(row.get("num_of_copies_in_store_1").toString(),count);
    }
}
