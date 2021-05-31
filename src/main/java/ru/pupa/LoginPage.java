package ru.pupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


final public class LoginPage {
    //Конструктор класса, ответственного за инициализацию полей класса
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void inputLogin(String login) {
        driver.findElement(By.className("email-input")).sendKeys(login);
    } //Метод ввода логина
    public void inputPasswd(String passwd) {
        driver.findElement(By.className("password-input")).sendKeys(passwd);
    } //Метод ввода пароля
    public void clickLoginBtn() {
        driver.findElement(By.className("second-button")).click();
    } //Метод нажатяи кнопки входа
    public void clickForvardBtn() {
        driver.findElement(By.className("icon-next")).click();
    } //Метод нажатяи кнопки перехода к паролю
}
