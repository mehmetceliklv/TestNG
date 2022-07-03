package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test(){

        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[9]")).click();

    }
}
