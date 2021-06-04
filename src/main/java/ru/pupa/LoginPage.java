package ru.pupa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



final public class LoginPage extends InitFields {
    //Задаем локаторы для страницы
    private static final By EMAIL_LOCATOR = By.className("email-input");
    private static final By PASSWORD_LOCATOR = By.className("password-input");
    private static final By BUTTON_LOCATOR = By.className("second-button");
    private static final By NEXT_ICON_LOCATOR =By.className("icon-next");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void inputLogin(String login) {
        driver.findElement(EMAIL_LOCATOR).sendKeys(login);
    } //Метод ввода логина
    public void inputPasswd(String passwd) {
        driver.findElement(PASSWORD_LOCATOR).sendKeys(passwd);
    } //Метод ввода пароля
    public void clickLoginBtn() {
        driver.findElement(BUTTON_LOCATOR).click();
    } //Метод нажатяи кнопки входа
    public void clickForvardBtn() {
        driver.findElement(NEXT_ICON_LOCATOR).click();
    } //Метод нажатяи кнопки перехода к паролю
}
