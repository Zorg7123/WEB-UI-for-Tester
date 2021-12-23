package HW7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class lesson7 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito")
               .addArguments("start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        driver.get("https://www.igromania.ru/");
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/a/span")).click();
        driver.findElement(By.xpath("//*[@id=\"AUTH_USER_LOGIN\"]")).sendKeys("ZZZZzz789");
        driver.findElement(By.xpath("//*[@id=\"AUTH_USER_PWD\"]")).sendKeys("1234567");
        driver.findElement(By.xpath("//*[@id=\"uniholder\"]/div[2]/div/form/div[1]/a")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/a/img")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/a/picture/img")).click();
    }
}
