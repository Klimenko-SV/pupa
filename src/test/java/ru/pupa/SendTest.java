package ru.pupa;

import org.junit.Test;

public class SendTest extends InOutOfTest {

    @Test
    final public void sendTest() {
        //Заходим на сайт, логинимся
        loginPage = new LoginPage(driver);
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.clickForvardBtn();
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();

        //Пишем новое письмо из стандартного шаблона
        profilePage = new ProfilePage(driver);
        profilePage.writeLetter();
        profilePage.patternBtnClick();
        WaitDownload.wait(3);
        profilePage.myPatternClick();
        WaitDownload.wait(3);
        String mailRecipient = ConfProperties.getProperty("sendto");
        profilePage.RecipientArea(mailRecipient);
        profilePage.sendLetterClick();
        WaitDownload.wait(1);
        profilePage.closeButton();
        //ждем, чтобы посмотреть, что все верно (это не для тестирования, это для меня)
        WaitDownload.wait(5);
    }
}
