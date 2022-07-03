package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class C02_IFrame {
    //    ● Bir class olusturun: C02_IframeTest
    //    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //    ● Bir metod olusturun: iframeTest
    //		○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.
    //		○ Text Box’a “Merhaba Dunya!” yazin.
    //		○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
    //		dogrulayin ve  konsolda yazdirin.


    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    @Test
    public void test(){
        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda 	yazdirin.

     WebElement baslikYazisi=driver.findElement(By.tagName("h3"));
     Assert.assertTrue(baslikYazisi.isEnabled(),"baslik yazisi ulasilabilir degil");
     System.out.println(baslikYazisi.getText());

        //		○ Text Box’a “Merhaba Dunya!” yazin.

    // WebElement iFrame=driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
    // driver.switchTo().frame(iFrame);
        driver.switchTo().frame(0); // en hizli iframein indexini girerek oluyor.
      //  driver.switchTo().frame("mce_0_ifr");
     WebElement yaziKutusu=driver.findElement(By.xpath("//body[@data-id='mce_0']"));
     yaziKutusu.clear();
     yaziKutusu.sendKeys("Merhaba Dunya");

        //bir iFrame'e gecis yaptiktan sonra yeniden ana sayfa ile ilgili islem yapmak isterseniz
        // gecis yaptigimiz iFrame'den geri donmeliyiz

     driver.switchTo().defaultContent();

        //		○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        //		dogrulayin ve  konsolda yazdirin.



        SoftAssert softAssert=new SoftAssert();

        WebElement altYazi=driver.findElement(By.linkText("Elemental Selenium"));
        softAssert.assertTrue(altYazi.isDisplayed());
        System.out.println(altYazi.getText());

        softAssert.assertAll();




    }







    @AfterClass
    public void tearDown(){

       driver.close();
    }
}
