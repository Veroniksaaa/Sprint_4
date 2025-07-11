package PajeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;

    //Кнопка закрытия плашки о cookie
    public By cookieButton = By.className("App_CookieButton__3cvqF");
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
    public By metroStationSelect= By.xpath(".//input[@class='select-search__input']");
    //Поле выбора станции
    public By metroStationInputValue = By.className("select-search__value");
    //Поле Телефон
    public By inputPhone = By.xpath(".//input[@*='* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    public By nextButton = By.xpath(".//button[text()='Далее']");

    //Поля формы заказа вторая часть
    // Поле выбора даты
    public By dateInput = By.xpath(".//input[@*='* Когда привезти самокат");
    //Кнопка даты календаря (день)
    public By dateWhen = By.xpath(".//div[contains(@class, 'react-datepicker__day--selected')]");
    //Поле срок аренды
    public By rentalPeriodBox = By.xpath(".//input[@*='* Срок аренды']");
    //Выбор срока аренды
    public By rentalPeriod = By.xpath(".//div(@class='Dropdown-placeholder']");
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
        this.driver = driver;
    }

    //Методы

    public boolean isCompleteOrderWindowDisplayed() {
        try {
            return driver.findElement(completeOrderWindow).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void findCompleteOrderWindow() {
        driver.findElement(completeOrderWindow);
    }

    public void clickButtonYes() {
        driver.findElement(yesButton).click();
    }

    public void chekOrder() {
        driver.findElement(checkPlaceOrder);
    }
    public void clickMiddleButtonOrder() {
        driver.findElement(orderButtonForm).click();
    }

    public void chooseRentalPeriod() {
        driver.findElement(rentalPeriod).click();
    }

    public void chooseRentalPeriodBox() {
        driver.findElement(rentalPeriodBox).click();
    }

    public void chooseDateWhen() {
        driver.findElement(dateWhen).click();
    }

    public void findAndClickWhen() {
        driver.findElement(dateInput).click();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhone).sendKeys(phoneNumber);
    }

    public void selectMetroStation() {
        driver.findElement(metroStationInputValue).click();
    }

    public void findAndClickMetroInput(String metroStation) {
        driver.findElement(metroStationSelect).sendKeys(metroStation);
    }

    public void setAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
    }

    public void setSurname(String surname) {
        driver.findElement(inputSurname).sendKeys(surname);
    }

    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickOrderButtonBottom() {
        driver.findElement(orderButtonMiddle).click();
    }
    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }
    public void clickOrderButtonMiddle() {
        driver.findElement(orderButtonMiddle).click();
    }
    public void openPage() {
        driver.get(URL);
    }
    }
