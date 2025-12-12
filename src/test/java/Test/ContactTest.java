
package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseClass;
import pom.ContactPage;

public class ContactTest extends BaseClass {

    // -------------------------------------------------------------------------
    // TC_01: Send message with valid data
    // -------------------------------------------------------------------------
    @Test(priority = 1)
    public void testContactSendMessage() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("rahma@test.com");
        contact.enterName("Rahma");
        contact.enterMessage("Hello, this is a test message.");
        contact.clickSendMessage();
        contact.acceptAlert();
    }

    // -------------------------------------------------------------------------
    // TC_02: Send message without entering any data (BUG EXPECTED)
    // -------------------------------------------------------------------------
    @Test(priority = 2)
    public void testContactWithoutEnteringData() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.clickSendMessage();
        contact.acceptAlert();  // BUG: Alert still appears
    }

    // -------------------------------------------------------------------------
    // TC_03: Invalid email format (BUG EXPECTED)
    // -------------------------------------------------------------------------
    @Test(priority = 3)
    public void testInvalidEmailFormat() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("invalid-email");
        contact.enterName("Rahma");
        contact.enterMessage("Testing invalid email format.");
        contact.clickSendMessage();
        contact.acceptAlert();  // BUG
    }

    // -------------------------------------------------------------------------
    // TC_04: Email empty but name + message provided (BUG EXPECTED)
    // -------------------------------------------------------------------------
    @Test(priority = 4)
    public void testEmailEmpty() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterName("Rahma");
        contact.enterMessage("Email missing test.");
        contact.clickSendMessage();
        contact.acceptAlert(); // BUG
    }

    // -------------------------------------------------------------------------
    // TC_05: Name empty (BUG EXPECTED)
    // -------------------------------------------------------------------------
    @Test(priority = 5)
    public void testNameEmpty() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("rahma@test.com");
        contact.enterMessage("Name field empty test.");
        contact.clickSendMessage();
        contact.acceptAlert(); // BUG
    }

    // -------------------------------------------------------------------------
    // TC_06: Message empty (BUG EXPECTED)
    // -------------------------------------------------------------------------
    @Test(priority = 6)
    public void testMessageEmpty() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("rahma@test.com");
        contact.enterName("Rahma");
        contact.clickSendMessage();
        contact.acceptAlert(); // BUG
    }

    // -------------------------------------------------------------------------
    // TC_07: Extremely long message
    // -------------------------------------------------------------------------
    @Test(priority = 7)
    public void testLongMessage() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("rahma@test.com");
        contact.enterName("Rahma");

        String longMessage = "A".repeat(5000);
        contact.enterMessage(longMessage);

        contact.clickSendMessage();
        contact.acceptAlert();
    }

    // -------------------------------------------------------------------------
    // TC_08: Message with special characters
    // -------------------------------------------------------------------------
    @Test(priority = 8)
    public void testSpecialCharactersMessage() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("rahma@test.com");
        contact.enterName("Rahma");
        contact.enterMessage("!@#$%^&*()<>?/~`+=-{}[]|;: Testing special chars.");

        contact.clickSendMessage();
        contact.acceptAlert(); 
    }

    // -------------------------------------------------------------------------
    // TC_09: Close contact form without sending
    // -------------------------------------------------------------------------
  /*  @Test(priority = 9)
    public void testCloseModalWithoutSending() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.closeContactForm();

        Assert.assertFalse(contact.isContactFormDisplayed(),
                "Contact form should be closed, but it is still visible.");
    }

    // -------------------------------------------------------------------------
    // TC_10: Double click send button
    // -------------------------------------------------------------------------
    @Test(priority = 10)
    public void testDoubleClickSend() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("rahma@test.com");
        contact.enterName("Rahma");
        contact.enterMessage("Double click send test.");

        contact.clickSendMessage();
        contact.clickSendMessage(); // Should not accept double click

        contact.acceptAlert();
    }*/

    // -------------------------------------------------------------------------
    // TC_11: XSS payload test (Security test)
    // -------------------------------------------------------------------------
    @Test(priority = 11)
    public void testXSSPayload() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("rahma@test.com");
        contact.enterName("Rahma");
        contact.enterMessage("<script>alert('xss')</script>");

        contact.clickSendMessage();
        contact.acceptAlert(); // BUG if system accepts script
    }

    // -------------------------------------------------------------------------
    // TC_12: Alert does not appear (System fail scenario)
    // -------------------------------------------------------------------------
    @Test(priority = 12)
    public void testAlertNotPresent() {
        driver.get("https://demoblaze.com");
        ContactPage contact = new ContactPage(driver);

        contact.openContactForm();
        contact.enterEmail("rahma@test.com");
        contact.enterName("Rahma");
        contact.enterMessage("Checking alert presence.");

        contact.clickSendMessage();

        try {
            contact.acceptAlert();
        } catch (Exception e) {
            System.out.println("ALERT DID NOT APPEAR → BUG FOUND");
            Assert.fail("Alert not present when expected.");
        }
    }
}

