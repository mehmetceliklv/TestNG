package tests.day11;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C03_FileExist  {

    @Test
    public void test(){

        System.out.println(System.getProperty("user.home"));
       // C:\Users\Mehmet\Desktop\github2.PNG


        String dosyaYoluDinamik=System.getProperty("user.home")+"\\Desktop\\github2.PNG";
        System.out.println("dosya yolumuz :"+dosyaYoluDinamik);

        //System.out.println(Files.exists(Paths.get(dosyaYolu)));;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluDinamik)));

        System.out.println(System.getProperty("user.dir"));
        // icinde oldugumuz dosyanin yolunu verir



    }
}
