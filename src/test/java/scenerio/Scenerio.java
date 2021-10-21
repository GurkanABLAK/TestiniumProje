package scenerio;

import base.BaseTest;
import org.junit.Test;
import util.Util;

public class Scenerio extends BaseTest {

    Util steps = new Util();

    @Test
    public void test() throws InterruptedException {

        //Giriş alanında problem olduğu için bu alana dair stepler yorum satırı olarak bırakılmıştır.

        steps.titleControl(); //Siteye giriş gerçekleşti ve kontrol sağlandı.
        //steps.clickToElement(".btnSignIn"); //Giriş yap butonuna tıklandı
        steps.waitSecond(1000); //Sayfanın yüklenmesi bekleniyor
        //steps.sendKeysToElement("[name='email']","falot46053@koldpak.com"); //Kullanıcı adı yazıldı
        //steps.sendKeysToElement("[name='password']","123456t"); //Kullanıcı şifresi girildi
        //steps.clickToElement("div.green_flat"); //Login butonuna tıklandı
        //steps.waitSecond(1000); //Sayfanın yüklenmesi bekleniyor
        steps.sendKeysToElement("form input[type='text']","bilgisayar"); //Search box a bilgisayar yazıldı
        steps.clickToElement(".searchBtn"); //Arama butonuna tıklandı
        steps.navigateTo(); //2.sayfaya gidildi
        steps.waitSecond(2000); //Sayfanın yüklenmesi bekleniyor
        steps.getTextControl(".pagination .active","2"); //2.sayfa olduğu doğrulandı
        steps.randomClick("ul.clearfix li.column a img"); //Rastgele bir ürün seçildi
        steps.waitSecond(3000); //Sayfanın yüklenmesi bekleniyor
        steps.clickToElement(".product-add-cart a[title='Sepete Ekle']"); //Ürün sepete eklendi
        steps.waitSecond(2000); //Sayfanın yüklenmesi bekleniyor
        steps.clickToElement("a.myBasket "); //Sepet e gidildi
        steps.waitSecond(2000); //Sayfanın yüklenmesi bekleniyor
        steps.clickToElement("[class='btn btnBlack']"); //Pop-up kapatıldı
        steps.priceControl(".priceTag span","[class='dtl total'] .price"); //Ürün fiyatı kontrol edildi
        steps.clickToElement("[class='spinnerUp spinnerArrow']"); //Ürün adeti 2 olarak güncellendi
        steps.waitSecond(1000); //Sayfanın yüklenmesi bekleniyor
        steps.getAmountControl("input[class='quantity']","2"); //Ürün adeti doğrulandı
        steps.clickToElement("[class='removeProd svgIcon svgIcon_trash']"); //Sepette bulunan ürünler silindi
        steps.waitSecond(2000); //Sayfanın yüklenmesi bekleniyor
        steps.getTextControl(".cartEmptyText","Sepetiniz Boş"); //Sepetin boş olduğu doğrulandı.
    }
}
