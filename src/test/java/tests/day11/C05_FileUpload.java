package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void test() throws InterruptedException {

        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim

        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        String dosyaYolu=System.getProperty("user.home")+ "\\Desktop\\github2.PNG";
        WebElement dosyaYukle= driver.findElement(By.id("file-upload"));


        dosyaYukle.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);

        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(sonucYazisiElementi.isDisplayed());

    }
}
