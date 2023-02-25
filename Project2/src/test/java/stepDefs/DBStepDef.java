package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.*;

public class DBStepDef {
    private static int count = 0;
    @Given("verify given information: {string}, {string} , {string}")
    public void verify_given_information(String fullname, String month, String sum) {
        String query = "SELECT CONCAT(s.first_name,' ',s.last_name) AS fullname," +
                "TO_CHAR(date_trunc('month', p.payment_date), 'Month') AS month, SUM(amount) FROM staff s\n" +
                "INNER JOIN payment p ON s.staff_id = p.staff_id\n" +
                "GROUP BY s.staff_id,TO_CHAR(date_trunc('month', p.payment_date), 'Month')";

        List<Map<String,Object>> resultMap = DBUtils.getQueryResultMap(query);

        Map<String,Object> row = resultMap.get(count++);

        Assert.assertEquals(row.get("fullname"),fullname);
        Assert.assertEquals(row.get("month").toString().trim(),month);
        Assert.assertEquals(row.get("sum").toString(),sum);
    }
}
