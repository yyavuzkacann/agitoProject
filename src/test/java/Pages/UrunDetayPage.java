package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UrunDetayPage extends BaseMethods {

    By BTN_SEPETE_EKLE = By.xpath("//button[@id='addToCart']");
    By BTN_SEPETE_GIT = By.xpath("//button[text()='Sepete git']");
    By LST_SEPETTEKI_URUNLER = By.xpath("//div[starts-with(@class,'merchantBox_')]//ul");

    public void sepeteEkle() {
        openLastPage();
        click(BTN_SEPETE_EKLE);
    }

    public UrunDetayPage sepeteGit() {
        waitUntilElementClickable(BTN_SEPETE_GIT);
        click(BTN_SEPETE_GIT);
        return this;
    }

    public void sepetUrunKontrol() {
        List<WebElement> urunList = getList(LST_SEPETTEKI_URUNLER);

        if (urunList.isEmpty())
            Assert.fail("Sepette ürün bulunmamaktadır!!");
        else
            System.out.print("Ürün sepete başarılı bi şekilde eklenmiştir.");

    }
}
