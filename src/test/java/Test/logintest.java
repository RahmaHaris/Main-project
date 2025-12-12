package Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;

import pom.Loginpage;
import java.time.Duration;
public class logintest extends BaseClass{
	  Loginpage loginPage;

	   @Test(priority = 1)
	    public void validLogin() {
	        loginPage = new Loginpage(driver);
	        loginPage.clickLoginButton();
	        loginPage.enterUsername("testuser");
	        loginPage.enterPassword("testpass");
	        loginPage.clickSubmit();
	        // Verify login success
	      
	    }

	    @Test(priority = 2)
	    public void invalidLogin() throws InterruptedException {
	     

	        // Refresh page before starting the test
	        driver.navigate().refresh();
	        Thread.sleep(1000);

	        loginPage = new Loginpage(driver);

	        // Open Login modal
	        loginPage.clickLoginButton();

	        // Enter wrong credentials
	        loginPage.enterUsername("wronguser");
	        loginPage.enterPassword("wrongpass");
	        loginPage.clickSubmit();

	        // ====== FIXED PART: Wait & Handle Alert FIRST ======
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

	        String alertText = alert.getText();
	        System.out.println("Alert Message: " + alertText);

	        // Verify the alert message
	        Assert.assertTrue(alertText.contains("Wrong"), 
	                "Invalid login alert message is incorrect.");

	        // Close the alert
	        alert.accept();

	        // Ensure page is stable after alert
	        Thread.sleep(600);
	    
	    }
	      
	    
	    @Test(priority = 3)
	    public void loginWithEmptyUsername() throws Exception {
	        driver.navigate().refresh();
            Thread.sleep(1000);
	        loginPage = new Loginpage(driver);
	    	
	        loginPage.clickLoginButton();
	        loginPage.enterUsername("");
	        loginPage.enterPassword("testpass");
	        loginPage.clickSubmit();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        Assert.assertTrue(alert.getText().contains("Please"), "Alert text mismatch");
	        alert.accept();
	    }
	    @Test(priority = 4)
	    public void loginWithEmptyPassword() throws InterruptedException {
	       
	        driver.navigate().refresh();
            Thread.sleep(1000);
	        loginPage = new Loginpage(driver);

	        loginPage.clickLoginButton();
	        loginPage.enterUsername("testuser");
	        loginPage.enterPassword("");
	        loginPage.clickSubmit();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        Assert.assertTrue(alert.getText().contains("Please"), 
	                "Password empty alert mismatch");
	        alert.accept();
	    }

	    // ------------------ BOTH FIELDS EMPTY ---------------------
	    @Test(priority = 5)
	    public void loginWithBothFieldsEmpty() throws InterruptedException {
	        driver.navigate().refresh();
            Thread.sleep(1000);
	        loginPage = new Loginpage(driver);
	       

	        loginPage.clickLoginButton();
	        loginPage.enterUsername("");
	        loginPage.enterPassword("");
	        loginPage.clickSubmit();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        Assert.assertTrue(alert.getText().contains("Please"),
	                "Empty field alert mismatch");
	        alert.accept();
	    }

	  
	  

	      
	    }

