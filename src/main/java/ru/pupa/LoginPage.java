package ru.pupa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    //Конструктор класса, ответственного за инициализацию полей класса
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/input") //Находим поле с вводом логина
    private WebElement loginField;

    @FindBy(xpath = "/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/button[1]") //Находим кнопку "Войти"
    private WebElement forvardBtn;

    @FindBy(xpath = "/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/input") //Находим поле с вводом пароля
    private WebElement passwdField;

    @FindBy(xpath = "/html/body/main/div[2]/div[1]/div[1]/div[2]/form[1]/button[2]") //Находим кнопку "Войти"
    private WebElement loginBtn;

    public void inputLogin(String login) { loginField.sendKeys(login); } //Метод ввода логина
    public void inputPasswd(String passwd) { passwdField.sendKeys(passwd); } //Метод ввода пароля
    public void clickLoginBtn() { loginBtn.click(); } //Метод нажатяи кнопки входа
    public void clickForvardBtn() { forvardBtn.click(); } //Метод нажатяи кнопки перехода к паролю
}
