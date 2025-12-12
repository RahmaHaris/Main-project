package pom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By logo = By.id("nava");
    private By homeLink = By.xpath("//a[text()='Home ']");
    private By categories = By.id("cat");
    private By categoryPhones = By.xpath("//a[text()='Phones']");
    private By categoryLaptops = By.xpath("//a[text()='Laptops']");
    private By categoryMonitors = By.xpath("//a[text()='Monitors']");
    private By productCards = By.cssSelector(".card.h-100");
    private By nextButton = By.id("next2");
    private By prevButton = By.id("prev2");
    private By contactMenu = By.xpath("//a[text()='Contact']");
    private By aboutUsMenu = By.xpath("//a[text()='About us']");
    private By cartMenu = By.id("cartur");

    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Methods
   
  
   
    public List<String> getAllProductNames() {
        List<WebElement> products = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".hrefch"))
        );

        List<String> names = new ArrayList<>();
        for (WebElement p : products) {
            names.add(p.getText().trim());
        }
        return names;
    }

    public List<String> getAllProductPrices() {
        List<WebElement> prices = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-block h5, .card-body h5"))
        );

        List<String> priceList = new ArrayList<>();
        for (WebElement p : prices) {
            priceList.add(p.getText().trim());
        }
        return priceList;
    }





   /* public void closeModal() {
    	  try {
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    	        // Wait for modal to be visible (if it's visible)
    	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

    	        // Click the close button
    	        WebElement closeBtn = driver.findElement(By.xpath("//button[@class='close']"));
    	        closeBtn.click();

    	        // Wait until modal disappears
    	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='modal-content']")));

    	    } catch (Exception e) {
    	        System.out.println("Modal not found or already closed.");
    	    }
    }*/public void closeModal() {
        try {
            WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Wait for modal to appear
            w.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector(".modal.fade.show")
            ));

            // Click the Close button
            driver.findElement(By.id("closeModal")).click();

            // Wait until modal disappears
            w.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.cssSelector(".modal.fade.show")
            ));

        } catch (Exception e) {
            System.out.println("Modal not found or already closed.");
        }
    }


    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean categoriesDisplayed() {
        return driver.findElement(categories).isDisplayed();
    }

    public void clickPhones() {
        driver.findElement(categoryPhones).click();
    }

    public void clickLaptops() {
        driver.findElement(categoryLaptops).click();
    }

    public void clickMonitors() {
        driver.findElement(categoryMonitors).click();
    }

    public int getProductCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productCards));
        List<WebElement> list = driver.findElements(productCards);
        return list.size();
    }

    public void clickNext() {
        driver.findElement(nextButton).click();
    }

    public void clickPrevious() {
        driver.findElement(prevButton).click();
    }

    public void clickCart() {
        driver.findElement(cartMenu).click();
    }

    public void clickAboutUs() {
        driver.findElement(aboutUsMenu).click();
    }

    public void clickContact() {
        driver.findElement(contactMenu).click();
    }
}
