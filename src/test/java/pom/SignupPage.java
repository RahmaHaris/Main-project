package pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;

public class SignupPage {

    WebDriver driver;

    // Constructor
    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By signupLink = By.id("signin2");
    By usernameField = By.id("sign-username");
    By passwordField = By.id("sign-password");
    By signupButton = By.xpath("//button[text()='Sign up']");

    // Actions
    public void clickSignupLink() {
        driver.findElement(signupLink).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignupButton() {
        driver.findElement(signupButton).click();
    }


    public String createUser(String username, String password) throws InterruptedException {

        // Step 1: Open signup modal
        clickSignupLink();
        Thread.sleep(1000);

        // Step 2: Enter credentials
        enterUsername(username);
        enterPassword(password);

        // Step 3: Click signup
        clickSignupButton();
        Thread.sleep(1000);

        // Step 4: Handle alert
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText();
        alert.accept();

        return alertMessage;
    }

}
