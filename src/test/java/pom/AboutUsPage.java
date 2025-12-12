package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AboutUsPage {

    WebDriver driver;
    WebDriverWait wait;

  /*  private By aboutUsLink = By.xpath("//a[text()='About us']");
    private By iframeLocator = By.xpath("//iframe[contains(@src, 'video')]"); // iframe of modal
    private By modalTitle = By.xpath("//h5[text()='About Us']"); // inside iframe

    public AboutUsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAboutUs() {
        driver.findElement(aboutUsLink).click();
    }

    public void switchToAboutUsIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));
    }

    public boolean isModalDisplayed() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
        return title.isDisplayed();
    }

    public void switchBack() {
        driver.switchTo().defaultContent();
    }
}*/     By aboutLink = By.xpath("//a[text()='About us']");
By aboutModal = By.id("videoModal");
By videoFrame = By.id("example-video_html5_api");
By closeButton = By.xpath("//div[@id='videoModal']//button[text()='Close']");

public AboutUsPage(WebDriver driver) {
    this.driver = driver;
}

public void clickAboutLink() {
    driver.findElement(aboutLink).click();
}

public boolean isModalDisplayed() {
    return driver.findElement(aboutModal).isDisplayed();
}

public boolean isVideoDisplayed() {
    WebElement iframe = driver.findElement(videoFrame);
    return iframe.isDisplayed();
}

public void clickCloseButton() {
    driver.findElement(closeButton).click();
}
}