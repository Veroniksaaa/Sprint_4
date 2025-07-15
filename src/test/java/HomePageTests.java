import PajeObject.HomePage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class HomePageTests extends BaseTest {

    private final By questionLocator;
    private final By answerLocator;
    private final String expectedText;


    // Конструктор для параметров
    public HomePageTests(By questionLocator, By answerLocator, String expectedText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedText = expectedText;
    }

    // Параметры теста — локаторы и ожидаемый текст из вашего homePage
    @Parameterized.Parameters(name = "{index}: Проверка вопроса {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {HomePage.questionPrice, HomePage.answer1, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {HomePage.questionValue, HomePage.answer2, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {HomePage.questionRentalTime, HomePage.answer3, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {HomePage.questionTodayIsPossible, HomePage.answer4, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {HomePage.questionReturnEarlier, HomePage.answer5, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {HomePage.questionCharger, HomePage.answer6, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {HomePage.questionCancel, HomePage.answer7, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {HomePage.questionNearMoscow, HomePage.answer8, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }
    @Test
    public void testAccordionSection() {
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.clickCookieButton();
        homePage.waitForPageToLoad();
        homePage.clickImportantQuestionsHeader();  //с прокруткой
        homePage.clickQuestion(questionLocator);
        String actualText = homePage.getAnswerText(answerLocator);
        assertTrue("Текст ответа не соответствует ожиданиям", actualText.contains(expectedText));
    }
}
