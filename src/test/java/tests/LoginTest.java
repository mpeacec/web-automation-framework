package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class LoginTest extends BaseTest {

  @Test(groups = "smoke")
  public void shouldLoginSuccessfully() {
    String baseUrl = ConfigReader.get("baseUrl");
    driver.get(baseUrl + "/login");

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login("tomsmith", "SuperSecretPassword!");

    String message = loginPage.getSuccessMessage();
    Assert.assertTrue(
        message.contains("You logged into a secure area!"),
        "Expected success message to contain login confirmation.");
  }
}
