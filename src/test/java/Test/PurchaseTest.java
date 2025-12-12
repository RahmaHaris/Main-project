/*package Test;

import org.testng.annotations.Test;
import base.BaseClass;
import pom.PurchasePage;

public class PurchaseTest extends BaseClass {

    @Test(priority = 1)
    public void closePlaceOrderFormWithoutData() {
        driver.get("https://demoblaze.com");
        PurchasePage purchase = new PurchasePage(driver);

        purchase.clickCartIcon();
        purchase.clickPlaceOrder();
        purchase.clickClose(); // Close without entering any data
    }

    @Test(priority = 2)
    public void completePurchase() {
        driver.get("https://demoblaze.com");
        PurchasePage purchase = new PurchasePage(driver);

        purchase.clickCartIcon();
        purchase.clickPlaceOrder();
        purchase.fillOrderForm("Rahma KP", "India", "Malappuram", "1234567890123456", "11", "2025");
        purchase.clickPurchase();
        // Optional: verify confirmation message
    }
}*/package Test;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.BaseClass;
import pom.PurchasePage;

public class PurchaseTest extends BaseClass {

    @Test(priority = 1)
    public void closePlaceOrderFormWithoutData() {
        driver.get("https://demoblaze.com");
        PurchasePage purchase = new PurchasePage(driver);

        purchase.clickCartIcon();
        purchase.clickPlaceOrder();
        purchase.clickClose(); // Close without entering data
    }

    @Test(priority = 2)
    public void completePurchase() {
        driver.get("https://demoblaze.com");
        PurchasePage purchase = new PurchasePage(driver);

        purchase.clickCartIcon();
        purchase.clickPlaceOrder();
        purchase.fillOrderForm("Rahma KP", "India", "Malappuram", "1234567890123456", "11", "2025");
        purchase.clickPurchase();

        // Verify confirmation message
        String confirmation = purchase.getConfirmationMessage();
        System.out.println("Confirmation: " + confirmation);
        Assert.assertTrue(confirmation.contains("Id:"));
        Assert.assertTrue(confirmation.contains("Amount:"));
    }

    @Test(priority = 3)
    public void purchaseWithoutFillingData() {
        driver.get("https://demoblaze.com");
        PurchasePage purchase = new PurchasePage(driver);

        purchase.clickCartIcon();
        purchase.clickPlaceOrder();
        purchase.clickPurchase(); // Click without entering data

        // Handle the alert
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Alert message: " + alertText);
        Assert.assertEquals(alertText, "Please fill out Name and Creditcard.");

        // Accept the alert to close it
        driver.switchTo().alert().accept();
    }

}

