package ru.pupa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import java.util.Set;


public class ProfilePage {
    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //определение локатора меню пользователя
    @FindBy(xpath = "//*[contains(@class, 'x-ph__menu__button__text x-ph__menu__button__text_auth')]")
    private WebElement userMail;

    //определение локатора кнопки выхода из аккаунта
    @FindBy(xpath = "/html/body/div[3]/div[1]/table/tbody/tr/td[2]/div[1]/table/tbody/tr/td[2]")
    private WebElement logoutBtn;

    //определяем локатор кнопки "написать письмо"
    @FindBy(xpath = "//*[contains(@class, 'compose-button compose-button_white compose-button_base compose-button_compact compose-button_with-dropdown js-shortcut')]")
    private WebElement writeBtn;

    //Находим локатор поля "Кому"
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div/label/div/div/input")
    private WebElement sendToArea;

    //Наодим локатор поля "Тема"
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")
    private WebElement subjectText;

    //Находим локатор поля тела сообщения
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]")
    private WebElement letterText;

    //находим локатор кнопки кнопки "отправить"
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]")
    private WebElement sendBtn;

    //находим локатор кнопки "закрыть всплывающее окно"
    @FindBy(xpath = "/html/body/div[9]/div/div/div[2]/div[2]/div/div/div[1]/span")
    private WebElement closeBtn;


    //метод для получения имени пользователя из меню пользователя
    public String getUserMail() {
        String uMail = userMail.getText();
        return uMail; }

    /*метод для нажатия кнопки меню пользователя
    public void entryMenu() {
        userMenu.click(); }
*/
    //метод для нажатия кнопки выхода из аккаунта
    public void userLogout() {
        logoutBtn.click(); }

    //метод для нажатия кнопки "написать письмо"
    public void writeLetter() {
        writeBtn.click();
    }
    //метод заполнения поля "Кому"
    public void RecipientArea(String sendTo) {
        driver.switchTo().activeElement();
        sendToArea.sendKeys(sendTo);
    }
    public void SubjArea(String subject){
        subjectText.sendKeys(subject);
    }
    public void TextOfLetter(String letter){
        letterText.sendKeys(letter);
    }

    //метод для нажатия кнопки "отправить письмо"
    public void sendButton() { sendBtn.click(); }

    //метод для нажатия кнопки "закрыть окно отправки сообщения"
    public void closeButton() {
        closeBtn.click();
        driver.switchTo().activeElement();
    }
}