import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.Assert.assertTrue;

public class HomePageTests extends BaseTest {

    @Test
    public void testImportantQuestionsHeaderIsVisible() {
        assertTrue(driver.findElement(homePage.importantQuestionsHeader).isDisplayed());
    }

    @Test
    public void testAccordionSection0() {
        driver.findElement(homePage.accordionHeading0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.accordionContent0));
        String text = driver.findElement(homePage.accordionContent0).getText();
        assertTrue(text.contains("Сутки — 400 рублей. Оплата курьеру — наличными или картой."));
    }

    @Test
    public void testAccordionSection1() {
        driver.findElement(homePage.accordionHeading1).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.accordionContent1));
        String text = driver.findElement(homePage.accordionContent1).getText();
        assertTrue(text.contains("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."));
    }

    @Test
    public void testAccordionSection2() {
        driver.findElement(homePage.accordionHeading2).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.accordionContent2));
        String text = driver.findElement(homePage.accordionContent2).getText();
        assertTrue(text.contains("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."));
    }

    @Test
    public void testAccordionSection3() {
        driver.findElement(homePage.accordionHeading3).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.accordionContent3));
        String text = driver.findElement(homePage.accordionContent3).getText();
        assertTrue(text.contains("Только начиная с завтрашнего дня. Но скоро станем расторопнее."));
    }

    @Test
    public void testAccordionSection4() {
        driver.findElement(homePage.accordionHeading4).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.accordionContent4));
        String text = driver.findElement(homePage.accordionContent4).getText();
        assertTrue(text.contains("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."));
    }

    @Test
    public void testAccordionSection5() {
        driver.findElement(homePage.accordionHeading5).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.accordionContent5));
        String text = driver.findElement(homePage.accordionContent5).getText();
        assertTrue(text.contains("Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."));
    }

    @Test
    public void testAccordionSection6() {
        driver.findElement(homePage.accordionHeading6).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.accordionContent6));
        String text = driver.findElement(homePage.accordionContent6).getText();
        assertTrue(text.contains("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."));
    }

    @Test
    public void testAccordionSection7() {
        driver.findElement(homePage.accordionHeading7).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.accordionContent7));
        String text = driver.findElement(homePage.accordionContent7).getText();
        assertTrue(text.contains("Да, обязательно. Всем самокатов! И Москве, и Московской области."));
    }

}
