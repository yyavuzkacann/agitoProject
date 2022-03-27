package Pages;

import org.openqa.selenium.By;

public class LaptopPage extends BaseMethods {

    By LBL_4_URUN = By.xpath("//ul[starts-with(@class,'productListContent-wrapper productListContent-grid')]//li[@class='productListContent-item'][4]");

    public void urunSec() {
        click(LBL_4_URUN);
    }
}
