package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class NegativeLoginTest extends BaseTest {

  @Test
  public void shouldCaptureScreenshotOnFailure() {
    if (!Boolean.getBoolean("failureDemo")) {
      throw new SkipException("Set -DfailureDemo=true to run this intentional failure test.");
    }

    String baseUrl = ConfigReader.get("baseUrl");
    driver.get(baseUrl + "/login");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("tomsmith", "wrongPassword");

    String message = loginPage.getFlashMessage();
    Assert.assertTrue(
        message.contains("Your password is invalid!"), "Expected invalid password message.");

    Assert.fail("Intentional failure to verify screenshot capture on test failure.");
  }
}
