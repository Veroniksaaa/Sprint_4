package PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static PajeObject.OrderPage.URL;

public class HomePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    //Кнопка закрытия плашки о cookie
    public By cookieButton = By.xpath(".//button[@class='App_CookieButton__3cvqF']");

    // Заголовок раздела "Вопросы о важном"
    public By importantQuestionsHeader = By.xpath(".//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");

    //Вопросы и ответы
    public static final By questionPrice = By.id("accordion__heading-0");
    public static final By answer1 = By.xpath("//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    public static final By questionValue = By.id("accordion__heading-1");
    public static final By answer2 = By.xpath("//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");

    public static final By questionRentalTime = By.id("accordion__heading-2");
    public static final By answer3= By.xpath("//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");

    public static final By questionTodayIsPossible = By.id("accordion__heading-3");
    public static final By answer4 = By.xpath("//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");

    public static final By questionReturnEarlier = By.id("accordion__heading-4");
    public static final By answer5 = By.xpath("//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");

    public static final By questionCharger = By.id("accordion__heading-5");
    public static final By answer6 = By.xpath("//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");

    public static final By questionCancel = By.id("accordion__heading-6");
    public static final By answer7 = By.xpath("//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");

    public static final By questionNearMoscow = By.id("accordion__heading-7");
    public static final By answer8 = By.xpath("//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");


    public void openPage() {
        driver.get(URL);
    }
    public void waitForPageToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(importantQuestionsHeader));
    }
    //Нажимаем на кнопку куки
    public void clickCookieButton() {
        if (driver.findElement(cookieButton).isEnabled()) {
            driver.findElement(cookieButton).click();
        }
    }

// Конструктор
public HomePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
}

    public void clickImportantQuestionsHeader() {
        WebElement element = driver.findElement(importantQuestionsHeader);
        // Скроллим до элемента
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

//Кликнуть по вопросу
public void clickQuestion(By questionLocator) {
    driver.findElement(questionLocator).click();
}

//Получить текст ответа
public String getAnswerText(By answerLocator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(answerLocator));
    return driver.findElement(answerLocator).getText();
}
}





