/*package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PurchasePage {
    WebDriver driver;
    WebDriverWait wait;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    // Click cart icon
    public void clickCartIcon() {
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("cartur")));
        cartIcon.click();
    }

    // Click Place Order button
    public void clickPlaceOrder() {
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Place Order']")));
        placeOrderBtn.click();
    }

    // Fill order form
    public void fillOrderForm(String name, String country, String city, String creditCard, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(creditCard);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);
    }

    // Click Purchase button
    public void clickPurchase() {
        WebElement purchaseBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Purchase']")));
        purchaseBtn.click();
    }

    // Click Close button on the form (without entering data)
    public void clickClose() {
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@id='orderModal']//button[text()='Close']")));
        closeBtn.click();
    }
}*/package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PurchasePage {
    WebDriver driver;
    WebDriverWait wait;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    // Click cart icon
    public void clickCartIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("cartur"))).click();
    }

    // Click Place Order button
    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']"))).click();
    }

    // Fill order form
    public void fillOrderForm(String name, String country, String city, String creditCard, String month, String year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(creditCard);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);
    }

    // Click Purchase button
    public void clickPurchase() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Purchase']"))).click();
    }

    // Click Close button
    public void clickClose() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='orderModal']//button[text()='Close']"))).click();
    }

    // Get confirmation message after successful purchase
    public String getConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/p"))).getText();
    }

    // Check for HTML5 form validation message (empty fields)
    public String getFieldValidationMessage(String fieldId) {
        return driver.findElement(By.id(fieldId)).getAttribute("validationMessage");
    }
}

