package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {
    /*    1-Test01 isimli bir class olusturun
    2- https://www.walmart.com/ adresine gidin
                3- Browseri tam sayfa yapin
    4-Sayfayi “refresh” yapin
    5- Sayfa basliginin “Save” ifadesi icerdigini control edin
    6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
    7- URL in walmart.com icerdigini control edin
    8-”Nutella” icin arama yapiniz
    9- Kac sonuc bulundugunu yaziniz
    10-Sayfayi kapatin*/
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        driver.get("https://www.walmart.com/");
        driver.manage().window().maximize();
        driver.navigate().refresh();

        String tittle= driver.getTitle();

        if (tittle.contains("Save")){
            System.out.println("title save iceriyor , test PASS");

        }else{
            System.out.println("icermiyor; test FAILED");
        }

        if (tittle.equals("Walmart.com | Save Money. Live Better.")){
            System.out.println("title esit, PASS");
        }else {
            System.out.println("title esit degil,  FAILED");
        }

        String url = driver.getCurrentUrl();

        if (url.contains("walmart.com")){
            System.out.println("url ayni, test PASS");
        }else {
            System.out.println("url ayni degil, FAILED");
        }

        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@name='query']"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        WebElement aranan= driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println(aranan.getText());

        driver.quit();



    }
}
