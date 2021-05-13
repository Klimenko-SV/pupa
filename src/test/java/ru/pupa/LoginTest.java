package ru.pupa;

import org.junit.Assert;
import org.junit.Test;


public class LoginTest extends InOutOfTest{

    @Test
    public void loginTest() {
        //значение login/password берутся из файла настроек
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        //вводим пароль
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //получаем отображаемый логин
        String user = profilePage.getUserMail();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }
}
