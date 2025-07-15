import PajeObject.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {
    public WebDriver driver;
    HomePage homePage;


//Выбор браузера
    @Before
    public void initBrowser() {
        String browser = System.getProperty("browser", "chrome"); // "chrome" — значение по умолчанию
        if (browser.equals("chrome")) {
            startBrowserChrome();
        } else if (browser.equals("firefox")) {
            startBrowserFirefox();
        }
    }

    public void startBrowserFirefox() {
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        homePage = new HomePage(driver);
    }

    public void startBrowserChrome() {
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        homePage = new HomePage(driver);

    }
    //закрытие браузера после каждого теста
    @After
    public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
    }
}
