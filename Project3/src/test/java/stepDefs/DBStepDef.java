package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class DBStepDef {
    @Given("verify the full address : {string}")
    public void verify_the_full_address(String address) {
        String query = "SELECT CONCAT(a.address,' ',c.city,' ',a.district,'/',co.country) AS address FROM store s\n" +
                "INNER JOIN address a ON a.address_id = s.address_id \n" +
                "INNER JOIN city c ON c.city_id = a.city_id\n" +
                "INNER JOIN country co ON co.country_id = c.country_id\n" +
                "WHERE s.store_id = 2";
        List<Map<String, Object>>  resultMap = DBUtils.getQueryResultMap(query);
        Assert.assertEquals(resultMap.get(0).get("address"),address);
    }
}
