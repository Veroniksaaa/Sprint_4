package PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class OrderPage extends HomePage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";


    // Кнопка Заказать верхняя
    public By orderButton = By.className("Button_Button__ra12g");
    //Кнопка заказать нижняя
    public By orderButtonMiddle = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");


    // Поля формы заказа первая часть
    //Поле Имя
    public By inputName = By.xpath(".//input[@*='* Имя']");
    //Поле Фамилия
    public By inputSurname = By.xpath(".//input[@*='* Фамилия']");
    //Поле Адрес
    public By inputAddress = By.xpath(".//input[@*='* Адрес: куда привезти заказ']");
    //Поле Метро
    public By metroStationSelect = By.xpath(".//input[@class='select-search__input']");
    //Поле выбора станции
    public By metroStationInputValue = By.xpath(".//div[@class='select-search__select']");
    //Поле Телефон
    public By inputPhone = By.xpath(".//input[@*='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    public By nextButton = By.xpath(".//button[text()='Далее']");

    //Поля формы заказа вторая часть
    // Поле выбора даты
    public By dateInput = By.xpath(".//input[@*='* Когда привезти самокат']");
    //Кнопка выбора даты календаря (конкретные даты)
    // 14 июля 2025
    private final By date14July2025 = By.xpath(".//*[contains(@class,'react-datepicker__day react-datepicker__day--014')]");
    // 15 июля 2025
    private final By date15July2025 = By.xpath(".//*[contains(@class,'react-datepicker__day react-datepicker__day--015')]");

    //Данные для поля выбора кол-ва дней
    private final By numberOfDaysOne = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    private final By numberOfDaysTwo = By.xpath(".//div[@class='Dropdown-option' and text()='двое суток']");

    //Выбор срока аренды
    public By rentalPeriod = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Кнопка заказать внизу формы
    public By orderButtonForm = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and contains(text(), 'Заказать')]");
    //Поп-ап "Хотите оформить заказ?"
    public By checkPlaceOrder = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Хотите оформить заказ?']");
    // Кнопка Да
    public By yesButton = By.xpath("//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");

    // Всплывающее окно с сообщением об успешном создании заказа
    public By completeOrderWindow = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    //Конструктор
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    //Методы

    public boolean isCompleteOrderWindowDisplayed() {
        try {
            return driver.findElement(completeOrderWindow).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public void choosingAndClickOrderButton(String orderButtonPosition) {
        if ("top".equals(orderButtonPosition)) {
            clickOrderButton();
        } else if ("middle".equals(orderButtonPosition)) {
            clickOrderButtonMiddle();
        } else {
            throw new IllegalArgumentException("Неизвестная позиция кнопки: " + orderButtonPosition);
        }
    }

    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void selectMetroStation(String metroStation) {
        driver.findElement(metroStationSelect).sendKeys(metroStation);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(metroStationInputValue)).click().perform();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhone).sendKeys(phoneNumber);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void findAndClickWhen(int option) {
        new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(dateInput).click();
        switch (option) {
            case 1:
                driver.findElement(getDate14July2025()).click();
                break;
            case 2:
                driver.findElement(getDate15July2025()).click();
                break;
        }
    }

    public void chooseRentalPeriod(int numberOfDays) {
        driver.findElement(rentalPeriod).click();
        switch (numberOfDays) {
            case 1:
                driver.findElement(getNumberOfDaysOne()).click();
                break;
            case 2:
                driver.findElement(getNumberOfDaysTwo()).click();
                break;
        }
    }

    public void clickMiddleButtonOrder() {
        driver.findElement(orderButtonForm).click();
    }

    public void chekOrder() {
        driver.findElement(checkPlaceOrder);
    }

    public void clickButtonYes() {
        driver.findElement(yesButton).click();
    }

    //Геттеры
    public By getDate14July2025() {
        return date14July2025;
    }

    public By getDate15July2025() {
        return date15July2025;
    }

    public By getNumberOfDaysOne() {
        return numberOfDaysOne;
    }

    public By getNumberOfDaysTwo() {
        return numberOfDaysTwo;
    }


    // Метод для заполнения формы заказа (повторяющиеся действия)
    public void fillOrderForm(String name, String surname, String address, String metroStation, String phoneNumber, int option, int numberOfDays) {
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.selectMetroStation(metroStation);
        orderPage.setPhoneNumber(phoneNumber);
        orderPage.clickNextButton();
        orderPage.findAndClickWhen(option);
        orderPage.chooseRentalPeriod(numberOfDays);
        orderPage.clickMiddleButtonOrder();
        orderPage.chekOrder();
        orderPage.clickButtonYes();
    }

}

