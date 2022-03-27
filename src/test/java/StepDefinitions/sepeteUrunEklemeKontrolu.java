package StepDefinitions;

import Pages.*;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class sepeteUrunEklemeKontrolu extends BaseMethods {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    LaptopPage laptopPage = new LaptopPage();
    UrunDetayPage urunDetayPage = new UrunDetayPage();

    @Given("^anasayfaya gidilir$")
    public void anasayfaya_gidilir() {
        initialize();
        homePage
                .sayfaYuklendiKontrol()
                .loginEkraninaGit();
    }

    @When("^kullanici adi ve sifre girilerek login olunur$")
    public void kullanici_adi_ve_sifre_girilerek_login_olunur() {
        loginPage
                .kullaniciYaz()
                .sifreYaz()
                .girisYap();
    }

    @When("^dizustu bilgisayar sayfasina gidilir$")
    public void dizustu_bilgisayar_sayfasina_gidilir() {
        homePage
                .dizustuBilgisayarGit();
    }

    @When("^urun secilerek sepete eklenir$")
    public void urun_secilerek_sepete_eklenir() {
        laptopPage
                .urunSec();
        urunDetayPage
                .sepeteEkle();
    }

    @Then("^urunun sepete eklendigi kontrol edilir$")
    public void urunun_sepete_eklendigi_kontrol_edilir() {
        urunDetayPage
                .sepeteGit()
                .sepetUrunKontrol();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
