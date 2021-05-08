package ru.pupa;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendLetterPage {
    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public SendLetterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    //ищем локатор чекбокса с "выделеть все письма"
    @FindBy(xpath = "//*[contains(@class, 'button2')]")
    private WebElement deleteBtn;
}
