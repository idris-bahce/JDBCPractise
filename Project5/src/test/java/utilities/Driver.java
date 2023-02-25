package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static final int IMPLICIT_WAIT_TIME_IN_SECONDS = 20;
    private static final int IMPLICIT_PAGE_LOAD_TIMEOUT = 20;
    private static WebDriver driver;
    private Driver(){
    }
    public static WebDriver getDriverReference(){
        return driver;
    }
    public static WebDriver getDriver(){
        if (driver == null){
            switch (Config.getProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
            }
        }
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME_IN_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(IMPLICIT_PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
