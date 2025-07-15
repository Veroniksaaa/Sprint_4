import PajeObject.OrderPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest extends BaseTest {

    private final String orderButtonPosition; // "top" или "middle"
    private final String name;
    private final String surname;
    private final String address;
    private final String metroStation;
    private final String phoneNumber;
    private final int option;
    private final int numberOfDays;

    public OrderPageTest(String orderButtonPosition, String name, String surname, String address, String metroStation, String phoneNumber, int option, int numberOfDays) {
        this.orderButtonPosition = orderButtonPosition;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.option = option;
        this.numberOfDays = numberOfDays;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"top", "Иван", "Иванов", "Ленина 1", "Пушкинская", "+79990001122", 1, 1},
                {"middle", "Пётр", "Петров", "Пушкина 2", "Комсомольская", "+79990003344", 2, 2}
        });
    }

    @Test
    public void OrderPageButton() {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.openPage();
        orderPage.clickCookieButton();

        // Выбор кнопки "Заказать" в зависимости от позиции
        orderPage.choosingAndClickOrderButton(orderButtonPosition);

        // Заполнение формы заказа
        //Добавлено 2 опции на выбор даты
        //1 – 14 июля 2025 / 2– 15 июля 2025
        orderPage.fillOrderForm(name, surname,address, metroStation, phoneNumber, option, numberOfDays);

        // Проверка, что окно оформления заказа появилось
        assertTrue("Окно оформления заказа не появилось", orderPage.isCompleteOrderWindowDisplayed());
    }


}