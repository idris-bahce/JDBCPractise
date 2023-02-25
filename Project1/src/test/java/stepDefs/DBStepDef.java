package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBStepDef {
    private static int count = 0;
    @Given("verify given information: {string}, {string}, {string},{string},{string}")
    public void verify_given_information(String customerId, String fullname, String city, String country, String totalAmount) {
        String query = "SELECT customer.customer_id,CONCAT(customer.first_name,' ',customer.last_name) AS fullname, city,country, SUM(amount) FROM country\n" +
                "INNER JOIN city ON city.country_id = country.country_id\n" +
                "INNER JOIN address ON address.city_id = city.city_id\n" +
                "INNER JOIN customer ON customer.address_id = address.address_id\n" +
                "INNER JOIN payment ON payment.customer_id = customer.customer_id\n" +
                "GROUP BY customer.customer_id, city,country\n" +
                "ORDER BY SUM(amount) DESC";
        List<Map<String,Object>> resultMap = DBUtils.getQueryResultMap(query);
        Map<String,Object> row = resultMap.get(count++);
        Assert.assertEquals(row.get("customer_id"),Integer.parseInt(customerId));
        Assert.assertEquals(row.get("fullname"),fullname);
        Assert.assertEquals(row.get("city"),city);
        Assert.assertEquals(row.get("country"),country);
        Assert.assertEquals(row.get("sum").toString(),totalAmount);

    }
    @Given("customer_id must match with {string} in first row")
    public void customer_id_must_match_with_in_first_row(String customer_id) {
        String query = "SELECT customer.customer_id,customer.first_name,customer.last_name, city,country, SUM(amount) AS total_amount FROM country\n" +
                "INNER JOIN city ON city.country_id = country.country_id\n" +
                "INNER JOIN address ON address.city_id = city.city_id\n" +
                "INNER JOIN customer ON customer.address_id = address.address_id\n" +
                "INNER JOIN payment ON payment.customer_id = customer.customer_id\n" +
                "GROUP BY customer.customer_id, city,country\n" +
                "ORDER BY SUM(amount) DESC";

        List<Map<String, Object>> resultMap = DBUtils.getQueryResultMap(query);
        System.out.printf("%2s %6s %14s %22s %27s %30s %26s", "Row", "customer_id", "first_name", "last_name", "city", "country", "sum");
        System.out.println();
        int countRows = 1;
        for (Map<String, Object> map : resultMap) {
            System.out.printf("%2d %6s %18s %22s %30s %30s %26s"
                    , countRows++, map.get("customer_id").toString(),
                    map.get("first_name").toString(),
                    map.get("last_name").toString(),
                    map.get("city").toString(),
                    map.get("country").toString(),
                    map.get("total_amount"));
            System.out.println();
        }
        String expectedValue = resultMap.get(0).get("customer_id").toString();
        Assert.assertEquals(expectedValue, customer_id);
    }
}
