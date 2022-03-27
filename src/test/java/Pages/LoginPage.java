package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BaseMethods {

    By INP_USERNAME = By.xpath("//input[@id='txtUserName']");
    By INP_PASSWORD = By.xpath("//input[@id='txtPassword']");
    By BTN_LOGIN = By.xpath("//button[@id='btnLogin']");
    By BTN_LOGIN_AFTER_PASS = By.xpath("//button[@id='btnEmailSelect']");
    By LBL_HATA = By.xpath("(//div[@type='ERROR'])[1]");

    String kullaniciAdi = "paxoca7156@jo6s.com";
    String sifre = "testUser1";

    public LoginPage kullaniciYaz() {
        sendKeys(INP_USERNAME, kullaniciAdi);
        click(BTN_LOGIN);
        return this;
    }

    public LoginPage sifreYaz() {
        waitElementVisible(INP_PASSWORD);
        sendKeys(INP_PASSWORD, sifre);
        return this;
    }

    public void girisYap() {
        click(BTN_LOGIN_AFTER_PASS);
        if (isElementPresent(LBL_HATA))
            Assert.fail(getText(LBL_HATA));
    }
}
