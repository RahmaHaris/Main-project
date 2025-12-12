package pom;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Loginpage {
	  WebDriver driver;
	  WebDriverWait wait;

	   
	  public Loginpage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    By loginButton = By.id("login2");
	    By usernameField = By.id("loginusername");
	    By passwordField = By.id("loginpassword");
	    By submitButton = By.xpath("//button[text()='Log in']");
	    public void handleAlertIfPresent() {
	        try {
	            Alert alert = driver.switchTo().alert();
	            System.out.println("Closing unexpected alert: " + alert.getText());
	            alert.accept();
	            Thread.sleep(500);
	        } catch (Exception e) {
	            // No alert present → Safe to continue
	        }
	    }
	    public void clickLoginButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
	    }

	    public void enterUsername(String username) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
	    }

	    public void enterPassword(String password) {
	        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
	    }

	    public void clickSubmit() {
	        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	    }

}
