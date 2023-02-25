package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBStepDefs {
    @Given("verify that there are {string} movies in store two which have three copies")
    public void verify_that_there_are_movies_in_store_two_which_have_three_copies(String number) {
        String query = "SELECT COUNT(*)\n" +
                "FROM (\n" +
                "  SELECT i.film_id, s.store_id, COUNT(i.film_id)\n" +
                "  FROM store s\n" +
                "  INNER JOIN inventory i ON i.store_id = s.store_id\n" +
                "  INNER JOIN film f ON f.film_id = i.film_id\n" +
                "  WHERE s.store_id = 2\n" +
                "  GROUP BY i.film_id, s.store_id\n" +
                "  HAVING COUNT(i.film_id) = 3\n" +
                ") subquery;";
        List<Map<String, Object>> rowValues = DBUtils.getResultMapList(query);
        Assert.assertEquals(rowValues.get(0).get("count").toString(),number);
    }

}
