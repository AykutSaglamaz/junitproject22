package com.arcane.tests;

import com.arcane.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day07_C16_Actions3 extends TestBase {
   /*
    1- test method olustur : keysUpDown()
    2- https://www.google.com sayfasina git
    3- Search box'a 'iPhone Pro Max' text'i gonder => kucuk harfleri buyuk harfe cevir yada tersini yap.
    4- cift tiklayarak search box'i etkilestir
 */
//   WebDriver driver;
//    @Before
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
    @Test
    public void keysUpDown() throws InterruptedException {
//      2- https://www.google.com sayfasina git
        driver.navigate().to("https://www.google.com");
//        3- Search box'a 'iPhone Pro Max' text'i gonder => kucuk harfleri buyuk harfe cevir yada tersini yap.

        WebElement searchBox = driver.findElement(By.name("q"));
          //  searchBox.sendKeys("iPhone Pro Max");
        Actions actions = new Actions(driver);
        Thread.sleep(5000);

//        4- cift tiklayarak search box'i etkilestir
        actions.keyDown(searchBox, Keys.SHIFT).// shift button'una bas
                sendKeys("iPhone Pro Max").// element icinde yaz
                keyUp(searchBox, Keys.SHIFT).// shift butonunu basmayi birak
                sendKeys(" 14 cok pahali" + Keys.ENTER).
                build(). // build() opsiyoneldir, perform() daha guclu yapar, build () olmadan da calisir
                perform();
    }
//    @After
//    public void tearDown(){
//        driver.close();
//    }

}
