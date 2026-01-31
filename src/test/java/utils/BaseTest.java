package utils;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class BaseTest {
  private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();
  protected WebDriver driver;

  @BeforeMethod
  public void setUp() {
    String browser = ConfigReader.get("browser").toLowerCase();
    boolean headless = ConfigReader.getBoolean("headless", false);

    if (!"chrome".equals(browser)) {
      throw new IllegalArgumentException(
          "Unsupported browser: " + browser + ". Only chrome is supported.");
    }

    WebDriverManager.chromedriver().setup();
    ChromeOptions options = new ChromeOptions();

// Headless'ı config'ten oku (sende var)
// boolean headless = config.isHeadless(); // veya ConfigReader.getBoolean("headless")

// CI'da güvenli varsayılan: GitHub Actions ortamını yakala
boolean isCI = "true".equalsIgnoreCase(System.getenv("CI"));

if (headless || isCI) {
    options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    options.addArguments("--window-size=1920,1080");
    options.addArguments("--disable-gpu");
}
driver = new ChromeDriver(options);

    driver = new ChromeDriver(options);
    DRIVER_THREAD_LOCAL.set(driver);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
    driver.manage().window().maximize();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() {
    if (driver != null) {
      driver.quit();
    }
    DRIVER_THREAD_LOCAL.remove();
  }

  public static WebDriver getDriver() {
    return DRIVER_THREAD_LOCAL.get();
  }
}
