package ru.pupa;

import org.junit.Test;


public class DeleteTest extends InOutOfTest {

    @Test
    final public void deleteTest() {
        //Заходим на страницу, логинимся
        loginPage = new LoginPage(driver);
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        //Переходим на страницу отправленных писем
        profilePage = new ProfilePage(driver);
        profilePage.clickSendetBtn();

        //Удаляем последнее отправленное письмо
        sendetPage = new SendetPage(driver);
        sendetPage.checkLetter();
        sendetPage.delLetter();
        //ждем, чтобы посмотреть, что все верно (это не для тестирования, это для меня)
        WaitDownload.wait(5);
    }
}
