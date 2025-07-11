import PajeObject.HomePage;
import PajeObject.OrderPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public HomePage homePage;
    public WebDriverWait wait;
    public OrderPage orderPage;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        homePage = new HomePage(driver);
        orderPage = new OrderPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Закрываем cookie, если появляется
        if (!driver.findElements(homePage.cookieButton).isEmpty()) {
            driver.findElement(homePage.cookieButton).click();
        }
        // Закрываем cookie, если появляется
        if (!driver.findElements(orderPage.cookieButton).isEmpty()) {
            driver.findElement(orderPage.cookieButton).click();
        }
    }
    @After
    public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
    }
}
