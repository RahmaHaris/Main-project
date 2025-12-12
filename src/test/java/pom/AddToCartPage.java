/*package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AddToCartPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    // ----------------- LOCATORS (Strong XPath) -----------------

    // Any product card by name
    private By productCard(String productName) {
        return By.xpath("//a[contains(@class,'hrefch') and normalize-space()='" + productName + "']");
    }

    // Add to cart button inside product details page
    private By addToCartButton = By.xpath("//a[text()='Add to cart']");

    // Alert (after clicking add to cart)
    private Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    // ----------------- ACTION METHODS -----------------

    // Click any product dynamically
    public void clickProduct(String productName) {
        wait.until(ExpectedConditions.elementToBeClickable(productCard(productName))).click();
    }

    // Click Add to Cart
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }   public void clickCategory(String categoryName) {
        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText(categoryName)));
        category.click();
    }
    public void removeFromCart(String productName) {
        // Go to Cart page
        driver.findElement(By.id("cartur")).click();

        // Wait for cart table to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody")));

        // Locate DELETE button based on product name
        By deleteBtn = By.xpath("//td[text()='" + productName + "']/following-sibling::td/a");

        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
    }


    // Accept alert
    public void acceptAlert() {
        Alert alert = waitForAlert();
        alert.accept();
    }
}
*/package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddToCartPage {

    WebDriver driver;
    WebDriverWait wait;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(12));
    }

    // --------------------------- LOCATORS ---------------------------
    
    // Dynamic product selector
    private By productCard(String productName) {
        return By.xpath("//a[contains(@class,'hrefch') and normalize-space()='" + productName + "']");
    }

    private By addToCartButton = By.xpath("//a[text()='Add to cart']");
    private By cartLink = By.id("cartur");
    private By cartTable = By.xpath("//tbody");

    // Delete button for a specific product
    private By deleteBtn(String productName) {
        return By.xpath("//td[text()='" + productName + "']/following-sibling::td/a");
    }

    // --------------------------- COMMON ACTIONS ---------------------------

    // Scroll to element (Demoblaze sometimes hides items)
    private void scrollIntoView(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // --------------------------- PRODUCT ACTIONS ---------------------------

    // Open a product detail page
    public void clickProduct(String productName) {
        scrollIntoView(productCard(productName));
        wait.until(ExpectedConditions.elementToBeClickable(productCard(productName))).click();
    }

    // Click Add to Cart
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Navigate to a category: Phones / Laptops / Monitors
    public void clickCategory(String categoryName) {
        By categoryLocator = By.linkText(categoryName);
        scrollIntoView(categoryLocator);
        wait.until(ExpectedConditions.elementToBeClickable(categoryLocator)).click();
    }

    // --------------------------- ALERT HANDLING ---------------------------

    private Alert waitForAlert() {
        try {
            return wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            System.out.println("ALERT NOT PRESENT → BUG");
            return null;
        }
    }

    public void acceptAlert() {
        Alert alert = waitForAlert();
        if (alert != null) {
            alert.accept();
        }
    }

    public String getAlertText() {
        Alert alert = waitForAlert();
        return (alert != null) ? alert.getText() : "NO ALERT FOUND";
    }

    // --------------------------- CART ACTIONS ---------------------------

    // Go to cart page
    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartTable));
    }

    // Remove a product from cart
    public void removeFromCart(String productName) {
        openCart();
        By delete = deleteBtn(productName);
        wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
    }

    // Verify if product exists in cart
    public boolean isProductInCart(String productName) {
        openCart();
        try {
            driver.findElement(By.xpath("//td[text()='" + productName + "']"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Get the total number of items in the cart table
    public int getItemCountInCart() {
        openCart();
        return driver.findElements(By.xpath("//tbody/tr")).size();
    }
}
