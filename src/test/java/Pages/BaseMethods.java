package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BaseMethods {
    public static WebDriver driver = null;

    public void initialize() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void mouseHover(By locator) {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void waitUntilElementClickable(By locator) {
        try {
            WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(10));
            wt.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception exception) {
            System.out.print("Element ekranda görüntülenemedi.");
        }
    }

    public void sendKeys(By locator, String key) {
        driver.findElement(locator).sendKeys(key);
    }

    public void waitElementVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception ignored) {
        }
    }

    public void openLastPage() {
        Set<String> windows = driver.getWindowHandles();
        int i = 0;
        for (String handle : windows) {
            i++;
            if (i == windows.size())
                driver.switchTo().window(handle);
        }
    }

    public List<WebElement> getList(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public boolean isElementPresent(By locator) {
        waitElementVisible(locator);
        return driver.findElements(locator).size() > 0;
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }
}
