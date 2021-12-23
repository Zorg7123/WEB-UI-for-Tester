package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.time.Duration;

public class HW5 {
    public static WebDriver driver;
    private final static String MAIN_PAGE_URL = "https://www.igromania.ru/";

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--maximized");
        options.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
    }

    @Test
            void Test() throws InterruptedException {
        autoregistration();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
    void autoregistration() {
        driver.get(MAIN_PAGE_URL);
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"AUTH_USER_LOGIN\"]")).sendKeys("ZZZZzz789");
        driver.findElement(By.xpath("//*[@id=\"AUTH_USER_PWD\"]")).sendKeys("1234567");
        driver.findElement(By.xpath("//*[@id=\"uniholder\"]/div[2]/div/form/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a/picture/img")).click();
    }
}
