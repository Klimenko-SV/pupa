package ru.pupa;

import org.junit.Test;


public class DeleteTest extends InOutOfTest {

    @Test
    final public void deleteTest() {
        loginPage = new LoginPage(driver);
        //вводим логин-пароль
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();
        //нажимаем кнопку "отправленные"
        profilePage = new ProfilePage(driver);
        profilePage.clickSendetBtn();
        //выделяем и удаляем последнее отправленное письмо
        sendetPage = new SendetPage(driver);
        sendetPage.checkLetter();
        sendetPage.delLetter();
        //ждем, чтобы посмотреть, что все верно (это не для тестирования, это для меня)
        WaitDownload.wait(5);
    }
}
