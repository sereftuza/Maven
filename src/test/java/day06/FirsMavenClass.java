package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirsMavenClass {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        driver.get("http://amazon.com");
        driver.manage().window().maximize();

        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@name='field-keywords']"));
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

        WebElement sonucYaisi= driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYaisi.getText());

        //Thread.sleep(1000);  // sayfa gecisinde bekleme
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        driver.navigate().back();

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for (WebElement w: basliklarListesi) {
            System.out.println(w.getText());
        }

        driver.quit();







    }
}
