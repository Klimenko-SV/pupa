package ru.pupa;

import com.sun.source.tree.ParenthesizedTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendetPage {
    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public SendetPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //ищем локатор чекбокса с "выделеть все письма"
    @FindBy(xpath = "//*[contains(@class, 'llc')]")
    private WebElement checkBoxLetter;

    //ищем локатор чекбокса с "Удалить"
    @FindBy(xpath = "//*[contains(@data-title-shortcut, 'Del')]")
    private WebElement delBoxLetter;


    //метод нажатия на чекбокс "выделить последнее отправленное письмо"
    public void checkLetter() { checkBoxLetter.click(); }

    //метод нажатия на чекбокс "Удалить"
    public void delLetter() { delBoxLetter.click(); }



}
