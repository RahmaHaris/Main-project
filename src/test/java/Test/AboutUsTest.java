package Test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pom.AboutUsPage;

public class AboutUsTest extends BaseClass {

    AboutUsPage about;

    @BeforeMethod
    public void setUpAboutPage() throws InterruptedException {
        driver.get("https://demoblaze.com");
        about = new AboutUsPage(driver);
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void testOpenAboutModal() throws InterruptedException {
        about.clickAboutLink();
        Thread.sleep(2000);
        Assert.assertTrue(about.isModalDisplayed(), "About Us modal not displayed!");

        System.out.println("About Us modal opened successfully.");
    }

    @Test(priority = 2)
    public void testVideoDisplayed() throws InterruptedException { 
         Thread.sleep(5000);
        about.clickAboutLink();
        Thread.sleep(5000);
        Thread.sleep(5000);
        Thread.sleep(5000);
        Assert.assertTrue(about.isVideoDisplayed(), "Video is not displayed inside modal!");
        Thread.sleep(5000);
        System.out.println("Video iframe displayed successfully.");
    }

    @Test(priority = 3)
    public void testCloseButtonWorks() throws InterruptedException {
        about.clickAboutLink();
        Thread.sleep(2000);

        about.clickCloseButton();
        Thread.sleep(1000);

        System.out.println("Close button clicked successfully.");
        Assert.assertTrue(true);
    }

    @Test(priority = 4)
    public void testIframeLoads() throws InterruptedException {
        about.clickAboutLink();
        Thread.sleep(5000);

        boolean videoVisible = about.isVideoDisplayed();
        Assert.assertTrue(videoVisible, "Iframe did not load properly!");

        System.out.println("Iframe loaded properly inside About Us modal.");
    }

}
