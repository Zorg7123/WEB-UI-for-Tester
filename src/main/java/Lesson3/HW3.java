package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HW3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://diary.ru/user/login");
        WebElement loginField = driver.findElement(By.id("loginform-username"));
        loginField.sendKeys("ZORG333"); //логин
        driver.findElement(By.id("loginform-password")).sendKeys("WmRNLGgA3t"); //пароль

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"))); //Переход в iframe
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click(); //xpath
        driver.switchTo().parentFrame();

        Cookie cookie = new Cookie("_identity_", "fc97c1fe86b3ab4d1b4b6aa4cd6ab7d32cf18e4bc62e452f5d5b311a02704133a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3560083%2C%22mYLwZ_eMDn7zVbGLVkSo2sFSzsgtplBL%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        String postTitle = "Дело №1";
        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();
        driver.findElement(By.id("postTitle")).sendKeys(postTitle);
        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("пока нет");
        driver.switchTo().parentFrame();
        Thread.sleep(3000);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(10))
                .ignoring(NoSuchElementException.class);


        // повторял за преподавателем

    }
}
