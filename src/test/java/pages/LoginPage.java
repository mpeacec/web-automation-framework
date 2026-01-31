package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Waits;

public class LoginPage {
  private final WebDriver driver;
  private final Waits waits;

  private final By usernameInput = By.id("username");
  private final By passwordInput = By.id("password");
  private final By loginButton = By.cssSelector("button[type='submit']");
  private final By successMessage = By.cssSelector("div.flash.success");
  private final By flashMessage = By.cssSelector("div.flash");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
    this.waits = new Waits(this.driver, Duration.ofSeconds(10));
  }

  public void login(String username, String password) {
    WebElement usernameEl = waits.visibilityOf(usernameInput);
    usernameEl.clear();
    usernameEl.sendKeys(username);

    WebElement passwordEl = waits.visibilityOf(passwordInput);
    passwordEl.clear();
    passwordEl.sendKeys(password);

    waits.elementToBeClickable(loginButton).click();
  }

  public String getSuccessMessage() {
    return waits.visibilityOf(successMessage).getText();
  }

  public String getFlashMessage() {
    return waits.visibilityOf(flashMessage).getText();
  }
}
