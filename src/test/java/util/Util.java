package util;

import base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class Util extends BaseTest {


    public WebElement findElement(String key){
        WebElement element = (new WebDriverWait(driver, 5, 300))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector(key)));
        return element;
    }

    public void titleControl(){
        String title = driver.getCurrentUrl();
        System.out.println(title);
        Assert.assertTrue(title.contains("https://www.n11.com/"));
    }

    public void waitSecond(long milliseconds) throws InterruptedException {
            Thread.sleep(milliseconds);
    }

    public void clickToElement(String key) throws InterruptedException {
        WebElement element = findElement(key);
        waitSecond(500);
        element.click();
    }

    public void sendKeysToElement(String key, String text) throws InterruptedException {
        WebElement element = findElement(key);
        waitSecond(500);
        element.sendKeys(text);
    }

    public void navigateTo() {
        driver.navigate().to("https://www.n11.com/arama?q=bilgisayar&pg=2");
    }

    public void getTextControl(String key,String pageNumber){
        String deneme = findElement(key).getText();
        System.out.println(deneme);
        System.out.println(pageNumber);
        Assert.assertTrue(deneme.contains(pageNumber));
    }

    public List<WebElement> findElements(String key) {
        try {
            WebDriverWait waitForFormLabel = new WebDriverWait(driver, 30);
            List<WebElement> elements = driver.findElements(By.cssSelector(key));
            waitForFormLabel.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;

        } catch (Exception ex) {
            Assert.fail("" + key + "'li element 10 saniye boyunca arandı fakat bulunamadı..!!!");
            return null;
        }
    }


    public void randomClick(String key) {
        List<WebElement> elements = findElements(key);
        Random r = new Random();
        int low = 1;
        int high = elements.size();
        int result = r.nextInt(high - low) + low;
        elements.get(result).click();
        System.out.println(result + ". Elemente tıklandı..");
    }

    public void priceControl(String productPrice,String basketPrice){
        String priceProduct = findElement(productPrice).getText();
        String priceBasket = findElement(basketPrice).getText();
        System.out.println(priceBasket);
        System.out.println(priceProduct);
        Assert.assertEquals("Price product and price basket not equal!",priceProduct,priceBasket);
    }

    public void getAmountControl(String key,String amountNumber){
        String deneme = findElement(key).getAttribute("value");
        Assert.assertEquals(deneme,amountNumber);
    }

}
