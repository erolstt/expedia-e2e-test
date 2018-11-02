package flights;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import utils.Flights;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import java.io.InputStream;

public class BaseTest {

    WebDriver driver;
    Flights flights;
    private Yaml yaml = new Yaml(new Constructor(Flights.class));

    @BeforeClass
    public void setUp() {
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("flights.yaml");
        flights = (Flights) yaml.load(inputStream);

        WebDriverManager.getInstance(CHROME).setup();

        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
        }
    }

}
