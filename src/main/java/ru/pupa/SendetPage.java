package ru.pupa;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


final public class SendetPage extends InitFields {
    //Задаем локаторы для страницы
    private static final By CHECK_LETTER_LOCATOR = By.className("llc");
    private static final By DELETE_LETTER_LOCATOR = By.xpath("//*[@title='Удалить']");

    public SendetPage(WebDriver driver) {
        super(driver);
    }

    //метод нажатия на чекбокс "выделить последнее отправленное письмо"
    final public void checkLetter() {
        driver.findElement(CHECK_LETTER_LOCATOR).click(); }
    //метод нажатия на чекбокс "Удалить"
    final public void delLetter() {
        driver.findElement(DELETE_LETTER_LOCATOR).click(); }
}
