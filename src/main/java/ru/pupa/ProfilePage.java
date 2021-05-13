package ru.pupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProfilePage {
    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //метод для получения имени пользователя из меню пользователя
    public String getUserMail() {
        String uMail = driver.findElement(By.className("ph-project__user-name")).getText();
        return uMail; }

    //метод для нажатия кнопки "оправленные"
    public void clickSendetBtn() {
        driver.findElement(By.linkText("Отправленные")).click();
    }

    //метод для нажатия кнопки выхода из аккаунта
    public void userLogout() {
        driver.findElement(By.className("ph-project__user-name")).click();
        driver.findElement(By.className("ph-text")).click(); }

    //метод для нажатия кнопки "написать письмо"
    public void writeLetter() {
        driver.findElement(By.className("compose-button")).click();
        driver.switchTo().activeElement();
    }

    //метод заполнения поля "Кому"
    public void RecipientArea(String sendTo) {
        driver.findElement(By.className("container--H9L5q")).sendKeys(sendTo);
    }

    //метод для нажатия кнопки "закрыть окно отправки сообщения"
    public void closeButton() {
        driver.findElement(By.xpath("//*[@title='Закрыть']")).click();
        driver.switchTo().activeElement();
    }
    //метод для нажатия ссылки "шаблоны"
    public void patternBtnClick() {
        driver.findElement(By.className("text--2BGkj")).click();
    }

    //метод для нажатия ссылки нужного шаблона
    public void myPatternClick() {
        List<WebElement> list = driver.findElements(By.className("ellipsis--2wDr9"));
        list.get(1).click();
    }
    //метод нажатия кнопки "отправить"
    public void sendLetterClick() {
        driver.findElement(By.xpath("//*[@title='Отправить']")).click();
    }
}