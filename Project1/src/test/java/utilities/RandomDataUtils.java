package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtils {
    static Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().safeEmailAddress();
    }

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }
}
