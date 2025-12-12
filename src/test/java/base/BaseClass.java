package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public WebDriver driver;

    @BeforeClass
    public void setup() {

        // Launch Chrome browser
        driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Open URL
        driver.get("https://demoblaze.com/index.html");
    }

    @AfterClass
    public void tearDown() {

        // Close browser after test
        if (driver != null) {
            driver.quit();
        }
    }
}
