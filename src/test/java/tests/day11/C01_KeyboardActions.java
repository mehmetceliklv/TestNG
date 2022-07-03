package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_KeyboardActions extends TestBase {

    @Test
    public void test(){

        driver.get("https://www.amazon.com");

        Actions actions=new Actions(driver);
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
         /*
        actions.click(aramaKutu).perform();
        actions.sendKeys("samsung ").perform();
        actions.keyDown(Keys.SHIFT).perform();
        actions.sendKeys("a").perform();
        actions.keyUp(Keys.SHIFT).perform();
        actions.sendKeys("71").perform();
        actions.sendKeys(Keys.ENTER).perform();
        */

        // simdiye kadar once locate edip. o webelement uzerinden sendKeys yapiyorduk
        // aramaKutu.sendKeys("samsung A71");

        actions.click(aramaKutusu)
                .sendKeys("samsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .perform();

        actions.sendKeys(Keys.ENTER).perform();

        //4- aramanin gerceklestigini test edin

        String arananKelime="samsung A71";
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains(arananKelime),"arama yapilamadi");

    }
}
