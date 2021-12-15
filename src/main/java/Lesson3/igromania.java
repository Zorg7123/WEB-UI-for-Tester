package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//авторизация
public class igromania {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");// инкогнито
        options.addArguments("start-maximized");//окно во весь экран
        options.addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.igromania.ru/");
        WebElement buttonEntrance = driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/a/span"));//кнопка вход
        //new WebDriverWait(driver, Duration.ofSeconds(7)).until(ExpectedConditions.visibilityOf(buttonEntrance));//(пока джава ждет нажимаем закрыть рекламу) зашел в виде бота
        buttonEntrance.click(); //нажать на вход
        //            Логин
        WebElement Login = driver.findElement(By.xpath("//*[@id=\"AUTH_USER_LOGIN\"]"));
        Login.click();
        Login.sendKeys("ZZZZzz789");
        //           Пароль
        WebElement Password = driver.findElement(By.xpath("//*[@id=\"AUTH_USER_PWD\"]"));
        Password.click();
        Password.sendKeys("1234567");
        //       Авторизоваться
        WebElement buttonEnter = driver.findElement(By.xpath("//*[@id=\"uniholder\"]/div[2]/div/form/div[1]/a"));
        buttonEnter.click();

        //       Перейти в личный кабинет
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/a/img")).click();
        //        Главная страница
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a/picture/img")).click();
        //
        driver.quit();
    }
}
