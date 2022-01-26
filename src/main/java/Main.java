import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    System.out.println(System.getenv("PATH"));
    System.out.println(System.getenv("HOME"));
  //  System.out.println(System.getenv(""));

    System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
   // File pathBinary = new File("src/main/resources/firefox");
  //  FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
   // DesiredCapabilities desired = new DesiredCapabilities();
    FirefoxOptions options = new FirefoxOptions();
   // desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
    WebDriver driver = new FirefoxDriver(options);
    driver.get("https://accounts.google.com/AccountChooser/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser");



    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));

    WebElement inputName = driver.findElement(new By.ById("identifierId"));
    inputName.sendKeys("alanrodriguez@elpuig.xeill.net");

    WebElement inputButton = driver.findElement(new By.ById("identifierNext"));
    inputButton.click();

    wait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("whsOnd zHQkBf")));

    WebElement inputPassword = driver.findElement(new By.ByClassName("whsOnd zHQkBf"));
    inputPassword.sendKeys("123");






    wait2.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("passwordNext")));
    WebElement inputButtonNext = driver.findElement(new By.ById("passwordNext"));

    inputButtonNext.click();

  }

}
