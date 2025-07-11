package PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    //Кнопка закрытия плашки о cookie
    public By cookieButton = By.className("App_CookieButton__3cvqF");
    // Заголовок раздела "Вопросы о важном"
    public By importantQuestionsHeader = By.xpath("//div[@class='Home_SubHeader__zwi_E' and text()='Вопросы о важном']");

    //Вопросы и ответы
    public By accordionHeading0 = By.id("accordion__heading-0");
    public By accordionContent0 = By.xpath("//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");

    public By accordionHeading1 = By.id("accordion__heading-1");
    public By accordionContent1 = By.xpath("//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");

    public By accordionHeading2 = By.id("accordion__heading-2");
    public By accordionContent2 = By.xpath("//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']");

    public By accordionHeading3 = By.id("accordion__heading-3");
    public By accordionContent3 = By.xpath("//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']");

    public By accordionHeading4 = By.id("accordion__heading-4");
    public By accordionContent4 = By.xpath("//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']");

    public By accordionHeading5 = By.id("accordion__heading-5");
    public By accordionContent5 = By.xpath("//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']");

    public By accordionHeading6 = By.id("accordion__heading-6");
    public By accordionContent6 = By.xpath("//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']");

    public By accordionHeading7 = By.id("accordion__heading-7");
    public By accordionContent7 = By.xpath("//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']");
}