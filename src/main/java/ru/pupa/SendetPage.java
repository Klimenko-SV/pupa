package ru.pupa;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

final public class SendetPage {
    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public SendetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //метод нажатия на чекбокс "выделить последнее отправленное письмо"
    final public void checkLetter() {
        driver.findElement(By.className("llc")).click(); }

    //метод нажатия на чекбокс "Удалить"
    final public void delLetter() {
        driver.findElement(By.className("ico_16-delete")).click(); }



}
