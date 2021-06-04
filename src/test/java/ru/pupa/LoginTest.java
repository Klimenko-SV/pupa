package ru.pupa;

import org.junit.Assert;
import org.junit.Test;



public class LoginTest extends InOutOfTest {

    @Test
    final public void loginTest() {
        //Заходим на страницу, логинимся
        loginPage = new LoginPage(driver);
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        //Сверяем, что зашли в нужный почтовый ящик
        profilePage = new ProfilePage(driver);
        String user = profilePage.getUserMail();
        Assert.assertEquals(ConfProperties.getProperty("login"), user);
    }
}
