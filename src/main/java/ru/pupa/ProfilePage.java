package ru.pupa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProfilePage {
    //конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //определение локатора меню пользователя
    @FindBy(xpath = "//*[contains(@class, 'ph-project__user-name svelte-h2te2i')]")
    private WebElement userMail;

    //определение локатора кнопки выхода из аккаунта
    @FindBy(xpath = "//*[contains(@class, 'ph-text svelte-1fv44hj')]")
    private WebElement logoutBtn;

    //определяем локатор кнопки "написать письмо"
    @FindBy(xpath = "//*[contains(@class, 'compose-button')]")
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

    //находим локатор кнопки "отправленные"
    @FindBy(xpath = "//*[contains(@href, '/sent/')]")
    private WebElement sendetBtn;

    //находим локатор ссылки "шаблоны"
    @FindBy(xpath = "//*[contains(@class, 'text--2BGkj')]")
    private WebElement patternBtn;

    //находим локатор нужного шаблона
    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/div[2]/div[2]/div/div/div/span[2]")
    private WebElement myPattern;

    //Находим локатор кнопки "Отправить"
    @FindBy(xpath = "//*[contains(@data-title-shortcut, 'Ctrl+Enter')]")
    private WebElement sendLetterBtn;

    //метод для получения имени пользователя из меню пользователя
    public String getUserMail() {
        String uMail = userMail.getText();
        return uMail; }

    //метод для нажатия кнопки "оправленные"
    public void clickSendetBtn() {
        sendetBtn.click(); }

    //метод для нажатия кнопки выхода из аккаунта
    public void userLogout() {
        userMail.click();
        logoutBtn.click(); }

    //метод для нажатия кнопки "написать письмо"
    public void writeLetter() {
        writeBtn.click();
        driver.switchTo().activeElement();
    }

    //метод заполнения поля "Кому"
    public void RecipientArea(String sendTo) { sendToArea.sendKeys(sendTo); }

    //метод заполнения поля "тема"
    public void SubjArea(String subject){
        subjectText.sendKeys(subject);
    }

    //метод заполнения поля "текст письма"
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
    //метод для нажатия ссылки "шаблоны"
    public void patternBtnClick() { patternBtn.click(); }

    //метод для нажатия ссылки нужного шаблона
    public void myPatternClick() {
        myPattern.click();

    }
    //метод нажатия кнопки "отправить"
    public void sendLetterClick() { sendLetterBtn.click(); }
}