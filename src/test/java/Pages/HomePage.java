package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BaseMethods {

    By BTN_MYACCOUNT = By.xpath("//div[@id='myAccount']");
    By BTN_LOGIN = By.xpath("//a[@id='login']");
    By BTN_ELEKTRONIK = By.xpath("//span[text()='Elektronik']");
    By BTN_BLGTABLET = By.xpath("//a[text()='Bilgisayar/Tablet']");
    By BTN_DIZUSTUBILGISAYAR = By.xpath("//a[text()='Dizüstü Bilgisayar']");

    String title = "Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com";

    public HomePage sayfaYuklendiKontrol() {
        Assert.assertEquals(getTitle(), title);
        return this;
    }

    public void loginEkraninaGit() {
        mouseHover(BTN_MYACCOUNT);
        waitUntilElementClickable(BTN_LOGIN);
        click(BTN_LOGIN);
    }

    public void dizustuBilgisayarGit() {
        mouseHover(BTN_ELEKTRONIK);
        mouseHover(BTN_BLGTABLET);
        waitUntilElementClickable(BTN_DIZUSTUBILGISAYAR);
        click(BTN_DIZUSTUBILGISAYAR);
    }
}
