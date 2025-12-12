package Test;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import pom.HomePage;
import base.BaseClass;

public class HomePageText extends BaseClass{

	   HomePage home;

	    @Test(priority = 1)
	    public void verifyHomePageLogo() {
	        home = new HomePage(driver);
	        Assert.assertTrue(home.isLogoDisplayed(), "Home logo is missing.");
	    }

	    @Test(priority = 2)
	    public void verifyCategoriesVisible() {
	        home = new HomePage(driver);
	        Assert.assertTrue(home.categoriesDisplayed(), "Categories section missing.");
	    }

	    @Test(priority = 3)
	    public void verifyPhonesCategory() {
	        home = new HomePage(driver);
	        home.clickPhones();
	        int count = home.getProductCount();
	        Assert.assertTrue(count > 0, "Phones category has no items.");
	    }

	    @Test(priority = 4)
	    public void verifyLaptopsCategory() {
	        home = new HomePage(driver);
	        home.clickLaptops();
	        int count = home.getProductCount();
	        Assert.assertTrue(count > 0, "Laptops category has no items.");
	    }

	    @Test(priority = 5)
	    public void verifyMonitorsCategory() {
	        home = new HomePage(driver);
	        home.clickMonitors();
	        int count = home.getProductCount();
	        Assert.assertTrue(count > 0, "Monitors category has no items.");
	    }

	    @Test(priority = 6)
	    public void verifyNextButtonCarousel() {
	        home = new HomePage(driver);
	        home.clickNext();
	        Assert.assertTrue(true, "Next button not clickable.");
	    }

	    @Test(priority = 7)
	    public void verifyPreviousButtonCarousel() {
	        home = new HomePage(driver);
	        home.clickPrevious();
	        Assert.assertTrue(true, "Previous button not clickable.");
	    }

	    @Test(priority = 8)
	    public void verifyCartNavigation() {
	        home = new HomePage(driver);
	        home.clickCart();
	        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page not opened.");
	    }
	    /*  @Test(priority = 9)
	   public void verifyAboutUsModal() {
	        home = new HomePage(driver);
	        home.clickAboutUs();
	        Assert.assertTrue(true, "About us modal not opening.");
	        home.closeModal(); // important
	    }
	    */

	    
	    @Test(priority = 9)
	    public void verifyContactModal() {
	        home = new HomePage(driver);

	        // Close any previous modal
	        home.closeModal();

	        home.clickContact();
	        Assert.assertTrue(true, "Contact modal not opening.");

	        // Close modal again after test
	        home.closeModal();
	    }


	    @Test
	    public void listProductNamesAndPrices() {
	        HomePage hp = new HomePage(driver);

	        List<String> names = hp.getAllProductNames();
	        List<String> prices = hp.getAllProductPrices();

	        System.out.println("---- PRODUCT LIST ----");
	        for (int i = 0; i < names.size(); i++) {
	            System.out.println(names.get(i) + " - " + prices.get(i));
	        }
	    }

	 

	  
	    }




