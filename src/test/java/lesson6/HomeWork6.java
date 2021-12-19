package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeWork6 {
    WebDriver driver;
    MainPage mainPage;
    LoginBlock loginBlock;
    private final static String IGROMANIA_BASE_URL = "https://www.igromania.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginBlock = new LoginBlock(driver);
        driver.get(IGROMANIA_BASE_URL);
    }

    @Test
    void likeRandomMovieTest() throws InterruptedException {

        new MainPage(driver).clickLoginButton();

        new LoginBlock(driver)
                .switchToLoginFrame()
                .fillLoginInput("ZZZZzz789")
                .fillPasswordInput("1234567")
                .submitLogin();
        Thread.sleep(2000);

        new MainPage(driver)
                .clickToAccount("Личный кабинет");

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

}
