package ru.pupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

final public class ProfilePage extends InitFields {
    //Задаем локаторы для страницы
    private static final By USER_NAME_LOCATOR = By.className("ph-project__user-name");
    private static final By SENDET_LOCATOR = By.linkText("Отправленные");
    private static final By WRITE_LETTER_LOCATOR = By.className("compose-button");
    private static final By SEND_TO_LOCATOR = By.className("container--H9L5q");
    private static final By CLOSE_LOCATOR = By.xpath("//*[@title='Закрыть']");
    private static final By PATTERN_LOCATOR = By.xpath("//div[.='Шаблоны']");
    private static final By MY_PATTERN_LOCATOR = By.xpath("//span[.='-- Сергей Клименко']");
    private static final By SEND_LOCATOR = By.xpath("//*[@title='Отправить']");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    //метод для получения имени пользователя из меню пользователя
    public String getUserMail() {
        String uMail = driver.findElement(USER_NAME_LOCATOR).getText();
        return uMail; }
    //метод для нажатия кнопки "оправленные"
    public void clickSendetBtn() {
        driver.findElement(SENDET_LOCATOR).click();
    }
    //метод для нажатия кнопки "написать письмо"
    public void writeLetter() {
        driver.findElement(WRITE_LETTER_LOCATOR).click();
        driver.switchTo().activeElement();
    }
    //метод заполнения поля "Кому"
    public void RecipientArea(String sendTo) {
        driver.findElement(SEND_TO_LOCATOR).sendKeys(sendTo);
    }
    //метод для нажатия кнопки "закрыть окно отправки сообщения"
    public void closeButton() {
        driver.findElement(CLOSE_LOCATOR).click();
        driver.switchTo().activeElement();
    }
    //метод для нажатия ссылки "шаблоны"
    public void patternBtnClick() {
        driver.findElement(PATTERN_LOCATOR).click();
    }
    //метод для нажатия ссылки нужного шаблона
    public void myPatternClick() {
        List<WebElement> list = driver.findElements(MY_PATTERN_LOCATOR);
        list.get(1).click();
    }
    //метод нажатия кнопки "отправить"
    public void sendLetterClick() {
        driver.findElement(SEND_LOCATOR).click();
    }
}