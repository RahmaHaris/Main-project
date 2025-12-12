
package pom;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ContactPage {

    WebDriver driver;
    WebDriverWait wait;

    By contactLink = By.xpath("//a[text()='Contact']");
    By emailField = By.id("recipient-email");
    By nameField = By.id("recipient-name");
    By messageField = By.id("message-text");
    By sendMessageBtn = By.xpath("//button[text()='Send message']");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openContactForm() {
        driver.findElement(contactLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterMessage(String msg) {
        driver.findElement(messageField).sendKeys(msg);
    }

    public void clickSendMessage() {
        driver.findElement(sendMessageBtn).click();
    }

    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }
}

