import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageTest extends BaseTest {

    private String orderButtonPosition; // "top" или "middle"
    private String name;
    private String surname;
    private String address;
    private String metroStation;
    private String phoneNumber;

    public OrderPageTest(String orderButtonPosition, String name, String surname, String address, String metroStation, String phoneNumber) {
        this.orderButtonPosition = orderButtonPosition;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
                {"top", "Иван", "Иванов", "Ленина 1", "Пушкинская", "+79990001122"},
                {"middle", "Пётр", "Петров", "Пушкина 2", "Комендантский проспект", "+79990003344"}
        });
    }

    @Test
    public void OrderPageButton() {
        orderPage.openPage();
        orderPage.clickCookieButton();

        // Выбор кнопки "Заказать" в зависимости от позиции
        if ("top".equals(orderButtonPosition)) {
            orderPage.clickOrderButton();
        } else if ("middle".equals(orderButtonPosition)) {
            orderPage.clickOrderButtonMiddle();
        } else {
            throw new IllegalArgumentException("Неизвестная позиция кнопки: " + orderButtonPosition);
        }

        // Заполнение формы заказа
        fillOrderForm();

        // Проверка, что окно оформления заказа появилось
        assertTrue("Окно оформления заказа не появилось", orderPage.isCompleteOrderWindowDisplayed());
    }

    // Метод для заполнения формы заказа (повторяющиеся действия)
    private void fillOrderForm() {
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.findAndClickMetroInput(metroStation);
        orderPage.selectMetroStation();
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.findAndClickWhen();
        orderPage.chooseDateWhen();
        orderPage.chooseRentalPeriodBox();
        orderPage.chooseRentalPeriod();
        orderPage.clickMiddleButtonOrder();
        orderPage.chekOrder();
        orderPage.clickButtonYes();
    }
}