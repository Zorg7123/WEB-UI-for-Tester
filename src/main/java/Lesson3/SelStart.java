package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SelStart {
        public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.quit();

        WebDriverManager.operadriver().setup();
        WebDriver operaDriver = new OperaDriver();
        operaDriver.get("https://ya.com");
        operaDriver.close();
    }
}
