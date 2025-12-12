
package Test;

import org.testng.annotations.Test;
import base.BaseClass;
import pom.AddToCartPage;

public class AddToCartTest extends BaseClass {

    // Test 1 - Add Mobile
    @Test(priority = 1)
    public void addSamsungGalaxyS6() {
        driver.get("https://demoblaze.com");
        AddToCartPage cart = new AddToCartPage(driver);

        cart.clickProduct("Samsung galaxy s6");
        cart.clickAddToCart();
        cart.acceptAlert();
    }

  
    // Test 3 - Add Laptop
    
    @Test(priority = 3)
    public void addMacBookPro() {
        driver.get("https://demoblaze.com");
        AddToCartPage cart = new AddToCartPage(driver);

        // Click Laptops category
        cart.clickCategory("Laptops");

        // Now click MacBook Pro
        cart.clickProduct("MacBook Pro");
        cart.clickAddToCart();
        cart.acceptAlert();
    }


    // Test 4 - Add Monitor or another product
    @Test(priority = 4)
    public void addSonyVaio() {
        driver.get("https://demoblaze.com");
        AddToCartPage cart = new AddToCartPage(driver);

        cart.clickProduct("Sony vaio i5");
        cart.clickAddToCart();
        cart.acceptAlert();
    }
    @Test(priority = 5)
    public void removeSamsungGalaxyS6() {
        driver.get("https://demoblaze.com");
        AddToCartPage cart = new AddToCartPage(driver);

        // Add mobile
        cart.clickProduct("Samsung galaxy s6");
        cart.clickAddToCart();
        cart.acceptAlert();

        // Now remove it
        cart.removeFromCart("Samsung galaxy s6");
    }

}
