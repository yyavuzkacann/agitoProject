Feature: Sepete Ürün Ekleme
  Scenario: Ürünün sepete eklendiğinin kontrolü yapılır
    Given anasayfaya gidilir
    When kullanici adi ve sifre girilerek login olunur
    And dizustu bilgisayar sayfasina gidilir
    And urun secilerek sepete eklenir
    Then urunun sepete eklendigi kontrol edilir